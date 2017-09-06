package com.baidu.ueditor.upload;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.shifeng.seller.ali.AliyunOSSFactory;
import com.shifeng.seller.ali.AliyunOSSProperties;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BinaryUploader {

	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		FileItemStream fileStream = null;
		boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}

		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

        if ( isAjaxUpload ) {
            upload.setHeaderEncoding( "UTF-8" );
        }

		try {
			FileItemIterator iterator = upload.getItemIterator(request);

			while (iterator.hasNext()) {
				fileStream = iterator.next();

				if (!fileStream.isFormField())
					break;
				fileStream = null;
			}

			if (fileStream == null) {
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}
			String savePath = (String) conf.get("savePath");
			String originFileName = fileStream.getName();
			String suffix = FileType.getSuffixByFilename(originFileName);

			originFileName = originFileName.substring(0,
					originFileName.length() - suffix.length());
			savePath = savePath + suffix;

			long maxSize = ((Long) conf.get("maxSize")).longValue();

			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			savePath = PathFormat.parse(savePath, originFileName);

			String physicalPath = (String) conf.get("rootPath") + savePath;

			InputStream is = fileStream.openStream();
			State storageState = StorageManager.saveFileByInputStream(is,
					physicalPath, maxSize);
			is.close();

			if (storageState.isSuccess()) {
				String url=PathFormat.format(savePath);
				storageState.putInfo("url", url);
				storageState.putInfo("type", suffix);
				storageState.putInfo("original", originFileName + suffix);
				InputStream is2 = new FileInputStream(new File(physicalPath));
				String aliurl=aliyun(is2,url);
				if(!StringUtils.isEmpty(aliurl)){
					storageState.putInfo("url", aliurl);
				}
				is2.close();
			}

			return storageState;
		} catch (FileUploadException e) {
			return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
	private static String  aliyun(InputStream fileInputStream, String url){
			//文件同步上传到阿里云
			OSSClient client = AliyunOSSFactory.getOSSClient();
			try {
				// 创建上传Object的Metadata
				ObjectMetadata meta = new ObjectMetadata();
				// 必须设置ContentLength
				meta.setContentLength(Integer.parseInt(String.valueOf(fileInputStream.available())));
				// 上传Object.
				PutObjectResult result = client.putObject(AliyunOSSProperties.bucketName, url, fileInputStream, meta);
				 return AliyunOSSProperties.imgVisitURL + url;
			} catch (FileNotFoundException e) {
			} catch (NumberFormatException e) {
			} catch (IOException e) {
			}
			return null;
	}
}

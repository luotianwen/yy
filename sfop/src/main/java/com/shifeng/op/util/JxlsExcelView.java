package com.shifeng.op.util;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by yongshi on 2017/3/28.
 */
public class JxlsExcelView extends AbstractView {
    private static final String CONTENT_TYPE = "application/vnd.ms-excel";

    private String templatePath;
    private String exportFileName;

    /**
     * @param templatePath   模版相对于当前classpath路径
     * @param exportFileName 导出文件名
     */
    public JxlsExcelView(String templatePath, String exportFileName) {
        this.templatePath = templatePath;
        if (exportFileName != null) {
            try {
                exportFileName = URLEncoder.encode(exportFileName, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.exportFileName = exportFileName;
        setContentType(CONTENT_TYPE);
    }
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Context context = new Context(model);
        response.setContentType(getContentType());
        response.setHeader("content-disposition",
                "attachment;filename=" + exportFileName + ".xls");
        ServletOutputStream os = response.getOutputStream();
        ServletContext application = request.getSession().getServletContext();
        String savePath = application.getRealPath("/") + templatePath;
        //System.out.println(savePath);
        InputStream is=new FileInputStream(new File(savePath)) ;
        //InputStream is = getClass().getClassLoader().getResourceAsStream(templatePath);
        JxlsHelper.getInstance().processTemplate(is, os, context);
        is.close();
    }
}

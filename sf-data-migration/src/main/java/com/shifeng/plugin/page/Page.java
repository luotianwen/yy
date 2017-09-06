package com.shifeng.plugin.page;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shifeng.util.UrlParamsFormatUtil;
 
/**
 * 
 * @author WinZhong
 *
 * @param <T>
 */
public class Page<T> {
	
	@JsonIgnore
	private int pageSize = 10; //每页显示记录数
	private int totalPage;		//总页数
	private int totalResult;	//总记录数
	private int currentPage = 1;	//当前页
	private int currentResult;	//当前记录起始索引
	@JsonIgnore
	private boolean entityOrField;	//true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	@JsonIgnore
	private String pageStr;		//最终页面显示的底部翻页导航，详细见：getPageStr();
	@JsonIgnore
	private String pageItem;		//最终页面显示的底部翻页导航，详细见：getPageStr();
	@JsonIgnore
	private T t;		//参数
	private Object resultList;		//返回结果
	 
	public Page(){
		try {
			this.pageSize = 10;
		} catch (Exception e) {
			this.setPageSize(10);
		}
	}
	public int getTotalPage() {
	/*	if(totalResult%pageSize==0)
			totalPage = totalResult/pageSize;
		else
			totalPage = totalResult/pageSize+1;*/
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getTotalResult() {
		return totalResult;
	}
	
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
		setTotalPage(this.totalResult % this.pageSize == 0 ? this.totalResult / this.pageSize : this.totalResult / this.pageSize + 1);
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public void setPage(int page) {
		this.currentPage = page;
	}
	
	public String getPageStr() {
		
		
		StringBuffer sb = new StringBuffer();
		if(totalResult>0){
			sb.append("	<div class=\"pagnation\" id=\"pagnation\">\n");
			if(currentPage==1){
				sb.append("	<a class=\"page\">首页</a>\n");
				sb.append("	<a class=\"page-prev\">上一页</a>\n");
			}else{
				sb.append("	<a class=\"page\" onclick=\"nextPage(1)\">首页</a>\n");
				sb.append("	<a class=\"page-prev\" onclick=\"nextPage("+(currentPage-1)+")\">上一页</a>\n");
			}
			int showTag = 5;//分页标签显示数量
			int startTag = 1;
			if(currentPage>showTag){
				startTag = currentPage-1;
			}
			int endTag = startTag+showTag-1;
			for(int i=startTag; i<=totalPage && i<=endTag; i++){
				if(currentPage==i)
					sb.append(" <a class=\"current\">"+i+"</a>\n");
				else
					sb.append("<a onclick=\"nextPage("+i+")\">"+i+"</a>\n");
			}
			if(currentPage==totalPage){
				sb.append("	<a class=\"page-next\">下一页</a>\n");
				sb.append("	<a class=\"page\">尾页</a>\n");
			}else{
				sb.append("	<a class=\"page-next\" onclick=\"nextPage("+(currentPage+1)+")\">下一页</a>\n");
				sb.append("	<a class=\"page\" onclick=\"nextPage("+totalPage+")\">尾页</a>\n");
			}
sb.append("	<span>"+totalResult+"条记录"+currentPage+"/"+totalPage+"页</span>\n");
			
			sb.append("</div>\n");
			sb.append("<div class=\"pagnation-tips\">提示：支持键盘“← →”键翻页</div>");
			sb.append("<script type=\"text/javascript\">\n");
			
			//换页函数
			sb.append("function nextPage(page){");
			sb.append("	if(true && document.forms[0]){\n");
			sb.append("		var url = document.forms[0].getAttribute(\"action\");\n");
			sb.append("		if(url.indexOf('?')>-1){url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + page + \"&" +(entityOrField?"showCount":"page.showCount")+"="+pageSize+"\";\n");
			sb.append("		document.forms[0].action = url;\n");
			sb.append("		document.forms[0].submit();\n");
			sb.append("	}else{\n");
			sb.append("		var url = document.location+'';\n");
			sb.append("		if(url.indexOf('?')>-1){\n");
			sb.append("			if(url.indexOf('currentPage')>-1){\n");
			sb.append("				var reg = /currentPage=\\d*/g;\n");
			sb.append("				url = url.replace(reg,'currentPage=');\n");
			sb.append("			}else{\n");
			sb.append("				url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";\n");
			sb.append("			}\n");
			sb.append("		}else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + page + \"&" +(entityOrField?"showCount":"page.showCount")+"="+pageSize+"\";\n");
			sb.append("		document.location = url;\n");
			sb.append("	}\n");
			sb.append("}\n");
			
			//键盘“← →”键翻页
			sb.append("    	    	var pagnation=$(\"#pagnation\");\n");
			sb.append("    	    	$(document).on(\"keydown\",function(event){\n");
			sb.append("    	    		switch(event.keyCode){\n");
			sb.append("    	    			 case 37 : pagnation.find(\".page-prev\").trigger(\"click\");break;\n");
			sb.append("    	    			 case 39 : pagnation.find(\".page-next\").trigger(\"click\");break\n");
			sb.append("    	    		}\n");
			sb.append("    	    	});\n");
			sb.append("</script>\n");
			 
		
/*		if(resultList != null){
			return "";
		}
		String urlParams = UrlParamsFormatUtil.getUrlParamsByRequest(request);
		if(StringUtils.isEmpty(urlParams)){
			urlParams = request.getRequestURI()+"?page=";
		}else{
			urlParams = request.getRequestURI()+"?"+ urlParams+ "&page=";
		}
		
		StringBuffer sb = new StringBuffer();
		if(totalResult>0){
			sb.append("	<div class=\"page\">\n");
			if(currentPage==1){
				sb.append("	<a href=\"javascript:\" title=\"上一页\" class=\"pn-prev\">上一页</a>\n");
			}else{
				sb.append("	<a href=\""+urlParams+(currentPage-1)+"\" title=\"上一页\" class=\"pn-prev\">上一页</a>\n");
			}
			if(currentPage>4 && totalPage > 5){
				sb.append("	<a href=\""+urlParams+1+"\">"+1+"</a>\n");
				sb.append("	<span class=\"pn-break\">...</span>\n");
			}
			int showTag = 5;//分页标签显示数量
			int startTag = 1;
			if(currentPage>=showTag){
				startTag = currentPage-1;
			}
			if(startTag > 4 && startTag >= totalPage-4){
				startTag = totalPage-4;
			}
			int endTag = startTag+showTag-1;
			for(int i=startTag; i<=totalPage && i<=endTag; i++){
				if(currentPage==i)
					sb.append("<a href=\"javascript:\" class=\"cur\">"+i+"</a>\n");
				else
					sb.append("<a href=\""+urlParams+i+"\">"+i+"</a>\n");
			}
			if(currentPage==totalPage){
				sb.append("	<a href=\"javascript:\" title=\"下一页\" class=\"pn-next\">下一页</a>\n");
			}else{
				if(totalPage-4 >= currentPage){
					sb.append("	<span class=\"pn-break\">...</span>\n");
					sb.append("	<a href=\""+urlParams+totalPage+"\">"+totalPage+"</a>\n");
				}
				sb.append("	<a href=\""+urlParams+(currentPage+1)+"\" title=\"下一页\" class=\"pn-next\">下一页</a>\n");
			}
			sb.append("	</div>\n");
			 */
		}
		pageStr = sb.toString();
		return pageStr;
	}
	
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		/*if(pageSize < 10){
			//System.err.println("************我被设置*************"+pageSize);
			this.pageSize = 10;
		}else{*/
			this.pageSize = pageSize;
		/*}*/
	}
	
	public int getCurrentResult() {
		currentResult = (this.currentPage-1)*getPageSize();
		return currentResult;
	}
	
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	
	public boolean isEntityOrField() {
		return entityOrField;
	}
	
	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	public Object getResultList() {
		return resultList;
	}
	public void setResultList(Object resultList) {
		this.resultList = resultList;
	}
 
	public void setPageItem(String pageItem) {
		this.pageItem = pageItem;
	}
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", totalPage=" + totalPage + ", totalResult=" + totalResult
				+ ", currentPage=" + currentPage + ", currentResult=" + currentResult + ", entityOrField="
				+ entityOrField + ", pageStr=" + pageStr + ", pageItem=" + pageItem + ", t=" + t + ", resultList="
				+ resultList + "]";
	}
  
 
	 
 
	
}

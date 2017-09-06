package com.shifeng.plugin.page;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
 
/**
 * 分页
 * @author WinZhong
 * @param <T>
 */
public class Page<T> {
	
	@JsonIgnore
	@JSONField(serialize=false)
	//每页显示的数量
	private int pageSize = 10;
	//总页数
	private int totalPage;
	//总记录数
	private int totalResult;
	//当前页
	private int currentPage = 1;	
	//当前页面第一个元素在数据库中的行号
	private int startRow;	
	@JsonIgnore
	@JSONField(serialize=false)
	//true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	private boolean entityOrField;
	@JsonIgnore
	@JSONField(serialize=false)
	//查询检索参数
	private T t;
	//返回结果
	private Object resultData;	
    //前一页
    private int prePage;
    //下一页
    private int nextPage;
    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    

    
	 
	public Page(){
		try {
			this.pageSize = 10;
		} catch (Exception e) {
			this.setPageSize(10);
		}
	}
	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * 总页数
	 * @param totalPage
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * 总记录数
	 * @return
	 */
	public int getTotalResult() {
		return totalResult;
	}
	/**
	 * 总记录数
	 * @param totalResult
	 */
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
		//System.out.println("总记录数:"+totalResult);
		//计算设置总页数
		setTotalPage(this.totalResult % this.pageSize == 0 ? this.totalResult / this.pageSize : this.totalResult / this.pageSize + 1);
		//计算设置前一页，后一页
		calcPage();
		//判断页面边界
		judgePageBoudary();
	}
	/**
	 * 当前页
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * 当前页
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public void setPage(int page) {
		this.currentPage = page;
	}
	/**
	 * 每页显示的数量
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 每页显示的数量
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
	}
	
	/**
	 * 当前页面第一个元素在数据库中的行号
	 * @return
	 */
	public int getStartRow() {
		startRow = (this.currentPage-1)*getPageSize();
		return startRow;
	}
	
	/**
	 * 当前页面第一个元素在数据库中的行号
	 * @param startRow
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	
	/**
	 * true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	 * @return
	 */
	public boolean isEntityOrField() {
		return entityOrField;
	}
	
	/**
	 * true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	 * @param entityOrField
	 */
	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}

	/**
	 * 查询检索参数
	 * @return
	 */
	public T getT() {
		return t;
	}

	/**
	 * 查询检索参数
	 * @param t
	 */
	public void setT(T t) {
		this.t = t;
	}
	 
	/**
	 * 返回结果
	 * @return
	 */
	public Object getResultData() {
		return resultData;
	}
	/**
	 * 返回结果
	 * @param resultData
	 */
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
	
	/**
	 * 前一页
	 * @return
	 */
    public int getPrePage() {
        return prePage;
    }

    /**
     * 前一页
     * @param prePage
     */
    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }
 
    /**
     * 计算前一页，后一页
     */
    private void calcPage() {
        if (totalPage > 0) {
            if (currentPage > 1) {
                prePage = currentPage - 1;
            }
            if (currentPage < totalPage) {
                nextPage = currentPage + 1;
            }
        }
    }
	
    /**
     * 下一页
     * @return
     */
    public int getNextPage() {
        return nextPage;
    }
    
    /**
     * 下一页
     * @param nextPage
     */
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }  
 
    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = currentPage == 1;
        isLastPage = currentPage == totalPage;
        hasPreviousPage = currentPage > 1;
        hasNextPage = currentPage < totalPage;
    }
    /**
     * 是否为第一页
     * @return
     */
	public boolean isFirstPage() {
		return isFirstPage;
	}
	/**
	 * 是否为第一页
	 * @param isFirstPage
	 */
	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	/**
	 * 是否为最后一页
	 * @return
	 */
	public boolean isLastPage() {
		return isLastPage;
	}
	/**
	 * 是否为最后一页
	 * @param isLastPage
	 */
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	/**
	 * 是否有前一页
	 * @return
	 */
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	/**
	 * 是否有前一页
	 * @param hasPreviousPage
	 */
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	/**
	 * 是否有下一页
	 * @return
	 */
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	/**
	 * 是否有下一页
	 * @param hasNextPage
	 */
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
    
    
	
}

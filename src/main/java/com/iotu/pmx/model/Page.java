package com.iotu.pmx.model;

import com.iotu.pmx.util.SystemConstant;



/**
 * 分页实体
 * 
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class Page implements java.io.Serializable{

	/**
	 * 总数据量
	 */
	private long totalDataNum = 0;

	/**
	 * 每页显示数据量
	 */
	private int perPageNum = SystemConstant.PER_PAGE_NUM;

	/**
	 * 单位页面显示数据量
	 */
	private int picPageNum = SystemConstant.DEP_PAGE_NUM;

	/**
	 * 总页数
	 */
	private long totalPageNum = 1;

	/**
	 * 当前页数
	 */
	private long page = 1;
	
	//构造方法
	public Page(Long page){
		this.page = page;
	}
	
	//设置当前页数的构造方法
	public Page(){
		
	}

	public long getTotalDataNum() {
		return totalDataNum;
	}

	public void setTotalDataNum(long totalDataNum) {
		this.totalDataNum = totalDataNum;
	}

	public long getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(long totalPageNum) {
		this.totalPageNum = totalPageNum;
	}


	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}


	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public int getPicPageNum() {
		return picPageNum;
	}

	public void setPicPageNum(int picPageNum) {
		this.picPageNum = picPageNum;
	}

}

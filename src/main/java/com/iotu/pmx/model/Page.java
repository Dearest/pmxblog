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
	private int depPageNum = SystemConstant.DEP_PAGE_NUM;

	/**
	 * 总页数
	 */
	private long totalPageNum = 1;

	/**
	 * 当前页数
	 */
	private long currentPageNum = 1;
	
	//构造方法
	public Page(Long currentPageNum){
		this.currentPageNum = currentPageNum;
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

	public long getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(long currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getDepPageNum() {
		return depPageNum;
	}

	public void setDepPageNum(int depPageNum) {
		this.depPageNum = depPageNum;
	}

}

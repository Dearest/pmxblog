package com.iotu.pmx.model;

/**
 * @author 查询或者过滤的关键字 备用
 * 
 */
@SuppressWarnings("serial")
public class SearchParams implements java.io.Serializable{
	/**
	 * 搜索关键字
	 */
	private String searchKey;

	/**
	 * 以栏目来过滤新闻的栏目ID
	 */
	private long filterCol;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 结束时间
	 */
	private String endTime;
	private String visible;
	
	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public long getFilterCol() {
		return filterCol;
	}

	public void setFilterCol(long filterCol) {
		this.filterCol = filterCol;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

}

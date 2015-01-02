package com.iotu.pmx.util;

import com.iotu.pmx.model.Page;



/**
 * 分页工具
 * 
 */
public class PageTools {

	/**
	 * 计算总页数
	 * 
	 * @param page
	 *            分页对象
	 * @throws Exception
	 */
	public static void countTotalPageNum(Page page) throws Exception {
		long totalPageNum = 1;
		if (page.getTotalDataNum() % page.getPerPageNum() > 0) {
			totalPageNum = page.getTotalDataNum() / page.getPerPageNum() + 1;
		} else {
			totalPageNum = page.getTotalDataNum() / page.getPerPageNum();
		}
		if (totalPageNum == 0) {
			totalPageNum = 1;
		}
		page.setTotalPageNum(totalPageNum);
	}

	/**
	 * 计算当前页起始数据索引
	 * 
	 * @param page
	 *            分页对象
	 * @return 起始数据索引值
	 * @throws Exception
	 */
	public static int countLimitStart(Page page) throws Exception {
		Long start = (page.getCurrentPageNum() - 1) * page.getPerPageNum();
		if (start < 0) {
			start = (long) 0;
		}
		return start.intValue();
	}
	
	/**
	 * 计算单位页面显示数据量 即在前台页面显示的新闻的总页数
	 * @param page
	 * @throws Exception
	 */
	public static void countTotalPageNumWithDep(Page page) throws Exception{
		long totalPageNum = 1;
		if (page.getTotalDataNum() % page.getDepPageNum() > 0) {
			totalPageNum = page.getTotalDataNum() / page.getDepPageNum() + 1;
		} else {
			totalPageNum = page.getTotalDataNum() / page.getDepPageNum();
		}
		if (totalPageNum == 0) {
			totalPageNum = 1;
		}
		page.setTotalPageNum(totalPageNum);
	}
	
	/**
	 *     以单位页面显示数据量  计算当前页起始数据索引
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public static int countLimitStartWithDep(Page page) throws Exception{
		Long start = (page.getCurrentPageNum() - 1) * page.getDepPageNum();
		if (start < 0) {
			start = (long) 0;
		}
		return start.intValue();
	}
}

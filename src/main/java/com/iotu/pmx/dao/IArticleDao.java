package com.iotu.pmx.dao;

import java.util.List;

import com.iotu.pmx.model.Article;
import com.iotu.pmx.model.Page;
import com.iotu.pmx.model.SearchParams;



public interface IArticleDao {
	

	/**
	 * 得到博文列表 默认以日期先后排序
	 * @param page
	 * @param searchParams
	 * @return
	 * @throws Exception
	 */
	public List<Article> getArticles(Page page,SearchParams searchParams) throws Exception;
	
	/**
	 * 保存博文
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public Article saveArticle(Article article) throws Exception;
	
	/**
	 * 删除博文
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public String delArticle(Article article) throws Exception;
	
	/**
	 * 以Id查找content
	 * @return
	 * @throws Exception
	 */
	public Article findArticleById(Article article) throws Exception;
	
	/**
	 * 给文章点赞
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public Article starArticle(Article article) throws Exception;
}

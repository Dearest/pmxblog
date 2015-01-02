package com.iotu.pmx.service.impl;

import java.util.List;

import com.iotu.pmx.dao.IArticleDao;
import com.iotu.pmx.model.Article;
import com.iotu.pmx.model.Page;
import com.iotu.pmx.model.SearchParams;
import com.iotu.pmx.service.IArticleService;

public class ArticleServiceImpl implements IArticleService{
	private IArticleDao articleDao;
	
	public List<Article> getArticles(Page page, SearchParams searchParams)
			throws Exception {
		
		return articleDao.getArticles(page, searchParams);
	}

	public Article saveArticle(Article article) throws Exception {
		return articleDao.saveArticle(article);
	}

	public String delArticle(Article article) throws Exception {
		// TODO 删除没有实现
		return null;
	}

	public Article findArticleById(Article article) throws Exception {
		
		return articleDao.findArticleById(article);
	}

	public Article starArticle(Article article) throws Exception {
		
		return articleDao.starArticle(article);
	}


	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}



}

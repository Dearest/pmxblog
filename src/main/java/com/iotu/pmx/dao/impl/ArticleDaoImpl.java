package com.iotu.pmx.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.iotu.pmx.dao.IArticleDao;
import com.iotu.pmx.model.Article;
import com.iotu.pmx.model.Page;
import com.iotu.pmx.model.SearchParams;
import com.iotu.pmx.util.PageTools;
import com.iotu.pmx.util.StringUtils;



public class ArticleDaoImpl implements IArticleDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Article> getArticles(Page page, SearchParams searchParams)
			throws Exception {
		String hql = "FROM Article a WHERE 1=1 ";
		String totalNumHql = "SELECT COUNT(*) FROM Article a WHERE 1=1 "; // 分页总数据量的的查询语句
		if(!StringUtils.empty(searchParams.getSearchKey())){
			totalNumHql += " AND a.title LIKE '%" + searchParams.getSearchKey()+ "%' ";
			hql += " AND a.title LIKE '%" + searchParams.getSearchKey()+ "%' ";
		}
		hql +=" ORDER By a.time desc";
		Query hqlquery = sessionFactory.getCurrentSession().createQuery(hql);
		Query totalQuery = sessionFactory.getCurrentSession().createQuery(totalNumHql);

		page.setTotalDataNum((Long) totalQuery.uniqueResult());
		PageTools.countTotalPageNum(page);
		int start = PageTools.countLimitStart(page);
		return (List<Article>) hqlquery.setFirstResult(start)
				.setMaxResults(page.getPerPageNum()).list();
	}

	public Article saveArticle(Article article) throws Exception {
		sessionFactory.getCurrentSession().save(article);
		return  article;
	}

	public String delArticle(Article article) throws Exception {
		// TODO sql语句
		return null;
	}
	
	public Article findArticleById(Article article) throws Exception {
		
		return (Article) sessionFactory.getCurrentSession().createQuery("FROM Article a WHERE a.articleId = :id").setInteger("id", article.getArticleId()).uniqueResult();
	}

	public Article starArticle(Article article) throws Exception {
		Article queryArticle = (Article) sessionFactory.getCurrentSession().get(Article.class, article.getArticleId());
		String hql = "UPDATE Article a SET a.star = :star WHERE a.articleId = :id";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger("star", queryArticle.getStar()+1).setLong("id", article.getArticleId()).executeUpdate();
		queryArticle.setStar(queryArticle.getStar()+1);
		return queryArticle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> top5Articles() throws Exception {
		String hql = "FROM Article a order by a.star desc";
		
		return ( List<Article> )sessionFactory.getCurrentSession().createQuery(hql).setMaxResults(5).list();
	}


	

}

package com.iotu.pmx.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.iotu.pmx.dao.IPictureDao;
import com.iotu.pmx.model.Page;
import com.iotu.pmx.model.Picture;
import com.iotu.pmx.util.PageTools;

public class PictureDaoImpl implements IPictureDao{
	
    private  SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	public boolean save(Picture picture) throws Exception {
		sessionFactory.getCurrentSession().save(picture);
		if (picture.getPictureId() >= 0) {
			return true;
		}
		
		return false;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Picture> getPictures(Page page) throws Exception {
		String hql = "FROM Picture p WHERE 1=1 ";
		String totalNumHql = "SELECT COUNT(*) FROM Picture p WHERE 1=1 "; // 分页总数据量的的查询语句
		
		hql +=" ORDER By p.pictureId desc";
		
		Query hqlquery = sessionFactory.getCurrentSession().createQuery(hql);
		Query totalQuery = sessionFactory.getCurrentSession().createQuery(totalNumHql);

		page.setTotalDataNum((Long) totalQuery.uniqueResult());
		PageTools.countTotalPageNumForPic(page);
		int start = PageTools.countLimitStartForPic(page);
		return (List<Picture>) hqlquery.setFirstResult(start)
				.setMaxResults(page.getPicPageNum()).list();
	}

}

package com.ydcun.mysql.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ydcun.common.DateUtil;
import com.ydcun.entity.Article;
import com.ydcun.exception.InfoException;

/**
 *文章
 */
@Repository
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements IArticleDao {


	@Override
	public void save(Article article) {
		super.insert(article);
	}

	@Override
	public Article finAricleById(Integer id) throws Exception {
		if(id==null){
			throw new InfoException("查询参数不正确");
		}
		return super.findOne(id,Article.class);
	}

	@Override
	public List<Article> finAricleList(Date beginDate, Date endDate) {
		String hql = "from Aricle ";
		if(beginDate!=null){
//			hql+=" and time>'"+DateUtil.getString(beginDate, 'yyyy')+"'";
		}
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.ydcun.mysql.dao.IArticleDao#getAllArticle()
	 */
	@Override
	public List<Article> getAllArticle() {
		String hql = "from Article where state=1";
		return super.findAll(hql);
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.dao.IArticleDao#getAllArticleByCode()
	 */
	@Override
	public List<Article> getAllArticleByCode(String code) {
		String hql = "from Article where status=1 and channel.code='"+code+"'";
		return super.findAll(hql);
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.dao.IArticleDao#findAllArticleByCode(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Article> findAllArticleByCode(String channel, Integer latestN) {
		String hql = "from Article where status=1 and channel.code='"+channel+"' order by id desc";
		Query q = this.getSession().createQuery(hql);
		q.setMaxResults(latestN);
		q.setFirstResult(0);
		return q.list();
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.dao.IArticleDao#getTopList(java.lang.String)
	 */
	@Override
	public List<Article> getTopList(String channel) {
		String hql = "from Article where status=1 and channel.code='"+channel+"' and istop=1 order by id desc";
		Query q = this.getSession().createQuery(hql);
		return q.list();
	}
	

}

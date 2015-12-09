package com.ydcun.mysql.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
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

	@Override
	public void editAricle(Article article) {
		// TODO Auto-generated method stub
		
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
		String hql = "from Article where state=1 and channel.code='"+code+"'";
		return super.findAll(hql);
	}
	

}

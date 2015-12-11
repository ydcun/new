package com.ydcun.mysql.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydcun.entity.Article;
import com.ydcun.exception.InfoException;
import com.ydcun.mysql.dao.IArticleDao;

/**
 *文章
 */
@Service
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
	private IArticleDao articleDaoImpl;
	
	@Override
	public void addArticle(Article article) throws Exception {
		if(article==null){
			throw new InfoException("没有创建文章数据对象！");
		}
		this.articleDaoImpl.save(article);
		
	}
	@Override
	public Article findArticleById(Integer id) throws Exception {
		if(id==null){
			throw new InfoException("查询参数不正确");
		}
		return this.findArticleById(id);
	}

	@Override
	public List<Article> finArticleListBy(Date beginDate, Date endDate) {
		return this.articleDaoImpl.finAricleList(beginDate, endDate);
	}

	@Override
	public void updateZanOrCai(boolean bool,Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Article> findAllArticleByCode(String code) {
		return this.articleDaoImpl.getAllArticleByCode(code);
	}

	@Override
	public List<Article> getArticleList(String key, BigInteger dua_id, String channel, Integer latestN,
			Integer localid) {
		List<Article> articleList = this.articleDaoImpl.findAllArticleByCode(channel,latestN);
		List<Article> tempList = new ArrayList<Article>();
		for(Article ar:articleList){
			if(ar.getId()>localid){
				tempList.add(ar);
			}
		}
		return tempList;
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.service.IArticleService#addViews(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void addViews(String key, Integer dua_id) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.service.IArticleService#addLike(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void addLike(String key, Integer dua_id) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.service.IArticleService#addHate(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void addHate(String key, Integer dua_id) {
		// TODO Auto-generated method stub
		
	}
}

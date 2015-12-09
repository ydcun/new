package com.ydcun.mysql.dao;

import java.util.Date;
import java.util.List;

import com.ydcun.entity.Article;

/**
 *文章
 */
public interface IArticleDao {

	/**
	 * 添加文章
	 */
	public void save(Article article);
	/**
	 * 根据id获取一条记录
	 * @param id
	 * @throws Exception 
	 */
	public Article finAricleById(Integer id) throws Exception;
	
	/**
	 * 查询文章区间内的文章 （begin< ... <=endDate）
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<Article> finAricleList(Date beginDate,Date endDate);
	
	/**
	 * 修改文章记录
	 * @param article
	 */
	public void editAricle(Article article);
	/**
	 * 获取所有记录
	 * @return
	 */
	public List<Article> getAllArticle();
	/**
	 * 根据类别code获取所有的文章
	 * @return
	 */
	public List<Article> getAllArticleByCode(String code);

}

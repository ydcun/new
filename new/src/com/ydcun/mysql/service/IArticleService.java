package com.ydcun.mysql.service;

import java.util.Date;
import java.util.List;

import com.ydcun.entity.Article;

/**
 *新闻文章
 */
public interface IArticleService {
	/**
	 * 添加文章
	 * @throws Exception 
	 */
	public void addArticle(Article article) throws Exception;
	/**
	 * 获取所有的文章
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Article> findAllArticle() throws Exception;
	/**
	 * 根据Id获取一篇文章
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public Article findArticleById(Integer id) throws Exception;
	/**
	 * 根据时间段来查询 (beginDate<...<=endDate)
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<Article> finArticleListBy(Date beginDate,Date endDate);
	/**
	 * 给某文章 点赞 踩踩
	 * @param bool true为赞  flase 踩
	 */
	public void updateZanOrCai(boolean bool,Integer id);
	/**
	 * 根据类别code获取所有的文章
	 * @param code 
	 * @return
	 */
	public List<Article> findAllArticleByCode(String code);

}

package com.ydcun.mysql.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.ydcun.entity.Article;
import com.ydcun.exception.InfoException;

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
	/**
	 * @param key 权限密钥
	 * @param duaBI 用户dua_id
	 * @param channel 类别的code
	 * @param latestN 置顶获取最近多少条的数据
	 * @param localid 客户端最新的文章id
	 * @return
	 * @throws InfoException 
	 */
	public List<Article> getArticleList(String key, BigInteger dua_id, String channel, Integer latestN, Integer localid) throws InfoException;
	/**
	 * 文章阅读数++
	 * @param key 权限密钥
	 * @param dua_id 用户dua_id
	 * @param aid_int 
	 * @throws Exception 
	 * 
	 */
	public void addViews(String key, Integer dua_id, Integer aid_int) throws Exception;
	/**
	 * 文章点赞
	 * @param key
	 * @param dua_id
	 * @param aid_int 
	 */
	public void addLike(String key, Integer dua_id, Integer aid_int) throws Exception;
	/**
	 * 文章点踩
	 * @param key
	 * @param dua_id
	 * @param aid_int 
	 */
	public void addHate(String key, Integer dua_id, Integer aid_int) throws Exception;
	/**
	 * 根据id获取一篇文章
	 * @param key
	 * @param dua_id
	 * @param aid_int
	 * @return
	 * @throws Exception 
	 */
	public Article findArticleById(String key, BigInteger dua_id, Integer aid_int) throws Exception;
	/**
	 * 获取某个分类的头条
	 * @param key
	 * @param dua_id
	 * @param chenn_int
	 * @return
	 * @throws InfoException 
	 */
	public Article findHeadArticle(String key, BigInteger dua_id, String channel) throws InfoException;

}

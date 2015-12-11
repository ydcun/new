package com.ydcun.mysql.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.ydcun.entity.Article;
import com.ydcun.entity.Comment;

/**
 *新闻评论
 */
public interface ICommentService {

	/**
	 * 评论阅读数++
	 * @param key 权限密钥
	 * @param dua_id 用户dua_id
	 * 
	 */
	public void addViews(String key, Integer dua_id);
	/**
	 * 评论点赞
	 * @param key
	 * @param dua_id
	 */
	public void addLike(String key, Integer dua_id);
	/**
	 * 评论点踩
	 * @param key
	 * @param dua_id
	 */
	public void addHate(String key, Integer dua_id);
	/**
	 * 获某文章的评论
	 * @param key
	 * @param dua_id
	 * @param page_int 第几页
	 * @param num_int 每页多少条
	 * @return
	 */
	public List<Comment> getArticleList(String key, BigInteger dua_id, Integer page_int, Integer num_int);
	/**
	 * 添加一个文章评论
	 * @param key
	 * @param article_id
	 * @param content
	 * @param userid_int
	 * @param username
	 * @param location
	 * @param lonlat
	 * @param ip
	 */
	public void addComment(String key, String article_id, String content, BigInteger userid_int, String username,
			String location, String lonlat, String ip);

}

package com.ydcun.mysql.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.ydcun.entity.Article;
import com.ydcun.entity.Comment;
import com.ydcun.exception.InfoException;

/**
 *新闻评论
 */
public interface ICommentService {

	/**
	 * 评论点赞
	 * @param key
	 * @param dua_id
	 * @param comment_int 
	 * @param article_int 
	 * @throws Exception 
	 */
	public void addLike(String key, Integer dua_id, Integer article_int, Integer comment_int) throws Exception;
	/**
	 * 评论点踩
	 * @param key
	 * @param dua_id
	 * @param comment_int 
	 * @param article_int 
	 * @throws Exception 
	 */
	public void addHate(String key, Integer dua_id, Integer article_int, Integer comment_int) throws Exception;
	/**
	 * 获某文章的评论
	 * @param key
	 * @param dua_id
	 * @param page_int 第几页
	 * @param num_int 每页多少条
	 * @param  aid_int 文章id
	 * @return
	 * @throws InfoException 
	 */
	public List<Comment> getArticleList(String key, BigInteger dua_id,Integer aid_int, Integer page_int, Integer num_int) throws InfoException;
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
	 * @throws Exception 
	 */
	public void addComment(String key, Integer article_id, String content, BigInteger userid_int, String username,
			String location, String lonlat, String ip) throws Exception;

}

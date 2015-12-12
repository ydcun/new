/**
 * 
 */
package com.ydcun.mysql.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.smartcardio.ATR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ydcun.common.SendHttpPostUtil;
import com.ydcun.entity.Article;
import com.ydcun.entity.Comment;
import com.ydcun.exception.InfoException;
import com.ydcun.mysql.dao.IArticleDao;
import com.ydcun.mysql.dao.ICommentDao;

/**
 *
 */
@Service
@Transactional
public class CommentServiceImpl implements ICommentService {
	@Autowired
	private ICommentDao commentDaoImpl;

	@Autowired
	private IArticleDao articleDaoImpl;
	/* (non-Javadoc)
	 * @see com.ydcun.mysql.service.ICommentService#addLike(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void addLike(String key, Integer dua_id,Integer article_int,Integer comment_int) throws Exception {
		if(!SendHttpPostUtil.postDuaNew(key, dua_id+"", "read")){
			throw new InfoException("没有权限");
		}
		Comment comm  = this.commentDaoImpl.findComment(comment_int);
		if(comm!=null){
			comm.setLikes(comm.getLikes()==null?1:comm.getLikes()+1);
			this.commentDaoImpl.updateEntity(comm);
		}else{
			throw new InfoException("没有找到该评论");
		}
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.service.ICommentService#addHate(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void addHate(String key, Integer dua_id,Integer article_int,Integer comment_int) throws Exception {
		if(!SendHttpPostUtil.postDuaNew(key, dua_id+"", "read")){
			throw new InfoException("没有权限");
		}
		Comment comm  = this.commentDaoImpl.findComment(comment_int);
		if(comm!=null){
			comm.setHate(comm.getHate()==null?1:comm.getHate()+1);
			this.commentDaoImpl.updateEntity(comm);
		}else{
			throw new InfoException("没有找到该评论");
		}
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.service.ICommentService#getArticleList(java.lang.String, java.math.BigInteger, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Comment> getArticleList(String key, BigInteger dua_id, Integer aid_int, Integer page_int, Integer num_int) throws InfoException {
		if(!SendHttpPostUtil.postDuaNew(key, dua_id+"", "read")){
			throw new InfoException("没有权限");
		}
		if(!SendHttpPostUtil.postDuaNew(key, dua_id+"", "read")){
			throw new InfoException("没有权限");
		} 
		List<Comment> list =  this.commentDaoImpl.findOnePageList(aid_int,page_int,num_int);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.service.ICommentService#addComment(java.lang.String, java.lang.String, java.lang.String, java.math.BigInteger, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void addComment(String key, Integer article_id, String content, BigInteger userid_int, String username,
			String location, String lonlat, String ip) throws Exception {
		if(!SendHttpPostUtil.postDuaNew(key, userid_int+"", "read")){
			throw new InfoException("没有权限");
		}
		Comment comment = new Comment();
		Article atr = this.articleDaoImpl.finAricleById(article_id);
		atr.setComments(atr.getComments()==null?1:atr.getComments()+1);//评论数累加
		comment.setArticle(atr);
		comment.setContent(content);
		comment.setHate(0);
		comment.setIp(ip);
		comment.setLikes(0);
		comment.setLocation(location);
		comment.setLonlat(lonlat);
		comment.setStatus(1);
		comment.setTime(new Date());
		comment.setUserid(userid_int);
		comment.setUsername(username);
		this.commentDaoImpl.insert(comment);
	}

}

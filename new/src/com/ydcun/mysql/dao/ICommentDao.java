/**
 * 
 */
package com.ydcun.mysql.dao;

import java.util.List;

import com.ydcun.entity.Comment;

/**
 * 评论
 *
 */
public interface ICommentDao extends IBaseDao<Comment>{

	/**
	 * 根据id查询评论
	 * @param dua_id
	 * @return
	 */
	public Comment findComment(Integer dua_id);

	/**
	 * 获取一页的数据 
	 * @param page_int 第几页
	 * @param num_int 一页多少条
	 * @param  
	 * @return
	 */
	public List<Comment> findOnePageList(Integer aid_int,Integer page_int, Integer num_int);

}

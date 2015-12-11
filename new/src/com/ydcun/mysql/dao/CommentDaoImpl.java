/**
 * 
 */
package com.ydcun.mysql.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ydcun.entity.Comment;

/**
 * @author ydcun_home
 *
 */
@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements ICommentDao{

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.dao.ICommentDao#findComment(java.lang.Integer)
	 */
	@Override
	public Comment findComment(Integer dua_id) {
		Comment comm = super.findOne(dua_id, Comment.class);
		return comm;
	}

	/* (non-Javadoc)
	 * @see com.ydcun.mysql.dao.ICommentDao#findOnePageList(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Comment> findOnePageList(Integer aid_int, Integer page_int, Integer num_int) {
		String hql = "from Comment where status=1 and article.id="+aid_int+" order by id desc";
		Query q = this.getSession().createQuery(hql);
		if(page_int<=0||num_int<=0){
			return null;
		}
		q.setMaxResults(page_int*num_int);
		q.setFirstResult((page_int-1)*num_int);
		return super.findAll(hql);
		
	}

}

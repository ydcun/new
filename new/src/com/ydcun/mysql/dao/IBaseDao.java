/**
 * AbstractRepository.java
 * 版权所有(C) 2012 
 * 创建: 2012-12-12 11:40:40
 */
package com.ydcun.mysql.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

/**
 * @author 
 */
public interface IBaseDao<T> {

	/**
	 * 添加对象
	 * @author 
	 */
	public void insert(Object entity);

	/**
	 * 根据ID查找对象
	 * @author 
	 */
	public T findOne(Serializable id, Class<T> entity);

	/**
	 * 更新一个实体
	 */
	public void updateEntity(Object entity);

	/**
	 * 执行hql语句
	 * @param hql
	 * @return
	 */
	List<T> findAll(String hql);
	/**
	 * 执行sql语句
	 * @param sql
	 * @return
	 */
	List<T> findAllSQL(String sql);


}

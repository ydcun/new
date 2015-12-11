package com.ydcun.mysql.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
@Repository
public class BaseDaoImpl<T> implements IBaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/***
	 * 根据ID查找对象；
	 */
	@Override
	public List<T> findAll(String hql) {
		return this.getSession().createQuery(hql).list();
	}
	/***
	 * sql语句
	 */
	@Override
	public List<T> findAllSQL(String sql) {
		return this.getSession().createSQLQuery(sql).list();
	}
	/***
	 * 根据ID查找对象；
	 */
	@Override
	public T findOne(Serializable id,Class<T> entity) {
		return (T) this.getSession().get(entity, id);   
	}

	/***
	 * 添加一个实体；
	 */
	@Override
	public void insert(Object entity) {
		this.getSession().save(entity);
	}


	/***
	 * 更新实体；
	 */
	@Override
	public void updateEntity(Object entity) {
		this.getSession().update(entity);
	}

}

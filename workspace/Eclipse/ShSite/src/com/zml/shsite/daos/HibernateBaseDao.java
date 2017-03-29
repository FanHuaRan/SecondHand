package com.zml.shsite.daos;
import java.awt.print.Paper;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.impl.CriteriaImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * Hibernate Dao泛型基类
 * 基本的增删改查实现
 * @author zml
 * @param <T>
 */
public class HibernateBaseDao<T extends Object> extends HibernateDaoSupport {
	protected static final Logger log = LoggerFactory.getLogger(HibernateBaseDao.class);
	//实体名
	private String entityName=null;
	//实体名带包
	private String entityFullName=null;
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public HibernateBaseDao(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
		entityName = entityClass.getSimpleName();
		entityFullName = entityClass.getName();
	}
	
	protected void initDao() {
		// do nothing
	}
	public void save(T transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void update(T transientInstance) {
		try {
			getHibernateTemplate().update(transientInstance);
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public void delete(T persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void deleteByProperty(String propertyName, Object value) {
		try {
			List<T> instances=findByProperty(propertyName, value);
			instances.stream().forEach(instance->getHibernateTemplate().delete(instance));
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(Integer id) {
		try {
			T persistentInstance=findById(id);
			if(persistentInstance!=null){
				getHibernateTemplate().delete(persistentInstance);
			}
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void deleteAll(){
		try {
			List<T> instances=findAll();
			instances.stream().forEach(persistentInstance->{
				delete(persistentInstance);
			});
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public T findById(java.lang.Integer id) {
		try {
			T instance =(T)getHibernateTemplate().get(entityFullName, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		try {
			String queryString = "from " +entityName;
			return  (List<T>) getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<T> findTopNByHQL(final String hql,int n){
		try{
			List<T> result=(List<T>) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session arg0) throws HibernateException, SQLException {
					Query query=arg0.createQuery(hql);
					query.setMaxResults(n);
					List<T> result=query.list();
					return result;
				}
			});
			return result;
		}catch(RuntimeException re){
			log.error("find by "+hql+" name failed", re);
			throw re;
		}
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<T> findByHQL(String hql,Object ...params){
		try{
			return (List<T>) getHibernateTemplate().find(hql,params);
		}catch(RuntimeException re){
			log.error("find by "+hql+" failed", re);
			throw re;
		}
	}
	public List<T> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from "+entityName+" as model where model." + propertyName + "= ?";
			return (List<T>) getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List<T> findByExample(T instance) {
		try {
			List<T> results = getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public T merge(T detachedInstance) {
		try {
			T result = getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(T instance) {
		try {
			 getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(T instance) {
		try {
			 getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}

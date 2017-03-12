package com.zml.shsite.models;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Goodtype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zml.shsite.models.Goodtype
 * @author MyEclipse Persistence Tools
 */
public class GoodtypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(GoodtypeDAO.class);
	// property constants
	public static final String GOOD_TYPE_NAME = "goodTypeName";

	protected void initDao() {
		// do nothing
	}

	public void save(Goodtype transientInstance) {
		log.debug("saving Goodtype instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Goodtype persistentInstance) {
		log.debug("deleting Goodtype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Goodtype findById(java.lang.Integer id) {
		log.debug("getting Goodtype instance with id: " + id);
		try {
			Goodtype instance = (Goodtype) getHibernateTemplate().get("com.zml.shsite.models.Goodtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Goodtype instance) {
		log.debug("finding Goodtype instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Goodtype instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Goodtype as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodTypeName(Object goodTypeName) {
		return findByProperty(GOOD_TYPE_NAME, goodTypeName);
	}

	public List findAll() {
		log.debug("finding all Goodtype instances");
		try {
			String queryString = "from Goodtype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Goodtype merge(Goodtype detachedInstance) {
		log.debug("merging Goodtype instance");
		try {
			Goodtype result = (Goodtype) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Goodtype instance) {
		log.debug("attaching dirty Goodtype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Goodtype instance) {
		log.debug("attaching clean Goodtype instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GoodtypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GoodtypeDAO) ctx.getBean("GoodtypeDAO");
	}
}
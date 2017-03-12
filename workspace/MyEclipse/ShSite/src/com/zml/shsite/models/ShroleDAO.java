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
 * Shrole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zml.shsite.models.Shrole
 * @author MyEclipse Persistence Tools
 */
public class ShroleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ShroleDAO.class);
	// property constants
	public static final String SH_ROLE_NAME = "shRoleName";

	protected void initDao() {
		// do nothing
	}

	public void save(Shrole transientInstance) {
		log.debug("saving Shrole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Shrole persistentInstance) {
		log.debug("deleting Shrole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Shrole findById(java.lang.Short id) {
		log.debug("getting Shrole instance with id: " + id);
		try {
			Shrole instance = (Shrole) getHibernateTemplate().get("com.zml.shsite.models.Shrole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Shrole instance) {
		log.debug("finding Shrole instance by example");
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
		log.debug("finding Shrole instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Shrole as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShRoleName(Object shRoleName) {
		return findByProperty(SH_ROLE_NAME, shRoleName);
	}

	public List findAll() {
		log.debug("finding all Shrole instances");
		try {
			String queryString = "from Shrole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shrole merge(Shrole detachedInstance) {
		log.debug("merging Shrole instance");
		try {
			Shrole result = (Shrole) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shrole instance) {
		log.debug("attaching dirty Shrole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Shrole instance) {
		log.debug("attaching clean Shrole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShroleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ShroleDAO) ctx.getBean("ShroleDAO");
	}
}
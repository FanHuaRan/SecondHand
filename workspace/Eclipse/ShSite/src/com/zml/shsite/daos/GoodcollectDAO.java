package com.zml.shsite.daos;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zml.shsite.models.Goodcollect;

/**
 * A data access object (DAO) providing persistence and search support for
 * Goodcollect entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.zml.shsite.models.Goodcollect
 * @author MyEclipse Persistence Tools
 */
@Repository
public class GoodcollectDAO extends HibernateBaseDao<Goodcollect> {
	private static final Logger log = LoggerFactory.getLogger(GoodcollectDAO.class);
	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Goodcollect transientInstance) {
		log.debug("saving Goodcollect instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Goodcollect persistentInstance) {
		log.debug("deleting Goodcollect instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Goodcollect findById(java.lang.Integer id) {
		log.debug("getting Goodcollect instance with id: " + id);
		try {
			Goodcollect instance = (Goodcollect) getHibernateTemplate().get("com.zml.shsite.models.Goodcollect", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Goodcollect instance) {
		log.debug("finding Goodcollect instance by example");
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
		log.debug("finding Goodcollect instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Goodcollect as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Goodcollect instances");
		try {
			String queryString = "from Goodcollect";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Goodcollect merge(Goodcollect detachedInstance) {
		log.debug("merging Goodcollect instance");
		try {
			Goodcollect result = (Goodcollect) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Goodcollect instance) {
		log.debug("attaching dirty Goodcollect instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Goodcollect instance) {
		log.debug("attaching clean Goodcollect instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GoodcollectDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GoodcollectDAO) ctx.getBean("GoodcollectDAO");
	}
}
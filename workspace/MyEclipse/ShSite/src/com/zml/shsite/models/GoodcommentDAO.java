package com.zml.shsite.models;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Goodcomment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.zml.shsite.models.Goodcomment
 * @author MyEclipse Persistence Tools
 */
public class GoodcommentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(GoodcommentDAO.class);
	// property constants
	public static final String COM_CONTENT = "comContent";

	protected void initDao() {
		// do nothing
	}

	public void save(Goodcomment transientInstance) {
		log.debug("saving Goodcomment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Goodcomment persistentInstance) {
		log.debug("deleting Goodcomment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Goodcomment findById(java.lang.Integer id) {
		log.debug("getting Goodcomment instance with id: " + id);
		try {
			Goodcomment instance = (Goodcomment) getHibernateTemplate().get("com.zml.shsite.models.Goodcomment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Goodcomment instance) {
		log.debug("finding Goodcomment instance by example");
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
		log.debug("finding Goodcomment instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Goodcomment as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByComContent(Object comContent) {
		return findByProperty(COM_CONTENT, comContent);
	}

	public List findAll() {
		log.debug("finding all Goodcomment instances");
		try {
			String queryString = "from Goodcomment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Goodcomment merge(Goodcomment detachedInstance) {
		log.debug("merging Goodcomment instance");
		try {
			Goodcomment result = (Goodcomment) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Goodcomment instance) {
		log.debug("attaching dirty Goodcomment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Goodcomment instance) {
		log.debug("attaching clean Goodcomment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GoodcommentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GoodcommentDAO) ctx.getBean("GoodcommentDAO");
	}
}
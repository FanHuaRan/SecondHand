package com.zml.shsite.daos;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CommonStatistics extends HibernateDaoSupport {
	
	private static final Logger logger=Logger.getLogger(CommonStatistics.class);
	@Autowired
	public CommonStatistics(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	@SuppressWarnings("unchecked")
	public Object statisUniqueResult(final String hql,Object ...params){
		try {
			 Object result=this.getHibernateTemplate().execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session arg0) throws HibernateException, SQLException {
					Query query = arg0.createQuery(hql);
					if(params!=null){
						for (int i = 0; i < params.length; i++) {
							query.setParameter(i, params[i]);
						}
					}
					Object result=query.uniqueResult();
					return result;
				}
			});
			return result;
		} catch (RuntimeException e) {
			logger.error(e);
			return null;
		}
	}
	
	public List statisMoreResult(String hql,Object ...params){
		try {
			Query query = this.getSession().createQuery(hql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			List results=query.list();
			this.getSession().close();
			return results;
		} catch (RuntimeException e) {
			logger.error(e);
			return null;
		}
	}
	
	
}

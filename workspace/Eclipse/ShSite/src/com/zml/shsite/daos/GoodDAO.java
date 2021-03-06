package com.zml.shsite.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.zml.shsite.models.Good;

/**
 * A data access object (DAO) providing persistence and search support for Good
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zml.shsite.models.Good
 * @author MyEclipse Persistence Tools
 */
@Repository
public class GoodDAO extends HibernateBaseDao<Good> {
	// property constants
	public static final String IMAGE_URL = "imageUrl";
	public static final String IS_SELL = "isSell";
	public static final String GOOD_PRICE = "goodPrice";
	public static final String GOOD_TYPE_ID = "goodTypeId";
	public static final String SH_USER_ID = "shUserId";
	@Autowired
	public GoodDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	public List<Good> findByImageUrl(Object imageUrl) {
		return findByProperty(IMAGE_URL, imageUrl);
	}

	public List<Good> findByIsSell(Object isSell) {
		return findByProperty(IS_SELL, isSell);
	}

	public List<Good> findByGoodPrice(Object goodPrice) {
		return findByProperty(GOOD_PRICE, goodPrice);
	}
	
	public List<Good> findBygoodTypeId(Object goodPrice) {
		return findByProperty(GOOD_TYPE_ID, goodPrice);
	}
	public List<Good> findByShUserId(Object shUserId) {
		return findByProperty(SH_USER_ID, shUserId);
	}
	public void deleteByShUserId(Object shUserId){
		deleteByProperty(SH_USER_ID, shUserId);
	}
	public static GoodDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GoodDAO) ctx.getBean("GoodDAO");
	}
}
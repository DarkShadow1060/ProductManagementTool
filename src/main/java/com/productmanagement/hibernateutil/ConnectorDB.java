/**
 * 
 */
package com.productmanagement.hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.nagarro.productmanagement.entity.ProductEntity;
import com.nagarro.productmanagement.entity.UserEntity;

/**
 * The Class ConnectorDB.
 *
 * @author heram
 */
public class ConnectorDB {

/** The connector DB instance. */
private static ConnectorDB connectorDBInstance = null;
	
	/** The session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Instantiates a new hibernate util.
	 */
	private ConnectorDB() {
		
		Configuration config= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserEntity.class).addAnnotatedClass(ProductEntity.class);
		/** The session factory. */
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(registry);
		
	}
	
	/**
	 * Gets the connector DB.
	 *
	 * @return the connector DB
	 */
	public static  ConnectorDB getConnectorDB() {
		if(connectorDBInstance == null) {
			connectorDBInstance = new ConnectorDB();
		}
		return connectorDBInstance;
	}
//---------------------------------------------------------
	
	/**
 * Clone.
 *
 * @return the object
 * @throws CloneNotSupportedException the clone not supported exception
 */
@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = null;
		try {
			throw new CloneNotSupportedException("Cannot create Duplicate Object of Session ");			
		}
		catch(CloneNotSupportedException e) {
			System.out.println(" Cannot create Duplicate Object of Session  ");
		}
		return obj;
	}
}

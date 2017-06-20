package t_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private HibernateUtils(){}
	
	private static SessionFactory sessionFactory = null;
	private static Configuration config = null;
	
	static{
		//加载核心配置文件,类加载时执行
		config = new Configuration();
		config.configure();
		sessionFactory = config.buildSessionFactory();
	}
	
	/*
	 * 返回与本地线程绑定的session
	 */
	public static Session getSessionobject(){
		return sessionFactory.getCurrentSession();
	}
	
	
	/*
	 * 返回sessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}

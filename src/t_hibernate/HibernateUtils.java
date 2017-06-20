package t_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private HibernateUtils(){}
	
	private static SessionFactory sessionFactory = null;
	private static Configuration config = null;
	
	static{
		//���غ��������ļ�,�����ʱִ��
		config = new Configuration();
		config.configure();
		sessionFactory = config.buildSessionFactory();
	}
	
	/*
	 * �����뱾���̰߳󶨵�session
	 */
	public static Session getSessionobject(){
		return sessionFactory.getCurrentSession();
	}
	
	
	/*
	 * ����sessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}

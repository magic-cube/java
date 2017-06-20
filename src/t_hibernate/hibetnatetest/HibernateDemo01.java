package t_hibernate.hibetnatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import t_hibernate.entity.User;

public class HibernateDemo01 {
	
	@Test
	public void testAdd(){
		/*
		 * 1.加载hibernate核心配置文件
		 * 它会在src下找到名称是hibernate.cfg.xml的文件
		 */
		Configuration cfg = new Configuration();
		cfg.configure();
		
		/*
		 * 2.创建SessionFactory对象
		 * 会读取hibernate核心配置文件的内容,创建sessionFactory
		 * 在这过程中,会根据你的映射关系,在配置数据库里把表创建
		 */
		SessionFactory sessionFactroy = cfg.buildSessionFactory();
		
		/*
		 * 3.使用SessionFactory创建Session对象
		 * 类似于连接
		 */
		Session session = sessionFactroy.openSession();
		
		/*
		 * 4.开启事务 
		 */
		Transaction tx = session.beginTransaction();
		
		/*
		 * 5.写具体逻辑,crud操作 
		 */
		User user = new User();
		user.setUsername("xiaowang");
		user.setPassword("250");
		user.setAddress("日本");
		session.save(user);//调用session的save方法实现添加
		/*
		 * 6.提交事务
		 */
		tx.commit();
		
		/*
		 * 7.关闭资源
		 */
		session.close();
		sessionFactroy.close();
	}
	
}



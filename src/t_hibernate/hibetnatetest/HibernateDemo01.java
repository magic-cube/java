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
		 * 1.����hibernate���������ļ�
		 * ������src���ҵ�������hibernate.cfg.xml���ļ�
		 */
		Configuration cfg = new Configuration();
		cfg.configure();
		
		/*
		 * 2.����SessionFactory����
		 * ���ȡhibernate���������ļ�������,����sessionFactory
		 * ���������,��������ӳ���ϵ,���������ݿ���ѱ���
		 */
		SessionFactory sessionFactroy = cfg.buildSessionFactory();
		
		/*
		 * 3.ʹ��SessionFactory����Session����
		 * ����������
		 */
		Session session = sessionFactroy.openSession();
		
		/*
		 * 4.�������� 
		 */
		Transaction tx = session.beginTransaction();
		
		/*
		 * 5.д�����߼�,crud���� 
		 */
		User user = new User();
		user.setUsername("xiaowang");
		user.setPassword("250");
		user.setAddress("�ձ�");
		session.save(user);//����session��save����ʵ�����
		/*
		 * 6.�ύ����
		 */
		tx.commit();
		
		/*
		 * 7.�ر���Դ
		 */
		session.close();
		sessionFactroy.close();
	}
	
}



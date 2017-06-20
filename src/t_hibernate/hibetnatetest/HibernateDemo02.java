package t_hibernate.hibetnatetest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import t_hibernate.HibernateUtils;
import t_hibernate.entity.User;

public class HibernateDemo02 {
	
	@Test
	public void testTransaction(){
		/*
		 * ����淶д���Ĵ���
		 */
		Transaction tx = null;
		Session session = null;
		try{
			//�õ��뱾���̰߳󶨵�session
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			
			//���
			User user =new User();
			user.setUsername("wo");
			user.setAddress("wojia");
			user.setPassword("123");
			session.save(user);
			
			//int i = 10/0;
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			//session.close();
		}
		
	}
	
}

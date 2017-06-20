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
		 * 事务规范写法的代码
		 */
		Transaction tx = null;
		Session session = null;
		try{
			//得到与本地线程绑定的session
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			
			//添加
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

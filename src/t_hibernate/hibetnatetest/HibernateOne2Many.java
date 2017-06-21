package t_hibernate.hibetnatetest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import t_hibernate.HibernateUtils;
import t_hibernate.entity.Customer;
import t_hibernate.entity.LinkMan;

public class HibernateOne2Many {
	
	/*
	 * 一对多的级联保存操作,(复杂方式)
	 * 缺点太多...不想说
	 */
	@Test
	public void testAddDemo01(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			
			/*
			 * 添加客户,并为客户添加一个联系人
			 * 1.创建客户和联系人对象
			 */
			Customer customer = new Customer();
			customer.setCustName("haochuan");
			customer.setCustLevel("vip");
			customer.setCustPhone("110");
			customer.setCustMobile("999");
			customer.setCustSource("网络");
			
			LinkMan linkman = new LinkMan();
			linkman.setLkm_name("lucy");
			linkman.setLkm_gender("男");
			linkman.setLkm_phone("911");
			
			/*
			 * 2.在客户里表示联系人,在联系人中表示客户
			 * 建立两个实体类间的关系
			 */
			//2.1把联系人对象,放到客户对象的集合中
			customer.getSetLinkMan().add(linkman);
			//2.2把客户对象放到联系人中
			linkman.setCustomer(customer);
			
			
			/*
			 * 3.保存到数据库
			 */
			session.save(linkman);
			session.save(customer);
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			//
		}
	}
	
	/*
	 * 一对多级联保存操作,(简易写法,需要先配置)(set标签中 cascade="save-update")
	 */
	@Test
	public void testAddDemo02(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			
			/*
			 * 添加客户,并为客户添加一个联系人
			 * 1.创建客户和联系人对象
			 */
			Customer customer = new Customer();
			customer.setCustName("Alibaba");
			customer.setCustLevel("vip");
			customer.setCustPhone("120");
			customer.setCustMobile("111");
			customer.setCustSource("网络");
			
			LinkMan linkman = new LinkMan();
			linkman.setLkm_name("tom");
			linkman.setLkm_gender("男");
			linkman.setLkm_phone("099");
			
			/*
			 * 2.在客户里表示联系人,在联系人中表示客户
			 * 建立两个实体类间的关系
			 */
			//把联系人对象,放到客户对象的集合中
			customer.getSetLinkMan().add(linkman);
			
			/*
			 * 3.保存到数据库
			 */
			session.save(customer);
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			//
		}
	}
	
	/*
	 * 一对多级联删除
	 */
	@Test
	public void testDeleteDemo01(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 2);
			session.delete(customer);
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			//
		}
	}
	
	@Test
	public void testUpdateDemo01(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 1);
			LinkMan linkMan = session.get(LinkMan.class, 3);
			
			//设置持久态对象值
			customer.getSetLinkMan().add(linkMan);
			linkMan.setCustomer(customer);
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			//
		}
	}

}

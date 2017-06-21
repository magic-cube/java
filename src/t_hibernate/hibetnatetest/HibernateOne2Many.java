package t_hibernate.hibetnatetest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import t_hibernate.HibernateUtils;
import t_hibernate.entity.Customer;
import t_hibernate.entity.LinkMan;

public class HibernateOne2Many {
	
	/*
	 * һ�Զ�ļ����������,(���ӷ�ʽ)
	 * ȱ��̫��...����˵
	 */
	@Test
	public void testAddDemo01(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			
			/*
			 * ��ӿͻ�,��Ϊ�ͻ����һ����ϵ��
			 * 1.�����ͻ�����ϵ�˶���
			 */
			Customer customer = new Customer();
			customer.setCustName("haochuan");
			customer.setCustLevel("vip");
			customer.setCustPhone("110");
			customer.setCustMobile("999");
			customer.setCustSource("����");
			
			LinkMan linkman = new LinkMan();
			linkman.setLkm_name("lucy");
			linkman.setLkm_gender("��");
			linkman.setLkm_phone("911");
			
			/*
			 * 2.�ڿͻ����ʾ��ϵ��,����ϵ���б�ʾ�ͻ�
			 * ��������ʵ�����Ĺ�ϵ
			 */
			//2.1����ϵ�˶���,�ŵ��ͻ�����ļ�����
			customer.getSetLinkMan().add(linkman);
			//2.2�ѿͻ�����ŵ���ϵ����
			linkman.setCustomer(customer);
			
			
			/*
			 * 3.���浽���ݿ�
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
	 * һ�Զ༶���������,(����д��,��Ҫ������)(set��ǩ�� cascade="save-update")
	 */
	@Test
	public void testAddDemo02(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			
			/*
			 * ��ӿͻ�,��Ϊ�ͻ����һ����ϵ��
			 * 1.�����ͻ�����ϵ�˶���
			 */
			Customer customer = new Customer();
			customer.setCustName("Alibaba");
			customer.setCustLevel("vip");
			customer.setCustPhone("120");
			customer.setCustMobile("111");
			customer.setCustSource("����");
			
			LinkMan linkman = new LinkMan();
			linkman.setLkm_name("tom");
			linkman.setLkm_gender("��");
			linkman.setLkm_phone("099");
			
			/*
			 * 2.�ڿͻ����ʾ��ϵ��,����ϵ���б�ʾ�ͻ�
			 * ��������ʵ�����Ĺ�ϵ
			 */
			//����ϵ�˶���,�ŵ��ͻ�����ļ�����
			customer.getSetLinkMan().add(linkman);
			
			/*
			 * 3.���浽���ݿ�
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
	 * һ�Զ༶��ɾ��
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
			
			//���ó־�̬����ֵ
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

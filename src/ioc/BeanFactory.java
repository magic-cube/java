package ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * Spring IoC˼��(���Ʒ�ת) 
 * �����
 * �ɿ����ǹ���ģʽ������
 * @author hc
 *
 */
public class BeanFactory {
	
	public static Object getBean(String id){
		try {
			//1.��ȡdocument����
			Document doc = new SAXReader().read(BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));
			
			//����api slectSingleNode (���ʽ)
			Element beanEle = (Element)doc.selectSingleNode("//bean[@id='"+id+"']");
//System.out.println(beanEle);
			//��ȡԪ��class
			String classValue = beanEle.attributeValue("class");
			
			//ͨ�������ȡʵ����Ķ���
			Object newInstance = Class.forName(classValue).newInstance();
			
			
			return newInstance;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ȡbeanʧ��");
		}
		
		return null;
	}
	
	public static void main(String args[]){
		ProductDao productDao = (ProductDao) BeanFactory.getBean("ProductDao");
		System.out.println(productDao);
		System.out.println("��ȡ����ɹ�");
	}
	
	
}









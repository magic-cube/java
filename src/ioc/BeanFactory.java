package ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * Spring IoC思想(控制反转) 
 * 解耦合
 * 可看做是工厂模式的升华
 * @author hc
 *
 */
public class BeanFactory {
	
	public static Object getBean(String id){
		try {
			//1.获取document对象
			Document doc = new SAXReader().read(BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));
			
			//调用api slectSingleNode (表达式)
			Element beanEle = (Element)doc.selectSingleNode("//bean[@id='"+id+"']");
//System.out.println(beanEle);
			//获取元素class
			String classValue = beanEle.attributeValue("class");
			
			//通过反射获取实现类的对象
			Object newInstance = Class.forName(classValue).newInstance();
			
			
			return newInstance;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取bean失败");
		}
		
		return null;
	}
	
	public static void main(String args[]){
		ProductDao productDao = (ProductDao) BeanFactory.getBean("ProductDao");
		System.out.println(productDao);
		System.out.println("获取对象成功");
	}
	
	
}









package annotation;

import java.util.ArrayList;
import java.util.List;

//Ĭ�ϼ̳���Object��
public class Demo01 /*extends Object*/{
	
	//ʹ���Զ���ע��
	@MyAnnotation(name={"chuan","��"},stdName=" ",n=10)
	public void my(){
		
	}
	
	
	//��дObject���toString����
	@Override
	public String toString(){
		return "";
	}
	
	//�����ķ�����������ʹ��
	@Deprecated
	public static void test(){
		
	}
	
	//�������о���
	@SuppressWarnings("all")
	public void d1(){
		List list=new ArrayList();
	}
	
	public static void main(String[] args) {
		//�����ķ���,����Data���pʲô����
		test();
	}

}

package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * �Զ���ע��
 * ����㶨���ע����ֻ��һ��������ͨ�������Ĳ�������Ϊvalue
 * @author hc
 *
 */

//��������ע���ʹ�÷�Χ
@Target(value={ElementType.METHOD,ElementType.TYPE})
//����ʱ��Ч����ζ�ſ���ʹ�÷����ȡ
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	//�Զ���ע���ǣ�����ʹ�ÿ��ַ�����0��ΪĬ��ֵ��Ҳ����ʹ��-1��ʾ��ֵ������
	String stdName () default "";
	
	int n()default 0;
	
	String[]name()default{"haochuan","aguang"};
}

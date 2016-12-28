package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义注解
 * 如果你定义的注解中只有一个参数，通常将他的参数名定为value
 * @author hc
 *
 */

//用于描述注解的使用范围
@Target(value={ElementType.METHOD,ElementType.TYPE})
//运行时有效，意味着可以使用反射读取
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	//自定义注解是，经常使用空字符串，0作为默认值，也经常使用-1表示该值不存在
	String stdName () default "";
	
	int n()default 0;
	
	String[]name()default{"haochuan","aguang"};
}

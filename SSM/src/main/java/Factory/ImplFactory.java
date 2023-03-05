package Factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface ImplFactory {
	
	public static ApplicationContext a=new ClassPathXmlApplicationContext("spbeans.xml");
	
	public static ApplicationContext b=new AnnotationConfigApplicationContext(SpFactory.class);
}

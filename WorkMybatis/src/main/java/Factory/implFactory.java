package Factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface implFactory {
	
	public static ApplicationContext a=new ClassPathXmlApplicationContext("sp1.xml");
	
	public static ApplicationContext b=new AnnotationConfigApplicationContext(SpFactory.class);
}

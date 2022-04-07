import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sbi.level2.Car;

public class CarTest2 {

	public static void main(String[] args)
	{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("myspring2.xml");
		System.out.println("checking spring container created");
		Car cObj = (Car)ctx.getBean("mycar");
		
		cObj.startTheCar();
		cObj.stopTheCar();

	}

}

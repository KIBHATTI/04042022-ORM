import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sbi.level2.Car;

public class CarTest
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("myspring.xml");
		System.out.println("spring container created");
		
		Car myCar = (Car)ctx.getBean("mycar");
		System.out.println("------------------------");
		Car myCar2 = (Car)ctx.getBean("mycar");
		
		myCar.startTheCar();
		myCar.stopTheCar();
		System.out.println("Car 1"+myCar.hashCode());
		
		myCar2.startTheCar();
		myCar2.stopTheCar();
		System.out.println("Car 2"+myCar2.hashCode());
	}

}




package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
//		BeanFactory factory = new BeanFactory();
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("tv이름 입력 : ");
//		String tname = sc.nextLine();
//		
//		TV tv = (TV)factory.getBean(tname);
		
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (LgTV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
	}

}

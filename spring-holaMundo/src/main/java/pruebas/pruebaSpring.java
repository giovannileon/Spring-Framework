package pruebas;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.beanSpring;

public class pruebaSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanFactory factory = context;
		beanSpring miBean = (beanSpring)factory.getBean("beanSpring");
		System.out.println("Mensaje: " +  miBean.getMensaje());
		

	}

}

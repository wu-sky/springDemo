import com.dao.UserDao1;
import com.entity.HelloWorld;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.service.UserService;
import com.entity.User;

public class Demo1Main {


	/**
	 * 刚开始来个hello world, setter注入, 在application.xml配好了
	 */
	@Test
	public void helloWorld(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("application.xml");
		HelloWorld helloWorld=ac.getBean(HelloWorld.class);
		//if没有注入, 底下报空指针
		System.out.println(helloWorld.toString());
	}

	/**
	 * 同样时getBean
	 * 现在的方法ApplicationContext
	 * 过世的方法beanFactory
	 */
	@Test
	public void deprecatedMethod(){
		Resource resource = new ClassPathResource("application.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		User userBean = (User) beanFactory.getBean("user");
		System.out.println(userBean.toString());

	}


	/**
	 * spring中构造器注入, 在application.xml中配置好了
	 */
	@Test
	public void constructorInject() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		User userBean = (User) ac.getBean("user");
		System.out.println("userBean=" + userBean);
	}

	/**
	 * spring中ioc bean的生命周期方法插一脚
	 */
	@Test
	public void lifeCycleTest(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application.xml");
		//使用这个抽象类的对象之后就可以调用spring bean对象销毁时的方法, 如果只用ApplicationContext调不到close方法
		UserService userService = (UserService) aac.getBean("userService");
		Boolean is = userService.login("admin1", "123");
		System.out.println(is ? "登陆成功" : "登陆失败");
		//以下方法将会调用spring bean 的销毁时的方法
		aac.close();
	}


	/**
	 * 只要你用了spring, 有参数引用的对象, 你就不能new, 即使你new出来你也无法注入
	 */
	@Test
	public  void error() {
		 UserDao1 userDao1= new UserDao1();
        UserService userService =new UserService();
        boolean is=userService.login("admin", "123");
        System.out.println(is?"登陆成功":"登陆失败");
        //只要你用了spring, 你就不能new , 自己new 就空指针, because你的userDao new出来根本不能在userService里面用

	}
}

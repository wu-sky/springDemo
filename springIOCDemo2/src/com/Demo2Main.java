package com;
import com.dao.UserDao1;
import com.entity.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.service.UserService;
import com.entity.UserBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 idea 使用junit 在 spring 自动扫描下, 报异常但是eclipse就不报, 不知道原因
 */

public class Demo2Main {


    /**
     * 刚开始来个hello world, setter注入, 在application.xml配好了
     */
    @Test
    public void helloWorld(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("application.xml");
        HelloWorld helloWorld=ac.getBean(HelloWorld.class);
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
        //默认以首字母开头小写的bean名字来调用, 约定大于配置, 因为自动扫描了, 不用自己起名字了, spring就是怎么设计自动扫描的bean名
        UserBean userBean = (UserBean) beanFactory.getBean("userBean");
        System.out.println(userBean.toString());
    }


    /**
     * spring中构造器注入, 在application.xml中配置好了
     */
	@Test
    public void constructorInject() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        UserBean userBean = (UserBean) ac.getBean("userBean");
        System.out.println("userBean=" + userBean);
    }

    /**
     * spring中ioc bean的生命周期方法插一脚
     */
    public void lifeCycleTest(){
        AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) aac.getBean("userService");
        Boolean is = userService.login("admin2", "123");
        System.out.println(is ? "登陆成功" : "登陆失败");
        aac.close();
    }


    /**
     * 只要你用了spring, 有参数引用的对象, 你就不能new, 即使你new出来你也无法注入
     */
    public  void error() {
        UserDao1 userDao1= new UserDao1();
        UserService userService =new UserService();
        boolean is=userService.login("admin", "123");
        System.out.println(is?"登陆成功":"登陆失败");
        //只要你用了spring, 你就不能new , 自己new 就空指针, because你的userDao new出来根本不能在userService里面用

    }
    @Test
    public void test(){
        System.out.println("bug 你 大爷");
    }

	public static void main(String[] args){
		Demo2Main test=new Demo2Main();
		//test.helloWorld();
		//test.constructorInject();
		test.lifeCycleTest();
		//test.deprecatedMethod();
		//test.error();
	}

}

package com;
import com.entity.IHuman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AopDemo1Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        IHuman chinese=(IHuman)applicationContext.getBean("chinese");
        /*注意, 这里没有Aspect的对象, 但是aspect的方法已经注入了*/
        chinese.eat();
        chinese.sleep();
        System.out.println("-----------");
        IHuman american=(IHuman)applicationContext.getBean("american");
        american.eat();
        american.sleep();
    }
}
/*
 *用户：sky-吴
 *日期：2019/7/7
 */


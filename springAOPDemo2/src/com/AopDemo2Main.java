package com;

/*
 *用户：sky-吴
 *日期：2019/7/7
 */


import com.entity.IHuman;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDemo2Main {


    public static void main(String[] args) {
        System.out.println("----使用注解来实现spring aop-------");
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


    //junit 自动扫描的就不能用, 不知道为什么
    @Test
    public void test(){
        System.out.println("----使用注解来实现spring aop-------");
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

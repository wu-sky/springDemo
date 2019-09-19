package com.service;
import com.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
/**
 *用户：sky-吴
 *日期：2019/7/6
 * 谁控制谁：在传统的开发模式下，我们都是采用直接 new 一个对象的方式来创建对象，也就是说你依赖的对象直接由你自己控制，但是有了 IOC 容器后，则直接由 IoC 容器来控制。所以“谁控制谁”，当然是 IoC 容器控制对象。
 *控制什么：控制对象。
 *为何是反转：没有 IoC 的时候我们都是在自己对象中主动去创建被依赖的对象，这是正转。但是有了 IoC 后，所依赖的对象直接由 IoC 容器创建后注入到被注入的对象中，依赖的对象由原来的主动获取变成被动接受，所以是反转。
 *哪些方面反转了：所依赖对象的获取被反转了。
 */
public class UserService {
    //使用注解, getter和setter就不用写了
    @Autowired(required = false)
    @Qualifier("userDao1")
    private IUserDao userDao;
    //private UserDao2 userDao;
    //@Qualifier("") 这个是有了接口之后就让你指定是那个实现类, 演示一个接口就够了, 一般dao没有那么多个
    public void inti(){
        System.out.println("---userService初始化------");
    }

    public void destroy(){
        System.out.println("-----userService被销毁-----");
    }

    public UserService(){
        System.out.println("---userService对象被创建------");
    }

    public boolean login(String username, String password){
        System.out.println("--------userService.login()-------");
        return userDao.login(username, password);
    }

    /**
     * 补充:
     */
    public void supplementaryNotes(){

    /*使用注解
     方法1
     @Autowired(required = false)
     @Qualifier("userDao1")
    方法2
    @Resource(name = "userDao1")
    */
    }

}




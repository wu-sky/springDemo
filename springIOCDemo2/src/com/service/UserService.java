package com.service;       /*
 *用户：sky-吴
 *日期：2019/7/6
 */

import com.dao.IUserDao;
import com.dao.UserDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service //约定的 会被spring从 application.xml中读取到
public class UserService {

    /*@Resource(name = "userDao1")*/
   // @Qualifier("userDao2")
    @Autowired
    private UserDao2 dao;


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
        return dao.login(username, password);
    }

}

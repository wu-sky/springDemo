package com.dao;       /*
 *用户：sky-吴
 *日期：2019/7/6
 */

import org.springframework.stereotype.Repository;

@Repository
public class UserDao2 implements IUserDao{

    public UserDao2(){
        System.out.println("userDao2初始化");
    }

    public boolean login(String username, String password){

        System.out.println("--------userDao2.login()--------");

        if ("admin".equals(username)&&"123".equals(password)){
            return true;
        }else{
            return false;
        }
    }


}

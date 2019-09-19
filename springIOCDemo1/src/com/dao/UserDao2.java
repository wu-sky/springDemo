package com.dao;       /*
 *用户：sky-吴
 *日期：2019/7/6
 */

public class UserDao2 implements IUserDao{

    public UserDao2(){
        System.out.println("userDao2初始化");
    }

    public boolean login(String username, String password) {

        System.out.println("--------userDao2.login()--------");
        return "admin2".equals(username) && "123".equals(password) ? true : false;
    }


}

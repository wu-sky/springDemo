package com.dao;       /*
 *用户：sky-吴
 *日期：2019/7/6
 */

public class UserDao1 implements IUserDao {

    public UserDao1(){
        System.out.println("userDao1初始化");
    }

    @Override
    public boolean login(String username, String password){
        System.out.println("--------userDao1.login()------");
        return "admin1".equals(username)&&"123".equals(password)? true: false;
    }
}

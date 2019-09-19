package com.dao;       /*
 *用户：sky-吴
 *日期：2019/7/6
 */

import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// @RunWith注解表示运行在Spring容器中，包括controller，service，dao等
@RunWith(SpringJUnit4ClassRunner.class)
// 这里表示加载配置文件

@Repository
public class UserDao1 implements IUserDao {

    public UserDao1(){
        System.out.println("userDao1初始化");
    }


    @Override
    public boolean login(String username, String password){

        System.out.println(
                "--------userDao1.login()------"
        );

        if ("admin".equals(username)&&"123".equals(password)){
            return true;
        }else{
            return false;
        }
    }


}

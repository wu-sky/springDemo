package com.entity;

import org.springframework.stereotype.Component;

/*
 *用户：sky-吴
 *日期：2019/7/6
 */
@Component //遇事不决component, 记得如果是自动装配的, 必须写无参构造器, 而且不能通过构造器注入
public class UserBean {
    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserBean(){

    }
    public UserBean(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }


}



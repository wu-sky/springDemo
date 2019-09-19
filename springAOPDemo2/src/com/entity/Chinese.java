package com.entity;

import org.springframework.stereotype.Component;

/*
 *用户：sky-吴
 *日期：2019/7/7
 */
@Component
public class Chinese implements IHuman {
    @Override
    public void eat() {
        System.out.println("Chinese eat");
    }

    @Override
    public void sleep() {
        System.out.println("Chinese sleep");
    }
}

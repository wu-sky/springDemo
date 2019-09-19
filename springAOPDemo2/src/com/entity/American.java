package com.entity;

import org.springframework.stereotype.Component;

/*
 *用户：sky-吴
 *日期：2019/7/7
 */
@Component
public class American implements IHuman {
    @Override
    public void eat() {
        System.out.println("American eat");
    }

    @Override
    public void sleep() {
        System.out.println("American sleep");
    }
}

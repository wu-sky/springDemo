package com.service;

/**
 * 在目标对象调用方法之前和之后我给你插一脚, 但是我不动目标的代码
 */
public class MyAspect {

    public void beforeEat(){
        System.out.println("wash hand");
    }

    public void afterEat(){
        System.out.println("brushed tooth");
    }

    public void beforeSleep(){
        System.out.println("bath");
    }

    public void afterSleep(){
        System.out.println("turn off the light");
    }

}

/*
 *用户：sky-吴
 *日期：2019/7/7
 */
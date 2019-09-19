package com.service;

/*
 *用户：sky-吴
 *日期：2019/7/7
 */


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * spring aop中最核心的A
 */

@Aspect
@Component
//public class Aspect { 报错is already defined in this compilation unit
public class MyAspect{
    @Before("execution(* com.entity.*.eat())")
    public void beforeEat(){
        System.out.println("wash hand");
    }

    @After("execution(* com.entity.*.eat())")
    public void afterEat(){
        System.out.println("brushed tooth");
    }

    @Before("execution(* com.entity.*.sleep())")
    public void beforeSleep(){
        System.out.println("bath");
    }

    @After("execution(* com.entity.*.sleep())")
    public void afterSleep(){
        System.out.println("turn off the light");
    }

}

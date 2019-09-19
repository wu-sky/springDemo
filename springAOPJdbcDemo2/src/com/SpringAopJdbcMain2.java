package com;

import com.dao.DictDao;
import com.entity.Dict;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
public class SpringAopJdbcMain2 {

    public static void main(String[] args){
        AbstractApplicationContext cxt = new ClassPathXmlApplicationContext("application.xml");
        DictDao dao = (DictDao) cxt.getBean("dictDao");
        dao.updateE();
      /*  Dict obj=dao.getObjById();
        System.out.println("obj.toString()===>"+obj.toString());
        List<Dict> list = dao.list();
        System.out.println("-----------------------");
        for (Dict dict : list) {
            System.out.println(dict);
        }*/
        cxt.close();
    }


}

/*
 *用户：sky-吴
 *日期：2019/7/8
 */
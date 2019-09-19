import com.dao.UserDao;
import com.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
public class SpringAopJdbcMain1 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("application.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao");
        ArrayList<User> list= (ArrayList<User>) userDao.list();
        for (User u: list) {
            System.out.println(u.toString());
        }
    }


    @Test
    public void test(){
        User user=new User();
        System.out.println("new User:"+user.toString());
        ApplicationContext ac=new ClassPathXmlApplicationContext("application.xml");
        User user1= (User) ac.getBean("user");
        System.out.println("getBean:"+user1.toString());

    }
}



/*
 *用户：sky-吴
 *日期：2019/7/8
 */
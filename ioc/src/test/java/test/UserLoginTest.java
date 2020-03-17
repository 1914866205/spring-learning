package test;


import com.soft1851.spring.ioc.entity.User;
import com.soft1851.spring.ioc.entity.UserLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserLoginTest {
    @Autowired
    UserLogin userLogin;
    @Test
    public void userLogin() {
     User user=new User("ABC","333");
     if (userLogin.userLogin(user)){
         System.out.println(user+"登录成功");
     }else {
         System.out.println(user+"登录失败");
     }
         user=new User("admin","111");
        if (userLogin.userLogin(user)){
            System.out.println(user+"登录成功");
        }else {
            System.out.println(user+"登录失败");
        }

    }
}

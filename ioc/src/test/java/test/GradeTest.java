package test;
import com.soft1851.spring.orm.entity.Grade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class GradeTest {
    @Autowired
    Grade grade;
    @Autowired
    Grade grade2;
    @Autowired
    Grade grade3;
    @Test
    public void test(){
        System.out.println(grade);
        System.out.println(grade2);
        System.out.println(grade3);
    }
}

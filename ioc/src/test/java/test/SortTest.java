package test;

import com.soft1851.spring.orm.entity.Sort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SortTest {
    public static void main(String[] args) throws Exception {
        //得到上下文对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Sort sort = (Sort) ac.getBean("sort");
        int [] sourceArray={1,5,3,4,2,9,13,54,12,66212,66262,656,121,44,65,323};
//        int [] result1=sort.bubbleSort(sourceArray);
//        for (int i = 0; i < result1.length; i++) {
//            System.out.print(result1[i]);
//        }
//        System.out.println("");
//        int [] result2=sort.selectSort(sourceArray);
//        for (int i = 0; i < result2.length; i++) {
//            System.out.print(result2[i]);
//        }
//
//        System.out.println("");
//        int [] result3=sort.insertSort(sourceArray);
//        for (int i = 0; i < result3.length; i++) {
//            System.out.print(result3[i]);
//        }
//
//        System.out.println("");
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(new Date().getTime()));
//        System.out.println(new Date().getTime());
//        int [] result4=sort.shellSort(sourceArray);
//        System.out.println("[");
//        for (int i = 0; i < result4.length; i++) {
////            System.out.print(result4[i]+",");
//        }
//        System.out.print("]");
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(new Date().getTime()));
//        System.out.println(new Date().getTime());

        int[] result5 = sort.raisxSortMain(sourceArray);
                System.out.println("[");
        for (int i = 0; i < result5.length; i++) {
            System.out.print(result5[i]+",");
        }
        System.out.print("]");
    }
}

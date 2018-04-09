package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import 刷题.wangyi.domain.Person;


public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath*:spring/spring.xml");
        Person date = (Person)applicationContext.getBean("person");
        System.out.println(date.getInteger());
    }
}

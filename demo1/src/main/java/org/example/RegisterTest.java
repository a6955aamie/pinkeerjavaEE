package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegisterTest {
    public static void main(String[] args) {
//        ApplicationContext context;
//        context=new ClassPathXmlApplicationContext("register-annotation.xml");
//        Student student=(Student) context.getBean("Student");
//        System.out.println(Student.tospring());
//
//        ((AbstractApplicationContext) context).close();


         //注解的方式实现依赖注入
//        ApplicationContext context = new ClassPathXmlApplicationContext("register-annotation.xml");
//        Student student = context.getBean("student", Student.class);
//        System.out.println(Student.toSpring());
//        ((AbstractApplicationContext) context).close();


        ApplicationContext context = new ClassPathXmlApplicationContext("register-annotation.xml");
        Student student = context.getBean("Student", Student.class);
        System.out.println(student.toString());

        ((AbstractApplicationContext) context).close();

    }
}

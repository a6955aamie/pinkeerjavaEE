package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("Student")
@Scope("singleton")
public class Student {

    @Value("202211111111")
    private String number;
    @Value("123456")
    private String password;
    @Value("学生")
    private String identity;

    @Autowired
    private School School;

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", School=" + School +
                '}';
    }

    //初始化后节点的监控方法
    @PostConstruct
    public void init(){
        System.out.println("Student 对象初始化");
    }
    //销毁节点前的监控方法
    @PreDestroy
    public void destory(){
        System.out.println("Student 对象销毁");
    }
}

package org.example;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements  UserService{

    @Override
    public void insert() {
        System.out.println("UserServiceImpl.insert()");
    }

    @Override
    public void update() {
        System.out.println("UserServiceImpl.update()");

//        有下面的就会抛出异常：update异常通知：数据异常！,,之后关闭文件
//        throw new RuntimeException("数据异常！");
    }
}

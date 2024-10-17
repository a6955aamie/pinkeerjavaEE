package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("aspect.xml");
        UserService userService=context.getBean("userServiceImpl",UserService.class);
        userService.insert();
        userService.update();

        // 关闭容器
        ((AbstractApplicationContext) context).close();



    }
}
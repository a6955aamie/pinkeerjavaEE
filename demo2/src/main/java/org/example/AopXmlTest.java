package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopXmlTest {
    public static void main(String[] args) {
        //加载aopXml.xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("aopXml.xml");
        // 如果实现类有父接口，第二个参数“requiredType”需要给定的是父接口，否则会报错
//        ProductImpl product = context.getBean("productImpl", ProductImpl.class);
        // 获取Bean的实例
        Product product = context.getBean("product", Product.class);
        product.insert();
        System.out.println("===================================================");
        product.delete();
        // 关闭容器
        ((AbstractApplicationContext) context).close();
    }
}


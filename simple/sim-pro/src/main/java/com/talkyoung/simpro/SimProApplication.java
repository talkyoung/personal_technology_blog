package com.talkyoung.simpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@MapperScan("com.talkyoung.simpojo.mapper")
public class SimProApplication{
//public class SimProApplication extends SpringBootServletInitializer {
//    //为了在tomcat容器中运行
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // 注意这里要指向原先用main方法执行的Application启动类
//        return builder.sources(SimProApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(SimProApplication.class, args);
    }

}

package com.talkyoung.ptbpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.talkyoung.ptbpojo.mapper")
public class PtbProApplication {
//public class SimProApplication extends SpringBootServletInitializer {
//    //为了在tomcat容器中运行
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // 注意这里要指向原先用main方法执行的Application启动类
//        return builder.sources(SimProApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(PtbProApplication.class, args);
    }

}

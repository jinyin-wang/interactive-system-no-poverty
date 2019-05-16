package com.hualala.openapiPlatform;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.hualala.openapiPlatform.mapper")
public class Application {
    /**
     * the engine or main function of this system,
     * */
    private static Logger logger1 = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger1.info("============= SpringBoot Start Success =============");
    }
}
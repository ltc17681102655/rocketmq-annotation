package com.yang.springbootrocketmq;

import com.maihaoche.starter.mq.annotation.EnableMQConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMQConfiguration
@SpringBootApplication
public class SpringBootRocketmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRocketmqApplication.class, args);
    }

}



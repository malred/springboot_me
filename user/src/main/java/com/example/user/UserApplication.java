package com.example.user;

import org.springboot.SpringApplication;
import org.springboot.SpringBootApplication;

// 这个类作为配置类传入spring容器,spring容器解析该类的注解
@SpringBootApplication
public class UserApplication {

  // 如果有@Bean也会被解析为bean
  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class);
  }
}

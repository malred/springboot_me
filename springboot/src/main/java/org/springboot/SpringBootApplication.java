package org.springboot;

import java.lang.annotation.*;

import org.springboot.webServer.WebServerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE) // 该注解可以加到类上
@Retention(RetentionPolicy.RUNTIME) // 运行时(可以被反射获取)
@Documented // 自动生成文档
@Inherited // 继承注解
@ComponentScan // 如果没有配置,会默认解析有该注解的类的包路径
@Import(WebServerAutoConfiguration.class) // 导入自动配置类
public @interface SpringBootApplication {
}

package org.springboot;

import java.util.Map;
import org.springboot.webServer.WebServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class SpringApplication {

  public static void run(Class clazz) {
    // 创建spring容器
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    // 注册配置类(这里用的是传入的那个类,也就是我们springboot项目的启动类)
    applicationContext.register(clazz);
    // 启动spring容器
    applicationContext.refresh();

    // 启动tomcat,jetty,undertow等web容器
    WebServer webServer = getWebServer(applicationContext);
    // 多态,不同实现类用不同web容器
    webServer.start(applicationContext);
  }

  private static WebServer getWebServer(
    WebApplicationContext applicationContext
  ) {
    Map<String, WebServer> beanOfType = applicationContext.getBeansOfType(
      WebServer.class
    );
    System.out.println(beanOfType);
    if (beanOfType.size() == 0) {
      throw new NullPointerException();
    }
    if (beanOfType.size() > 1) {
      throw new IllegalStateException();
    }
    return beanOfType.values().stream().findFirst().get();
  }
}

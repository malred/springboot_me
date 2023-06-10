package org.springboot.webServer;

import org.springboot.webServer.Conditional.MalredConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 创建Bean,创建不同web容器
public class WebServerAutoConfiguration {

  @Bean
  @MalredConditionalOnClass("org.apache.catalina.startup.Tomcat")
  public TomcatWebServer tomcatWebServer() {
    return new TomcatWebServer();
  }

  @Bean
  @MalredConditionalOnClass("org.eclipse.jetty.server.Server")
  public JettyWebServer jettyWebServer() {
    return new JettyWebServer();
  }
}

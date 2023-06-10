package org.springboot.webServer;

import org.springboot.webServer.Conditional.JettyConditional;
import org.springboot.webServer.Conditional.TomcatConditional; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
// 创建Bean,创建不同web容器
public class WebServerAutoConfiguration {

  @Bean
  @Conditional(TomcatConditional.class) // 为该bean的生效添加条件
  public TomcatWebServer tomcatWebServer() {
    return new TomcatWebServer();
  }

  @Bean
  @Conditional(JettyConditional.class)
  public JettyWebServer jettyWebServer() {
    return new JettyWebServer();
  }
}

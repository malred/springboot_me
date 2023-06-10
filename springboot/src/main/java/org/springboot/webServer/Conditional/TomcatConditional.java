package org.springboot.webServer.Conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自动配置类TomcatWebServer的bean的生效条件
 */
public class TomcatConditional implements Condition {

  @Override
  public boolean matches(
    ConditionContext context,
    AnnotatedTypeMetadata metadata
  ) {
    // 加载类,如果没有表示没有tomcat依赖
    try {
      context.getClassLoader().loadClass("org.apache.catalina.startup.Tomcat");
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}

package org.springboot.webServer.Conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自动配置类JettyWebServer的bean的生效条件
 */
public class JettyConditional implements Condition {

  @Override
  public boolean matches(
    ConditionContext context,
    AnnotatedTypeMetadata metadata
  ) {
    // 加载类,如果没有表示没有jetty依赖
    try {
      context.getClassLoader().loadClass("org.eclipse.jetty.server.Server");
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    } 
  }
}

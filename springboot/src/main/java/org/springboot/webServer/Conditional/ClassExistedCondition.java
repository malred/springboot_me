package org.springboot.webServer.Conditional;

import java.util.Map;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ClassExistedCondition implements Condition {

  @Override
  public boolean matches(
    ConditionContext context,
    AnnotatedTypeMetadata metadata
  ) {
    // 获取要加载的类
    Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(
      MalredConditionalOnClass.class.getName()
    );
    String className = (String) annotationAttributes.get("value");
    // 加载类,如果没有表示没有jetty依赖
    try {
      context.getClassLoader().loadClass(className);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}

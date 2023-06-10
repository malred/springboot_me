package org.springboot;

import java.util.ArrayList;
import org.springboot.webServer.WebServerAutoConfiguration;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class AutoConfigurationImportSelector implements DeferredImportSelector {

  /**
   * 返回所有要自动配置的类的名字,实现批量导入配置
   */
  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    // springboot默认+第三方jar 的自动配置类名字
    // jars -> META-INF/spring.factories.EnableAutoConfiguration
    ArrayList<String> autos = new ArrayList<>();
    autos.add(WebServerAutoConfiguration.class.getName());
    String[] array = (String[]) autos.toArray();
    return array;
  }
}

package com.wj.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*@Component 也行, 只要能被扫描到就可行*/
@Configuration
/*组件扫描: spring 在运行起来后先找 ComponentScan, 找到包的值, 扫描所有类上的的注解 */
@ComponentScan(basePackages = "com.wj.spring")
public class SpringConfig {

}

package com.wwy.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by wangxiaosan on 16/12/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.wwy.app")
@ImportResource("classpath*:spring-*.xml")
public class WebConfig extends WebMvcConfigurationSupport {

}

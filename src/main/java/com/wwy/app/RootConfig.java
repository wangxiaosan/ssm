package com.wwy.app;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by wangxiaosan on 16/11/9.
 */
@Configurable
@ComponentScan("com.wwy.app")
@ImportResource("classpath*:spring-*.xml")
public class RootConfig {
}

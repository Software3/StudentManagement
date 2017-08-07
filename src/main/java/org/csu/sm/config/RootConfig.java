package org.csu.sm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ltaoj on 2017/8/6.
 */
@Configuration
@ComponentScan(basePackages = {"org.csu.sm"},
        excludeFilters = {
          @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class RootConfig {
}
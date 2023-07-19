package com.hoangdp.heodat.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.hoangdp.heodat.dev.WindowBean;
import com.hoangdp.heodat.dev.condition.WindowOrMacRequired;

@Configuration
public class AppConfiguration {
    @Conditional(WindowOrMacRequired.class)
    @Bean
    WindowBean createWindowBean(){
        return new WindowBean();
    }
}

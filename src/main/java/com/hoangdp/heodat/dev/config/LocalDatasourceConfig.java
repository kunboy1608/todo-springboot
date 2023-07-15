package com.hoangdp.heodat.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hoangdp.heodat.dev.LocalDatasource;

@Configuration
@Profile("dev")
public class LocalDatasourceConfig {
    @Bean
    public LocalDatasource localDatasource() {
        return new LocalDatasource("Local object, Chỉ khởi tạo khi 'local' profile active");
    }
}

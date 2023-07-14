package com.hoangdp.heodat.dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hoangdp.heodat.dev.config.TodoValidator;

@Configuration
public class ToDoConfig {
    /**
     * Tạo ra Bean TodoValidator để sử dụng sau này
     * @return
     */
    @Bean
    public TodoValidator validator() {
        return new TodoValidator();
    }
}

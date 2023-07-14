package com.hoangdp.heodat.dev.config;

import org.thymeleaf.util.StringUtils;

import com.hoangdp.heodat.dev.Todo;

import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class TodoValidator {
    /**
     * Kiểm tra một object Todo có hợp lệ không
     * 
     * @param todo
     * @return
     */
    public boolean isValid(Todo todo){
        return Optional.ofNullable(todo)
        .filter(t -> !StringUtils.isEmpty(t.getTitle()))
        .filter(t-> !StringUtils.isEmpty(t.getDetail()))
        .isPresent();
    }
}

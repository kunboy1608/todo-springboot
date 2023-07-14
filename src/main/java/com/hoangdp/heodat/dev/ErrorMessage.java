package com.hoangdp.heodat.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessage {
    private int statusCode;
    private String message;
}

package com.example.web_app.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Error {
    private int code;
    private String message;
}

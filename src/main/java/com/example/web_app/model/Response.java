package com.example.web_app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Response {
    private boolean success;
    private int status;
    private Data data;
    private Error error;

    public Response(boolean success) {
        this.success = success;
    }

    public Response(boolean success, Data data) {
        this.success = success;
        this.data = data;
    }

    public Response(boolean success, Error error) {
        this.success = success;
        this.error = error;
    }

    public Response(boolean success, int status) {
        this.success = success;
        this.status = status;
    }
}

package com.example.Bootcamp.SinauKoding.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class Response implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;

    String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer row;

    HttpStatus httpStatus;

    public Response(String message, HttpStatus httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Response(Object object, String message, HttpStatus httpStatus){
        this.data = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Response(Object data, String message, Integer row, HttpStatus httpStatus){
        this.data = data;
        this.message = message;
        this.row = row;
        this.httpStatus = httpStatus;
    }
}

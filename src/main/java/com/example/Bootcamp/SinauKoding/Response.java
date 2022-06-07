package com.example.Bootcamp.SinauKoding;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Response implements Serializable {
    Object data;
    String message;
    HttpStatus httpStatus;

    public Response(Object object, String message, HttpStatus httpStatus){
        this.data = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}

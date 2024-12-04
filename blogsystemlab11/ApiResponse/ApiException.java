package com.example.blogsystemlab11.ApiResponse;

import lombok.Data;


public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}

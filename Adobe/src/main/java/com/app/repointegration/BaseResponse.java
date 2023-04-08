package com.app.repointegration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BaseResponse {

    private boolean status;
    private Object data;

    private String Status;

    // Success Response
    public static ResponseEntity<Object> responseBuilderObject(String Status, Object data, HttpStatus httpStatus){
        Map<String,Object> response=new HashMap<>();
        response.put("StatusCode",httpStatus);
        response.put("data",data);
        response.put("status",Status);
        return new ResponseEntity<>(response,httpStatus);
    }

    //Error Response data
    public  static ResponseEntity<Object> errorResponseBuilder(String status, Object myerrordetails, HttpStatus httpStatus){
        Map<String,Object> response=new HashMap<>();
        response.put("StatusCode",httpStatus);
        response.put("data",myerrordetails);
        response.put("status",httpStatus);
        return new ResponseEntity<>(response,httpStatus);
    }
}

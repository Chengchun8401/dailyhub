package com.city.dailyhub.vo;

import lombok.AllArgsConstructor;// 前后端数据协议
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private boolean success;

    private int code;

    private String msg;

    private Object data;

    public static Result success(String msg, Object data){
        return new Result(true, 200, msg, data);
    }

    public static Result fail(String msg, int code){
        return new Result(false, code, msg, null);
    }

}




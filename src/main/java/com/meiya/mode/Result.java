package com.meiya.mode;

import lombok.Data;

@Data
public class Result <T>{
    private Integer code;
    private String msg;
    private T data;

    private static <T> Result<T> build(T data, Integer code, String msg) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static<T> Result<T> ok(T data) {
        return build(data,20000,"操作成功");
    }
    public static<T> Result<T> ok(){
        return ok(null);
    }
    public static<T> Result<T> fail(T data) {
        return build(data,20001,"操作失败");
    }
    public static<T> Result<T> fail(){
        return fail(null);
    }
    public Result<T> msg(String msg){
        this.msg = msg;
        return this;
    }
    public Result<T> code(Integer code){
        this.code = code;
        return this;
    }
}

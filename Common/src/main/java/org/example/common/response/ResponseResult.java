package org.example.common.response;

import org.example.common.constants.CommonConstants;
import org.example.common.http.HttpStatus;

public class ResponseResult<T> {
    private int code;

    private String  msg;

    private T data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public static <T> ResponseResult success(T data){
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = HttpStatus.OK.getValue();
        responseResult.msg = CommonConstants.EMPTY_STRING;
        responseResult.data = data;
        return responseResult;
    }

    public static <T> ResponseResult success(String msg, T data){
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = HttpStatus.OK.getValue();
        responseResult.msg = msg;
        responseResult.data = data;
        return responseResult;
    }

    public static <T> ResponseResult fail(int code, String msg){
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = code;
        responseResult.msg = msg;
        responseResult.data = CommonConstants.EMPTY_STRING;
        return responseResult;
    }

    public static <T> ResponseResult fail(int code, String msg, Object data){
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = code;
        responseResult.msg = msg;
        responseResult.data = data;
        return responseResult;
    }

}

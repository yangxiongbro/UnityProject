package org.example.common.spring.boot.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.example.common.constants.CommonConstants;
import org.example.common.response.ResponseResult;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    /**
     * 校验错误拦截处理
     * 处理 Get 请求中 使用 @Valid 验证路径中请求实体校验失败后抛出的异常
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ResponseBody
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult<String> bindExceptionHandler(BindException exception) {
        log.error("BindException encountered: {}", exception);
        return ResponseResult.fail(HttpStatus.BAD_REQUEST.value(), getBindingResultMessage(exception.getBindingResult()));
    }

    /**
     * 校验错误拦截处理
     * 处理请求参数格式错误 @RequestParam 上 validate 失败后抛出的异常是 javax.validation.ConstraintViolationException
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult<String> constraintViolationHandler(ConstraintViolationException exception) {
        log.error("ConstraintViolationException encountered: {}", exception);
        return ResponseResult.fail(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    /**
     * 校验错误拦截处理
     * 处理请求参数格式错误 @RequestBody 上 validate 失败后抛出的异常是 MethodArgumentNotValidException 异常。
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult<String> methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        log.error("MethodArgumentNotValidException encountered: {}", exception);
        return ResponseResult.fail(HttpStatus.BAD_REQUEST.value(), getBindingResultMessage(exception.getBindingResult()));
    }

    private String getBindingResultMessage(BindingResult bindingResult){
        if(null == bindingResult){
            return CommonConstants.EMPTY_STRING;
        }
        return bindingResult.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining());
    }
}

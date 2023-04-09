package org.example.common.spring.boot.exceptions.base;

/**
 * <b><code>BaseException</code></b>
 * <p/>
 * 基础异常类
 * <p/>
 * <b>Creation Time:</b> 2022/8/24 下午12:31.
 *
 * @author yang xiong
 */

public abstract class BaseException extends Exception {
    private IExceptionAssertResponseEnum exceptionAssertResponseEnum;
    private Object[] args;
    private String message;
    private Throwable cause;

    public BaseException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message){
        this.exceptionAssertResponseEnum = exceptionAssertResponseEnum;
        this.args = args;
        this.message = message;
    }

    public BaseException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message, Throwable cause) {
        this.exceptionAssertResponseEnum = exceptionAssertResponseEnum;
        this.args = args;
        this.message = message;
        this.cause = cause;
    }

    public IExceptionAssertResponseEnum getExceptionAssertResponseEnum() {
        return exceptionAssertResponseEnum;
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}
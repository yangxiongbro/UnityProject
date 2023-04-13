package org.example.common.spring.boot.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.common.response.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    /**
     *  判断是否要执行beforeBodyWrite方法,true为执行,false不执行. 通过该方法可以选择哪些类或那些方法的response要进行处理, 其他的不进行处理.
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        // 添加了 @ResponseBody、@RestController 这两个注解的才进行包装
        if (methodParameter.getMethodAnnotation(ResponseBody.class) != null ||
                AnnotationUtils.findAnnotation(methodParameter.getContainingClass(), ResponseBody.class) != null) {
            return true;
        }
        return false;
    }

    /**
     * 对response方法进行具体操作处理
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 本身已经是封装好的对象
        if (body instanceof ResponseResult) {
            return body;
        }
        // 返回类型是 String（特殊）
        if (String.class.equals(methodParameter.getMethod().getReturnType())) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(ResponseResult.success(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return ResponseResult.success(body);
    }
}

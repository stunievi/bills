package com.yishudan.bills.bean;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.util.StringUtils;
import com.yishudan.bills.common.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * @description:
 * @author: Stunievi
 * @time: 2020/11/20 16:54
 */
@Configuration
@EnableWebMvc
public class GlobalReturnConfig {
    @RestControllerAdvice
    static class ResultResponseAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            if (body instanceof Result) {
                return body;
            }
//            return new Result().success(body);
            return JSON.toJSONString(new Result().success(body));
        }
    }
    /**
     * 全局异常处理
     */
    @ExceptionHandler
    public Object handleException(HttpServletRequest request, HttpServletResponse response, final Exception e) {
        e.printStackTrace();
        // 校验异常
        if(e instanceof MethodArgumentNotValidException){
            ArrayList<String> errs = new ArrayList<>();
            for (FieldError fieldError : ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors()) {
                errs.add(fieldError.getDefaultMessage());
            }
            return JSON.toJSONString(new Result().failure(StringUtils.join(errs ,",")));
        }else  if(e instanceof RuntimeException) {
            return JSON.toJSONString(new Result().failure(e.getMessage()));
        }
        return JSON.toJSONString(new Result().failure("服务器开小差了"));
    }
}

package org.example.domain.InterceptResponseOrexception.handler;

import org.apache.catalina.connector.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RequestBodyHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

//    todo 使用这个请求体封装处理，一定要返回List等对象，因为内部处理http的转换器对于不同类型有不同的处理，
//    存在关键抽象类AbstractHttpMessageConverter
//    当我使用String和Oject时都会遇到转换类型，大概都会走到ObjectToStringHttpMessageConverter，发生类型转换错误
//    而List等对象则不会遇到这个错误，这里猜测，底层处理会由于伪泛型失效、
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body==null){
            return org.example.domain.InterceptResponseOrexception.handler.Response.ok();
        }
        if (body.getClass().isAssignableFrom(ErrorInfo.class)){
            return org.example.domain.InterceptResponseOrexception.handler.Response.fail(((ErrorInfo) body).getCode(), ((ErrorInfo) body).getInfo());
        }
        return (Object) org.example.domain.InterceptResponseOrexception.handler.Response.ok(body);
    }
}

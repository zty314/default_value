package com.diligent.gogogo;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/8/18 11:17
 */
public class HappyMethodProcessor extends RequestResponseBodyMethodProcessor {

    /**
     * Basic constructor with converters only. Suitable for resolving
     * {@code @RequestBody}. For handling {@code @ResponseBody} consider also
     * providing a {@code ContentNegotiationManager}.
     *
     * @param converters
     */
    public HappyMethodProcessor(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }


    /**
     * Throws MethodArgumentNotValidException if validation fails.
     *
     * @param parameter
     * @param mavContainer
     * @param webRequest
     * @param binderFactory
     * @throws HttpMessageNotReadableException if {@link RequestBody#required()}
     *                                         is {@code true} and there is no body content or if there is no suitable
     *                                         converter to read the content with.
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Object argument = super.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        if (null == argument) {
            return null;
        }
        handlerDefaultValue(argument);

        return argument;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException, HttpMessageNotWritableException {
        if (null != returnValue) {
            try {
                handlerDefaultValue(returnValue);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        super.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }

    private void handlerDefaultValue(Object argument) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // 新增
        Field[] fields = argument.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (null != field.getAnnotation(ApiModelProperty.class)) {
                String fieldName = toUpperFirstOne(field.getName());
                Method getMethod = argument.getClass().getDeclaredMethod("get" + fieldName);
                getMethod.setAccessible(true);
                Object o = getMethod.invoke(argument);
                Class<?> type = field.getType();
                if (null == o) {
                    String value = field.getAnnotation(ApiModelProperty.class).defaultValue();
                    if (StringUtils.isBlank(value)) {
                        continue;
                    }
                    Method setMethod = argument.getClass().getDeclaredMethod("set" + fieldName, type);
                    setMethod.setAccessible(true);
                    if (type.equals(String.class)) {
                        setMethod.invoke(argument, value);
                    } else if (type.equals(Integer.class)) {
                        setMethod.invoke(argument, Integer.valueOf(value));
                    } else if (type.equals(Boolean.class)) {
                        setMethod.invoke(argument, "1".equals(value));
                    } else if (type.equals(List.class)) {
                        setMethod.invoke(argument, new ArrayList<>());
                    }
                }
            }
        }
    }

    private String toUpperFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return Character.toUpperCase(s.charAt(0)) +
                    s.substring(1);
        }
    }
}
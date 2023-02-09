package com.kedacom.meeting.api.config;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/9/19 17:14
 */
@RestControllerAdvice
@Slf4j
public class RequestResponseBodyAdvice implements RequestBodyAdvice, ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasParameterAnnotation(RequestBody.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        try {
            return handlerRequestBody(body);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            log.error("afterBodyRead", e);
        }
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.hasMethodAnnotation(ApiOperation.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        try {
            return handlerResponseBody(body);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            log.error("beforeBodyWrite", e);
        }
        return body;
    }

    private Object handlerRequestBody(Object argument) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // 新增
        Class<?> argumentClass = argument.getClass();
        Field[] fields = argumentClass.getDeclaredFields();
        handlerRequestDefaultValue(fields, argument, argumentClass);
        Class<?> superclass = argumentClass.getSuperclass();
        while (null != superclass) {
            Field[] superFields = superclass.getDeclaredFields();
            handlerRequestDefaultValue(superFields, argument, superclass);
            superclass = superclass.getSuperclass();
        }
        return argument;
    }

    private void handlerRequestDefaultValue(Field[] fields, Object argument, Class<?> argClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        for (Field field : fields) {
            field.setAccessible(true);
            if (null != field.getAnnotation(ApiModelProperty.class)) {
                String fieldName = toUpperFirstOne(field.getName());
                Method getMethod = argClass.getDeclaredMethod("get" + fieldName);
                getMethod.setAccessible(true);
                Object o = getMethod.invoke(argument);
                Class<?> type = field.getType();
                if (null == o) {
                    String value = field.getAnnotation(ApiModelProperty.class).defaultValue();
//                    String[] dict = field.getAnnotation(ApiModelProperty.class).dict();
//                    boolean isEnums = dict.length > 1;
//                    boolean isContains = Arrays.asList(dict).contains(value);
                    Method setMethod = argClass.getDeclaredMethod("set" + fieldName, type);
                    setMethod.setAccessible(true);
                    if (type.equals(String.class)) {
                        /*if (isEnums && isContains) {
                            setMethod.invoke(argument, value);
                        }else if(isEnums && StringUtils.isNotBlank(value)){
                            setMethod.invoke(argument, dict[0].split(":")[0]);
                        }else*/
                        if (StringUtils.isNotBlank(value)) {
                            setMethod.invoke(argument, value);
                        }
                    } else if (type.equals(Integer.class)) {
                        /*if (isEnums && isContains) {
                            setMethod.invoke(argument, Integer.valueOf(value));
                        }else if(isEnums && StringUtils.isNotBlank(value)){
                            setMethod.invoke(argument, Integer.valueOf(dict[0].split(":")[0]));
                        }else*/
                        if (StringUtils.isNotBlank(value)) {
                            setMethod.invoke(argument, Integer.valueOf(value));
                        }
                    } else if (type.equals(Boolean.class)) {
                        /*if (isEnums && isContains) {
                            setMethod.invoke(argument, "1".equals(value));
                        }else if(isEnums && StringUtils.isNotBlank(value)){
                            setMethod.invoke(argument, "1".equals(dict[0].split(":")[0]));
                        }else*/
                        if (StringUtils.isNotBlank(value)) {
                            setMethod.invoke(argument, "1".equals(value));
                        }
                    }
                }
            }
        }
    }

    private Object handlerResponseBody(Object argument) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // 新增
        Class<?> argumentClass = argument.getClass();
        Field[] fields = argumentClass.getDeclaredFields();
        handlerResponseDefaultValue(fields, argument, argumentClass);
        Class<?> superclass = argumentClass.getSuperclass();
        while (null != superclass) {
            Field[] superFields = superclass.getDeclaredFields();
            handlerResponseDefaultValue(superFields, argument, superclass);
            superclass = superclass.getSuperclass();
        }
        return argument;
    }

    private void handlerResponseDefaultValue(Field[] fields, Object argument, Class<?> argClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        for (Field field : fields) {
            field.setAccessible(true);
            if (null != field.getAnnotation(ApiModelProperty.class)) {
                String fieldName = toUpperFirstOne(field.getName());
                Method getMethod = argClass.getDeclaredMethod("get" + fieldName);
                getMethod.setAccessible(true);
                Object o = getMethod.invoke(argument);
                Class<?> type = field.getType();
                if (null == o) {
                    String value = field.getAnnotation(ApiModelProperty.class).defaultValue();
                    Method setMethod = argClass.getDeclaredMethod("set" + fieldName, type);
                    setMethod.setAccessible(true);
                    if (type.equals(String.class) && StringUtils.isNotBlank(value)) {
                        setMethod.invoke(argument, value);
                    } else if (type.equals(Integer.class) && StringUtils.isNotBlank(value)) {
                        if (StringUtils.isNotBlank(value)) {
                            setMethod.invoke(argument, Integer.valueOf(value));
                        }
                    } else if (type.equals(Boolean.class) && StringUtils.isNotBlank(value)) {
                        setMethod.invoke(argument, "1".equals(value));
                    } else if (type.equals(List.class)) {
//                        Type genericType = field.getGenericType();
//                        if (genericType instanceof ParameterizedType) {
//                            ParameterizedType pt = (ParameterizedType) genericType;
//                            Class<?> genericClazz = (Class<?>) pt.getActualTypeArguments()[0];
//                            if (isPrimitive(genericClazz)) {
//                                setMethod.invoke(argument, new ArrayList<>());
//                                continue;
//                            }
//                            Object o1 = genericClazz.newInstance();
//                            Field[] argufields = genericClazz.getDeclaredFields();
//                            handlerResponseDefaultValue(argufields, o1, genericClazz);
//                            setMethod.invoke(argument, Collections.singletonList(o1));
//                        } else {
                        setMethod.invoke(argument, new ArrayList<>());
//                        }
                    } else if (!isPrimitive(type)) {
                        Field[] argufields = type.getDeclaredFields();
                        Object o1 = type.newInstance();
                        handlerResponseDefaultValue(argufields, o1, type);
                        setMethod.invoke(argument, o1);
                        //setMethod.invoke(argument, new Object());
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

    private boolean isPrimitive(Class<?> clazz) {
        return clazz.equals(Integer.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(Float.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(Boolean.class);
    }
}
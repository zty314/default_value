package com.diligent.gogogo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/7/14 19:43
 */
//@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


    /**
     * Override this method to extend or modify the list of converters after it has
     * been configured. This may be useful for example to allow default converters
     * to be registered and then insert a custom converter through this method.
     *
     * @param converters the list of configured converters to extend
     * @since 4.1.3
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(new ToStringSerializer(Long.TYPE));
        module.addSerializer(new ToStringSerializer(Long.class));
        module.addSerializer(new ToStringSerializer(BigInteger.class));
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString("");
            }
        });
        objectMapper.registerModule(module);
        converter.setObjectMapper(objectMapper);

        //这里是fastJSON的配置方式，更多的内容可以查看SerializerFeature
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        converter.setFeatures(SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero,
//                SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty);
        converters.add(converter);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        ApplicationContext context = getApplicationContext();
//        RequestMappingHandlerMapping bean = context.getBean(RequestMappingHandlerMapping.class);

        registry.addWebRequestInterceptor(new WebRequestInterceptor() {
            @Override
            public void preHandle(WebRequest request) throws Exception {
                request.getHeader("API-LEVEL");
                request.getHeader("API-LEVEL");
                request.setAttribute("API-LEVEL","1000",WebRequest.SCOPE_REQUEST);
                System.out.println("11111");
            }

            @Override
            public void postHandle(WebRequest request, ModelMap model) throws Exception {
                System.out.println("22222");
            }

            @Override
            public void afterCompletion(WebRequest request, Exception ex) throws Exception {
                System.out.println("33333");
            }
        });
    }

    /**
     * Add custom {@link HandlerMethodArgumentResolver HandlerMethodArgumentResolvers}
     * to use in addition to the ones registered by default.
     * <p>Custom argument resolvers are invoked before built-in resolvers except for
     * those that rely on the presence of annotations (e.g. {@code @RequestParameter},
     * {@code @PathVariable}, etc). The latter can be customized by configuring the
     * {@link RequestMappingHandlerAdapter} directly.
     *
     * @param argumentResolvers the list of custom converters (initially an empty list)
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        HappyMethodProcessor processor = new HappyMethodProcessor(getMessageConverters());
//        argumentResolvers.add(processor);
        RequestResponseBodyMethodProcessor processor = new RequestResponseBodyMethodProcessor(getMessageConverters());
        argumentResolvers.add(processor);
        super.addArgumentResolvers(argumentResolvers);
    }
}
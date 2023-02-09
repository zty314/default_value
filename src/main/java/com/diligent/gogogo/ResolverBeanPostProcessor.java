package com.diligent.gogogo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class ResolverBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("fixMeController2".equalsIgnoreCase(beanName)) {
            System.out.println("-----------before-----------" + beanName);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("---------------after----------------" + beanName);
        if (bean instanceof RequestMappingHandlerAdapter) {
            RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) bean;

            HappyMethodProcessor happyMethodProcessor = new HappyMethodProcessor(adapter.getMessageConverters());
            //添加自定义参数处理器
            List<HandlerMethodArgumentResolver> resolvers = addArgumentResolvers(adapter, happyMethodProcessor);
            adapter.setArgumentResolvers(resolvers);
            List<HandlerMethodReturnValueHandler> valueHandlers = addReturnValueHandlers(adapter, happyMethodProcessor);
            adapter.setReturnValueHandlers(valueHandlers);
        }
        return bean;
    }


    private List<HandlerMethodArgumentResolver> addArgumentResolvers(RequestMappingHandlerAdapter adapter, HandlerMethodArgumentResolver resolver) {
        List<HandlerMethodArgumentResolver> resolvers = new ArrayList<>();
        //将自定的添加到最前面
        resolvers.add(resolver);
        //将原本的添加后面
        resolvers.addAll(adapter.getArgumentResolvers());
        return resolvers;
    }

    private List<HandlerMethodReturnValueHandler> addReturnValueHandlers(RequestMappingHandlerAdapter adapter, HandlerMethodReturnValueHandler handler) {
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>();
        handlers.add(handler);
        handlers.addAll(adapter.getReturnValueHandlers());
        return handlers;
    }
}


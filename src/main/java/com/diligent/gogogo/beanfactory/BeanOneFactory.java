package com.diligent.gogogo.beanfactory;

import com.diligent.gogogo.alotsofbeans.BeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/8/10 10:13
 */
@Configuration
public class BeanOneFactory {

    @Bean
    public BeanOne returnBeanOne(){
        return new BeanOne("娃哈哈");
    }
}
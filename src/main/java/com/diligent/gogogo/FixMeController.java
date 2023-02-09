package com.diligent.gogogo;

import com.diligent.gogogo.alotsofbeans.BeanOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/7/14 19:46
 */
@RestController
public class FixMeController {

    @Autowired
    private BeanOne beanOne;

    @RequestMapping("/fixme/gogogo")
    public String gogo(HttpServletRequest request){
        System.out.println("ggggggg");
        System.out.println(request.getAttribute("API-LEVEL"));
        System.out.println(beanOne);
        return "gogogo";
    }
}
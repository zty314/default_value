package com.diligent.gogogo;

import com.diligent.gogogo.alotsofbeans.BeanOne;
import com.diligent.gogogo.alotsofbeans.BeanTwo;
import com.diligent.gogogo.alotsofbeans.dto.BaseMeetingInfoDTO;
import com.diligent.gogogo.alotsofbeans.dto.TemplatePersonalDTO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/7/14 19:46
 */
@RestController
@RequestMapping("/fff")
@Slf4j
public class FixMeController2 implements InitializingBean {

    @Autowired
    private BeanOne beanOne;

    @PostMapping("/fixme/gogogo")
    public BeanTwo gogo(@RequestBody BeanTwo two){
        return two;
    }

    @ApiOperation(value = "获取模板混音预案信息列表", notes = "return data")
    @PostMapping("/fixme/manual")
    public @ResponseBody
    BaseMeetingInfoDTO manual(@RequestBody TemplatePersonalDTO two){
        log.info(two.toString());
        return new TemplatePersonalDTO();
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSetafterPropertiesSetafterPropertiesSet");
    }
}
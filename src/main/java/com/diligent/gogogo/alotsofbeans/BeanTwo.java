package com.diligent.gogogo.alotsofbeans;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Map;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/8/10 10:12
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanTwo extends BeanThree implements InitializingBean {

    @JsonProperty(defaultValue = "忒烦了吧这也")
    private String name;
    @ApiModelProperty(defaultValue = "^^^^^^^")
    private String name1;
    @ApiModelProperty(defaultValue = "$$$$$$$$")
    private String name2;
    @ApiModelProperty(defaultValue = "%%%%%%%%")
    private String name3;
    @ApiModelProperty(defaultValue = "aaa")
    private List<String> names;
    @ApiModelProperty(defaultValue = "aaa")
    private Map<String,String> namemap;


    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----------------afterPropertiesSet----------------");
    }
}
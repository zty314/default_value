package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhaoyubin
 * @date 2022/2/11
 */
@Data
@ApiModel
public class PreTemplateDTO {

    @ApiModelProperty("预案id")
    private String id;

    @ApiModelProperty("预案名称")
    private String name;


//    public static PreTemplateDTO fromTemplate(TemplatePreBO preBO) {
//        PreTemplateDTO dto = new PreTemplateDTO();
//        dto.setId(preBO.getId());
//        dto.setName(preBO.getName());
//        return dto;
//    }
}

package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by zhaoyubin on 2021/11/18.
 */
@ApiModel
@Data
public class AIDTO {

    @ApiModelProperty(value = "会议纪要", dict = {"1:开启", "2:关闭"}, dataType = "java.lang.Integer", example = "0", required = true)
    private Boolean record;

    @ApiModelProperty(value = "会议签到", dict = {"1:开启", "2:关闭"}, dataType = "java.lang.Integer", example = "0", required = true)
    private Boolean sign;

    @ApiModelProperty(value = "同声字幕", dict = {"1:开启", "2:关闭"}, dataType = "java.lang.Integer", example = "0", required = true)
    private Boolean subtitle;

}

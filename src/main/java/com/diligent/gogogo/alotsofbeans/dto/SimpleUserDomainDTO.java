package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author sunzheng
 * @version 1.0.0
 * @Description 可见用户域
 * @date 2022年05月12日
 */
@Data
@ApiModel
public class SimpleUserDomainDTO {
    @ApiModelProperty("用户域moid")
    private String moid; // 用户域Moid
}

/**
 * @(#)PersonalTemplate.java 2016年5月18日 Copyright 2016 it.kedacom.com, Inc. All
 * rights reserved.
 */

package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 个人模板详情
 *
 * @author fankaijian
 * @date 2016年5月18日
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@ApiModel
@Slf4j
public class TemplatePersonalDTO extends BaseMeetingInfoDTO {


    @ApiModelProperty(value = "移动电话", open = false)
    private String mobile;

    @ApiModelProperty(value = "分机号码", open = false)
    private String telephone;

    @ApiModelProperty(value = "个人模板id", open = false)
    private String templateId;

    @ApiModelProperty(value = "是否开启预分配会议号", dict = {"0:关闭", "1:开启"}, defaultValue = "0")
    private Integer bindE164;

    @ApiModelProperty(value = "预分配会议号", open = false)
    private String e164;

    @ApiModelProperty(value = "会议等级", notes = "0—16 数字越大会议等级越高")
    private String confLevel;

    @ApiModelProperty(value = "会议类型", dict = {"0:传统", "1:端口", "2:SFU纯转发会议"}, required = true)
    private Integer confType;
}

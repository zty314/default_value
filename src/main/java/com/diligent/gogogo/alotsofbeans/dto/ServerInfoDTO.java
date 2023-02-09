package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by zhaoyubin on 2022/1/18.
 */
@Data
@ApiModel("serverInfo")
public class ServerInfoDTO {

    @ApiModelProperty(value = "jd2000", dataType = "java.lang.Integer")
    private Boolean jd2000;

    @ApiModelProperty(value = "jd2100", dataType = "java.lang.Integer")
    private Boolean jd2100;

    @ApiModelProperty(value = "传统会议允许RTC混用", notes = "(默认打开)", dict = {"0:不允许", "1:显示,默认关闭", "2:显示,默认打开"})
    private Integer tradMix;

    @ApiModelProperty(value = "端口会议允许RTC混用", notes = "(默认打开)", dict = {"0:不允许", "1:显示,默认关闭", "2:显示,默认打开"})
    private Integer portMix;

    @ApiModelProperty(value = "是否一体机", dataType = "java.lang.Integer")
    private Boolean integrated;

    @ApiModelProperty(value = "是否配置动态口令服务器", dataType = "java.lang.Integer")
    private Boolean hasAuthServer;

    @ApiModelProperty(value = "是否支持sm1加密", dataType = "java.lang.Integer")
    private Boolean enableSm1;

    @ApiModelProperty(value = "是否支持60fps", dataType = "java.lang.Integer")
    private Boolean enable60fps;

    @ApiModelProperty(value = "是否支持60fps", dataType = "java.lang.Integer")
    private Boolean enable4k;

    @ApiModelProperty(value = "是否支持AI", dataType = "java.lang.Integer")
    private Boolean enableKis;

    @ApiModelProperty("系统时间")
    private LocalDateTime systemDate;

    @ApiModelProperty("品牌")
    private String brand;

    @ApiModelProperty(value = "是否支持量通", dict = {"1:支持", "0:不支持"}, dataType = "java.lang.Integer")
    private Boolean enableQuantum;

    @ApiModelProperty(value = "是否是独立运行模式", dataType = "java.lang.Integer")
    private Boolean standAlone;

    @ApiModelProperty(value = "平台密级",dict = {"1:秘密","2:机密一般","3:机密增强"})
    private Integer securityLevel;

//    public static ServerInfoDTO fromBO(ServerInfoBO bo) {
//        ServerInfoDTO dto = new ServerInfoDTO();
//        BeanUtils.copyProperties(bo, dto);
//        return dto;
//    }
}

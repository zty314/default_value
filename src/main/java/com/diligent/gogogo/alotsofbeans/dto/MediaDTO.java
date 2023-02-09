package com.diligent.gogogo.alotsofbeans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kedacom
 */
@ApiModel(value = "媒体参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDTO {
    @ApiModelProperty(value = "主流视频格式", dict = {"1:MPEG", "2:H.261", "3:H.263", "4:H.264_HP", "5:H.264_BP", "6:H.265", "7:H.263+"}, required = true, defaultValue = "3")
    @JsonProperty(value = "format")
    private Integer videoFormat;
    @ApiModelProperty(value = "主流视频分辨率", dict = {"1:QCIF", "2:CIF", "3:4CIF", "12:720P", "13:1080P", "14:WCIF", "15:W4CIF", "16:4k"}, required = true, defaultValue = "13")
    @JsonProperty(value = "resolution")
    private Integer videoResolution;
    @ApiModelProperty(value = "主流帧率", required = true, defaultValue = "30")
    @JsonProperty(value = "frame")
    private Integer videoFrame;
    @ApiModelProperty(value = "主流码率", required = true, defaultValue = "2048")
    @JsonProperty(value = "bitrate")
    private Integer videoRate;

//    public static MediaDTO fromBO(VmrMediaBO mediaBO) {
//        MediaDTO mediaDTO = new MediaDTO();
//        BeanUtils.copyProperties(mediaBO, mediaDTO);
//        return mediaDTO;
//    }
//
//    public VmrMediaBO toBO() {
//        VmrMediaBO mediaBO = new VmrMediaBO();
//        BeanUtils.copyProperties(this, mediaBO);
//        return mediaBO;
//    }
//
//    public VMeetingMediaBO toMedia(List<Integer> audioFormats) {
//        VMeetingMediaBO bo = new VMeetingMediaBO();
//        BeanUtils.copyProperties(this, bo);
//        if (CollectionUtils.isNotEmpty(audioFormats)) {
//            String audios = audioFormats.stream()
//                    .map(String::valueOf)
//                    .collect(Collectors.joining(","));
//            bo.setAudioFormat(audios);
//        }
//        return bo;
//    }
}

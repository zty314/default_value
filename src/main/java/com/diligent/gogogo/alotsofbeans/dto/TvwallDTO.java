package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author zhaoyubin
 * @date 2022/2/11
 */
@Data
@ApiModel
public class TvwallDTO {

    @ApiModelProperty(open = false)
    private String id;// 画面合成预案id, 跨级建云会议机房专用

    @ApiModelProperty("预案名称")
    private String name;

    @ApiModelProperty("电视墙列表")
    private List<TvwallStyleDTO> tvwalls;

//    public static TvwallDTO fromVMeeting(VMeetingTVWallBO tvWallBO, String e164, Boolean getMccInfo) {
//        if (null == tvWallBO){
//            return null;
//        }
//        TvwallDTO dto = new TvwallDTO();
//        dto.setName(tvWallBO.getName());
//        dto.setTvwalls(TvwallStyleDTO.fromVMeeting(tvWallBO.getTvwallList(), e164, getMccInfo));
//        return dto;
//    }
//
//    public static TemplateTvwallBO toTemplateBO(TvwallDTO tvwallDTO, Integer type) {
//        TemplateTvwallBO tvwallBO = new TemplateTvwallBO();
//        if (tvwallDTO != null) {
//            tvwallBO.setPreId(tvwallDTO.getId());
//            tvwallBO.setEnable(true);
//            tvwallBO.setName(tvwallDTO.getName());
//            tvwallBO.setDefaultType(type);
//            List<TemplateTvwallStyleBO> tvs = new ArrayList<>();
//            for (TvwallStyleDTO tvwall : tvwallDTO.getTvwalls()) {
//                tvs.add(TvwallStyleDTO.toTemplateBO(tvwall, type));
//            }
//            tvwallBO.setTvwallStyle(tvs);
//        } else {
//            tvwallBO.setEnable(false);
//            tvwallBO.setName("");
//        }
//        return tvwallBO;
//    }
//
//    public static VMeetingTVWallBO toVMeetingBO(TvwallDTO tvwallDTO, Integer defaultType) {
//        VMeetingTVWallBO tvWallBO = new VMeetingTVWallBO();
//        if (tvwallDTO != null) {
//            tvWallBO.setId(tvwallDTO.getId());
//            tvWallBO.setEnable(true);
//            tvWallBO.setName(tvwallDTO.getName());
//            tvWallBO.setDefaultType(defaultType);
//            List<TvwallStyleDTO> tvWallStyleDTOList = tvwallDTO.getTvwalls();
//            if (tvWallStyleDTOList != null && !tvWallStyleDTOList.isEmpty()) {
//                List<VMeetingTVWallStyleBO> tvWallStyleBOS = new ArrayList<>();
//                for (TvwallStyleDTO tvWallStyleDTO : tvWallStyleDTOList) {
//                    tvWallStyleBOS.add(TvwallStyleDTO.toVMeeting(tvWallStyleDTO, defaultType));
//                }
//                tvWallBO.setTvwallList(tvWallStyleBOS);
//            }
//        } else {
//            tvWallBO.setEnable(false);
//            tvWallBO.setName("");
//        }
//        return tvWallBO;
//    }
//
//    public VMeetingTVWallBO toMeetingTvwall(Integer preType, boolean enable) {
//        VMeetingTVWallBO bo = new VMeetingTVWallBO();
//        bo.setId(this.getId());
//        bo.setEnable(enable);
//        bo.setDefaultType(preType);
//        if (CollectionUtils.isNotEmpty(this.getTvwalls())) {
//            bo.setTvwallList(this.getTvwalls().stream().map(TvwallStyleDTO::toMeetingTvwallStyle).collect(Collectors.toList()));
//        }
//        return bo;
//    }
}

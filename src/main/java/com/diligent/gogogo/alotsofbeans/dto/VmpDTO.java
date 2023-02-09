/**
 * @(#)Vmp.java 2016年5月4日 Copyright 2016 it.kedacom.com, Inc. All rights
 * reserved.
 */

package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author kedacom
 */
@ApiModel
@Data
public class VmpDTO {

    @ApiModelProperty(open = false)
    private String id;// 画面合成预案id, 跨级建云会议机房专用

    @ApiModelProperty(value = "画面合成模式", dict = {"1:定制画面合成", "2:自动画面合成", "3:自动画面合成批量轮询(预留)", "4:定制画面合成批量轮询"}, required = true, example = "2")
    private Integer mode;

    @ApiModelProperty(value = "预案名称", open = false)
    private String name;

    @ApiModelProperty(value = "画面合成风格", dict = {
            "1:一画面全屏",
            "2:两画面: 2等大,居中(1行2列)",
            "3:两画面: 1大1小,1大全屏,1小右下",
            "61:两画面: 1大1小,1大全屏,1小右上",
            "62:两画面: 1大1小,1大全屏,1小左上",
            "63:两画面: 1大1小,1大全屏,1小左下",
            "23:三画面: 等大,1左,2右(2行1列)",
            "4:三画面: 等大,1上2下",
            "22:三画面: 1大2小,1大左,2小右(2行1列)",
            "5:四画面: 等大,2行2列",
            "12:四画面: 1大3小,1大左,3小右(3行1列)",
            "26:四画面: 1大3小,1大上,3小下(1行3列)",
            "35:五画面: 1大4小,1大上,4小下(1行4列)",
            "34:五画面: 1大4小,1大左,4小右(4行1列)",
            "6:六画面: 1大5小,1大左上,2小右上(2行1列),3小下(1行3列)",
            "64:六画面: 1大5小,1大左,5小右(5行1列),3小下(1行3列)",
            "13:七画面: 3大4小,2大上(1行2列),1大左下,4小右下(2行2列)",
            "7:八画面: 1大7小,1大左上,3小右上(3行1列),4小下(1行4列)",
            "8:九画面: 等大,3行3列",
            "18:十画面: 2大8小,4小上(1行4列),2大中(1行2列),4小下(1行4列)",
            "38:十一画面: 1大10小,1大上,10小下(2行5列)",
            "65:十一画面: 3大8小,3大上(1行3列),8小下(2行4列)",
            "39:十二画面: 3大9小,2大上(1行2列),1大左下,9小右下(3行3列)",
            "66:十二画面: 2大10小,2大上(1行2列),10小下(2行5列)",
            "19:十三画面: 1大12小,4小上(1行4列),2小左中(2行1列),1大中中,2小右中(2行1列), 4小下(1行4列)",
            "17:十四画面: 2大12小,2大左上(1行2列),2小右上(2行1列),10小下(2行5列)",
            "20:十五画面: 3大12小,3大上(1行3列),12小下(2行6列)",
            "67:十五画面: 1大14小,1大左上,8小右上(4行2列),6小下(1行6列)",
            "11:十六画面: 16等分,4x4",
            "46:十七画面: 1大16小,1大左上,6小右上(3行2列),10小下(2行5列)",
            "48:十八画面: 6大12小,6小上(1行6列),6大居中(2行3列),6小下(1行6列)",
            "51:十九画面: 2大17小,2大左上(1行2列),2小右上(2行1列),15小下(3行5列)",
            "14:二十画面: 2大18小,2大上(1行2列),18小下(3行6列)",
            "54:二十一画面: 1大20小,6小上(1行6列),4小左中(4行1列),1大中中,4小右中(4行1列),6小下(1行6列)",
            "56:二十二画面: 1大21小,1大左上,6小右上(2行3列),15小下(3行5列)",
            "59:二十四画面: 4大20小,6小上(1行6列),4小左中(4行1列),4大中中(2行2列),4小右中(4行1列),6小下(1行6列)",
            "27:二十五画面: 等大,5行5列"}, required = true, example = "5")
    private Integer layout;

    @ApiModelProperty(value = "是否开启自动画面合成n-1模式", notes = "即不显示自己的画面,仅自动画面合成时有效", defaultValue = "0")
    private Integer exceptSelf;

    @ApiModelProperty(value = "是否识别声音来源", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", required = true, example = "1")
    private Boolean voiceHint;

    @ApiModelProperty(value = "是否向终端广播", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", required = true, example = "1")
    private Boolean broadcast;

    @ApiModelProperty(value = "是否显示别名", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", required = true, example = "1")
    private Boolean showMtName;

    @ApiModelProperty("画面合成参数")
    private MtNameStyleDTO mtNameStyle;

    @ApiModelProperty(value = "画面合成成员", required = true)
    private List<VmpMemberDTO> members;

    @ApiModelProperty("批量轮询")
    private PollDTO poll;

//    public static VmpDTO fromTemplate(TemplateVmpBO vmp, String e164) {
//        if (vmp == null) {
//            return null;
//        }
//        VmpDTO info = new VmpDTO();
//        info.setBroadcast(vmp.getBroadcast());
//        info.setLayout(vmp.getStyle());
//        info.setExceptSelf(vmp.getnMinusOneMode());
//        info.setShowMtName(vmp.getShowMtName());
//        info.setVoiceHint(vmp.getVoiceHint());
//        MtNameStyleDTO mtNameStyle = new MtNameStyleDTO();
//        mtNameStyle.setFontColor(
//                TemplatePersonalResp.fromRGB(
//                        vmp.getAliaRcolor(),
//                        vmp.getAliaGcolor(),
//                        vmp.getAliaBcolor()));
//        mtNameStyle.setFontSize(vmp.getAliaSize());
//        mtNameStyle.setPosition(vmp.getAliaLocation());
//        info.setMtNameStyle(mtNameStyle);
//        //自动画面合成
//        int mode = PreConstants.VMP_MODE_AUTO;
//        if (vmp.getVmpBatchPoll() != null && CollectionUtils.isNotEmpty(vmp.getVmpBatchPoll().getMemberList())) {
//            //批量轮询
//            mode = PreConstants.VMP_STYLE_CUSTOM_BATCH_POLL;
//            info.setPoll(PollDTO.fromTemplate(vmp.getVmpBatchPoll(), e164));
//        } else {
//            List<VmpMemberDTO> vmpMemberDTOS = VmpMemberDTO.fromTemplate(vmp.getMemberList(), e164);
//            info.setMembers(vmpMemberDTOS);
//            //定制画面合成
//            if (CollectionUtils.isNotEmpty(vmpMemberDTOS)) {
//                mode = PreConstants.VMP_MODE_CUSTOM;
//            }
//        }
//        info.setMode(mode);
//        return info;
//    }
//
//    public static TemplateVmpBO toTemplateBO(VmpDTO vmpDTO, Integer type) {
//        if (vmpDTO == null) {
//            return new TemplateVmpBO();
//        }
//        TemplateVmpBO vmpBO = new TemplateVmpBO();
//        vmpBO.setEnable(PreConstants.PRE_ENABLE_TRUE);
//        vmpBO.setId(vmpDTO.getId());
//        //默认显示终端名称
//        vmpBO.setShowMtName(vmpDTO.getShowMtName() == null || vmpDTO.getShowMtName());
//        vmpBO.setStyle(PreConstants.VMP_MODE_AUTO.equals(vmpDTO.getMode()) ? PreConstants.VMP_STYLE_AUTO : vmpDTO.getLayout());
//        //默认广播
//        vmpBO.setBroadcast(vmpDTO.getBroadcast() == null || vmpDTO.getBroadcast());
//        //默认识别声音来源
//        vmpBO.setVoiceHint(vmpDTO.getVoiceHint() == null || vmpDTO.getVoiceHint());
//        //默认开闭n-1模式
//        vmpBO.setnMinusOneMode(vmpDTO.getExceptSelf() == null ? 0 : vmpDTO.getExceptSelf());
//
//        if (vmpDTO.getMtNameStyle() != null) {
//            MtNameStyleDTO nameStyle = vmpDTO.getMtNameStyle();
//            vmpBO.setAliaLocation(nameStyle.getPosition());
//            vmpBO.setAliaSize(nameStyle.getFontSize());
//            Integer[] rgb = MtNameStyleDTO.toRGB(nameStyle.getFontColor());
//            vmpBO.setAliaRcolor(rgb[0]);
//            vmpBO.setAliaGcolor(rgb[1]);
//            vmpBO.setAliaBcolor(rgb[2]);
//        } else {
//            //默认 中,左下角,白色
//            vmpBO.setAliaLocation(PreConstants.VMP_ALIA_LOCATION);
//            vmpBO.setAliaSize(PreConstants.VMP_ALIA_SIZE);
//            vmpBO.setAliaRcolor(PreConstants.VMP_ALIA_RCOLOR);
//            vmpBO.setAliaGcolor(PreConstants.VMP_ALIA_GCOLOR);
//            vmpBO.setAliaBcolor(PreConstants.VMP_ALIA_BCOLOR);
//        }
//        if (PreConstants.VMP_STYLE_CUSTOM_BATCH_POLL.equals(vmpDTO.getMode())) {
//            vmpBO.setVmpBatchPoll(PollDTO.toTemplateBO(vmpDTO.getPoll(), type));
//        } else if (PreConstants.VMP_MODE_CUSTOM.equals(vmpDTO.getMode())) {
//            List<TemplateVmpMemberBO> memberList =
//                    Optional.ofNullable(vmpDTO.getMembers()).orElseGet(ArrayList::new)
//                            .stream()
//                            .map(m -> {
//                                TemplateVmpMemberBO vmpm = new TemplateVmpMemberBO();
//                                vmpm.setAccount(m.getAccount());
//                                vmpm.setAccountType(m.getAccountType());
//                                vmpm.setPositionIndex(m.getChnIdx());
//                                vmpm.setType(m.getMemberType());
//                                vmpm.setParentId(m.getConfE164());
//                                if (m.getPoll() != null) {
//                                    vmpm.setPoll(PollDTO.toTemplateBO(m.getPoll(), type));
//                                }
//                                return vmpm;
//                            }).collect(Collectors.toList());
//            vmpBO.setMemberList(memberList);
//        }
//
//        vmpBO.setName(vmpDTO.getName());
//        vmpBO.setDefaultType(type);
//        return vmpBO;
//    }
//
//    public static VMeetingVmpBO toVMeetingBO(VmpDTO vmpDTO, Integer defaultType) {
//        VMeetingVmpBO vmpBO = new VMeetingVmpBO();
//        if (null != vmpDTO) {
//            vmpBO.setId(vmpDTO.getId());
//            vmpBO.setDefaultType(defaultType);
//            vmpBO.setEnable(true);
//            //默认显示终端名称
//            vmpBO.setShowMtName(vmpDTO.getShowMtName() == null || vmpDTO.getShowMtName());
//            vmpBO.setStyle(PreConstants.VMP_MODE_AUTO.equals(vmpDTO.getMode()) ? PreConstants.VMP_STYLE_AUTO : vmpDTO.getLayout());
//            //默认广播
//            vmpBO.setBroadcast(vmpDTO.getBroadcast() == null || vmpDTO.getBroadcast());
//            //默认识别声音来源
//            vmpBO.setVoiceHint(vmpDTO.getVoiceHint() == null || vmpDTO.getVoiceHint());
//            //默认开闭n-1模式
//            vmpBO.setNMinusOneMode(vmpDTO.getExceptSelf() == null ? 0 : vmpDTO.getExceptSelf());
//            vmpBO.setName(vmpDTO.getName());
//            vmpBO.setDefaultType(PreConstants.SETTING_TYPE_RESERVE);
//
//            if (vmpDTO.getMtNameStyle() != null) {
//                MtNameStyleDTO nameStyle = vmpDTO.getMtNameStyle();
//                vmpBO.setAliaLocation(nameStyle.getPosition());
//                vmpBO.setAliaSize(nameStyle.getFontSize());
//                Integer[] rgb = MtNameStyleDTO.toRGB(nameStyle.getFontColor());
//                vmpBO.setAliaRcolor(rgb[0]);
//                vmpBO.setAliaGcolor(rgb[1]);
//                vmpBO.setAliaBcolor(rgb[2]);
//            } else {
//                //默认 中,左下角,白色
//                vmpBO.setAliaLocation(PreConstants.VMP_ALIA_LOCATION);
//                vmpBO.setAliaSize(PreConstants.VMP_ALIA_SIZE);
//                vmpBO.setAliaRcolor(255);
//                vmpBO.setAliaGcolor(255);
//                vmpBO.setAliaBcolor(255);
//            }
//            List<VMeetingVmpMemberBO> memberList =
//                    Optional.ofNullable(vmpDTO.getMembers()).orElseGet(ArrayList::new)
//                            .stream()
//                            .map(m -> {
//                                VMeetingVmpMemberBO vmpm = new VMeetingVmpMemberBO();
//                                vmpm.setAccount(m.getAccount());
//                                vmpm.setAccountType(m.getAccountType());
//                                vmpm.setPositionIndex(m.getChnIdx());
//                                vmpm.setType(m.getMemberType());
//                                vmpm.setParentId(m.getConfE164());
//                                if (m.getPoll() != null) {
//                                    vmpm.setPoll(PollDTO.toVMeetingBO(m.getPoll(), defaultType));
//                                }
//                                return vmpm;
//                            }).collect(Collectors.toList());
//            vmpBO.setMemberList(memberList);
//            if (null != vmpDTO.getPoll()) {
//                vmpBO.setVmpBatchPoll(PollDTO.toVMeetingBO(vmpDTO.getPoll(), defaultType));
//            }
//        } else {
//            vmpBO.setEnable(false);
//        }
//        return vmpBO;
//    }
//
//    public static VmpDTO fromVMeeting(VMeetingVmpBO bo, String e164, Boolean getMccInfo) {
//        if (bo == null) {
//            return null;
//        }
//        VmpDTO dto = new VmpDTO();
//        dto.setName(bo.getName());
//        dto.setBroadcast(bo.getBroadcast());
//        dto.setLayout(bo.getStyle());
//        dto.setExceptSelf(bo.getNMinusOneMode());
//        dto.setShowMtName(bo.getShowMtName());
//        dto.setVoiceHint(bo.getVoiceHint());
//        MtNameStyleDTO mtNameStyle = new MtNameStyleDTO();
//        mtNameStyle.setFontColor(
//                MtNameStyleDTO.fromRGB(
//                        bo.getAliaRcolor(),
//                        bo.getAliaGcolor(),
//                        bo.getAliaBcolor()));
//        mtNameStyle.setFontSize(bo.getAliaSize());
//        mtNameStyle.setPosition(bo.getAliaLocation());
//        dto.setMtNameStyle(mtNameStyle);
//        //自动画面合成
//        int mode = PreConstants.VMP_MODE_AUTO;
//        if (bo.getVmpBatchPoll() != null) {
//            //批量轮询
//            mode = PreConstants.VMP_STYLE_CUSTOM_BATCH_POLL;
//            VMeetingPollBO batchPoll = bo.getVmpBatchPoll();
//            dto.setPoll(PollDTO.fromVMeeting(batchPoll, e164, getMccInfo));
//        } else {
//            List<VmpMemberDTO> VmpMemberDTOs = VmpMemberDTO.fromVMeeting(bo.getMemberList(), e164, getMccInfo);
//            if (getMccInfo) {
//                VmpMemberDTOs.forEach(m -> MccMemberDTO.setMccMTInfo(e164, m));
//            }
//            dto.setMembers(VmpMemberDTOs);
//            //定制画面合成
////            if(CollectionUtils.isNotEmpty(VmpMemberDTOs)){
//            if (bo.getStyle() != 0) {
//                mode = PreConstants.VMP_MODE_CUSTOM;
//            }
//
//        }
//        dto.setMode(mode);
//        return dto;
//    }
//
//    public VMeetingVmpBO toMeetingVmp(Integer preType, boolean enable) {
//        VMeetingVmpBO bo = new VMeetingVmpBO();
//        bo.setEnable(enable);
//        bo.setId(this.getId());
//        bo.setDefaultType(preType);
//        bo.setName(this.getName());
//        bo.setShowMtName(this.getShowMtName());
//        bo.setStyle(PreConstants.VMP_MODE_AUTO.equals(this.getMode()) ? PreConstants.VMP_STYLE_AUTO : this.getLayout());
//        //TODO 默认值在创会策略统一处理
//        bo.setVoiceHint(this.getVoiceHint());
//        bo.setBroadcast(this.getBroadcast());
//        bo.setNMinusOneMode(this.getExceptSelf());
//        if (this.getMtNameStyle() != null) {
//            MtNameStyleDTO nameStyle = this.getMtNameStyle();
//            bo.setAliaLocation(nameStyle.getPosition());
//            bo.setAliaSize(nameStyle.getFontSize());
//            // 默认值策略抽取出来,统一做？
//            Integer[] rgb = MtNameStyleDTO.toRGB(nameStyle.getFontColor());
//            bo.setAliaRcolor(rgb[0]);
//            bo.setAliaGcolor(rgb[1]);
//            bo.setAliaBcolor(rgb[2]);
//        }
//        if (PreConstants.VMP_STYLE_CUSTOM_BATCH_POLL.equals(this.getMode())) {
//            bo.setVmpBatchPoll(this.getPoll().toMeetingPoll(PreConstants.SETTING_TYPE_DEFAULT, true));
//        } else {
//            if (CollectionUtils.isNotEmpty(this.getMembers())) {
//                bo.setMemberList(this.getMembers().stream()
//                        .map(VmpMemberDTO::toVmpMember).collect(Collectors.toList()));
//            }
//        }
//        return bo;
//    }
}

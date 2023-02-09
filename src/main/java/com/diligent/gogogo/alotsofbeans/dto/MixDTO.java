/**
 * @(#)Mix.java 2016年5月4日 Copyright 2016 it.kedacom.com, Inc. All rights
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
@Data
@ApiModel
public class MixDTO {

    @ApiModelProperty(value = "混音预案id，跨级建云会议机房创会需要，不对外", open = false)
    private String id;

    @ApiModelProperty(value = "混音模式",dict = {"1:智能混音","2:定制混音"}, required = true, example = "1")
    private Integer mode;

    @ApiModelProperty(value = "预案名称", open = false,defaultValue = "混音")
    private String name;

    @ApiModelProperty(value = "混音列表成员", notes = "不为智能混音模式必填")
    private List<MixMemberDTO> members;

//    public static MixDTO fromVMeeting(VMeetingMixBO mixBO, String e164, Boolean getMccInfo) {
//        if (null == mixBO) {
//            return null;
//        }
//        MixDTO dto = new MixDTO();
//        dto.setName(mixBO.getName());
//        dto.setMode(mixBO.getMixMode() == 2 ?
//                PreConstants.MIX_MODE_CUSTOM
//                : PreConstants.MIX_MODE_SMART);
//        List<MixMemberDTO> member = MixMemberDTO.fromVMeeting(mixBO.getMemberList(), e164);
//        if (getMccInfo) {
//            member.forEach(m -> MccMemberDTO.setMccMTInfo(e164, m));
//        }
//        dto.setMembers(member);
//
//        return dto;
//    }
//
//
//    public static TemplateMixBO toTemplateBO(MixDTO mix, Integer defaultType) {
//        TemplateMixBO mixBO = new TemplateMixBO();
//        if (null == mix) {
//            mixBO.setEnable(PreConstants.PRE_ENABLE_FALSE);
//            mixBO.setMixMode(PreConstants.MIX_MODE_SMART);
//        } else {
//            mixBO.setEnable(PreConstants.PRE_ENABLE_TRUE);
//            mixBO.setName(mix.getName());
//            mixBO.setId(mix.getId());
//            mixBO.setDefaultType(defaultType);
//            mixBO.setMixMode(PreConstants.MIX_MODE_CUSTOM.equals(mix.getMode()) ? PreConstants.MIX_MODE_CUSTOM : PreConstants.MIX_MODE_SMART);
//            if (PreConstants.MIX_MODE_CUSTOM.equals(mixBO.getMixMode())) {
//                List<TemplateMixMemberBO> memberList =
//                        Optional.ofNullable(mix.getMembers()).orElseGet(ArrayList::new)
//                                .stream()
//                                .map(m -> {
//                                    TemplateMixMemberBO mixm = new TemplateMixMemberBO();
//                                    mixm.setAccount(m.getAccount());
//                                    mixm.setAccountType(m.getAccountType());
//                                    mixm.setName(m.getName());
//                                    mixm.setParentId(m.getConfE164());
//                                    return mixm;
//                                }).collect(Collectors.toList());
//                mixBO.setMemberList(memberList);
//            }
//        }
//
//
//        return mixBO;
//    }
//
//
//    public static VMeetingMixBO toVMeetingBO(MixDTO dto, Integer defaultType) {
//        VMeetingMixBO mix = new VMeetingMixBO();
//        if (null == dto) {
//            mix.setEnable(PreConstants.PRE_ENABLE_FALSE);
//            mix.setMixMode(PreConstants.MIX_MODE_SMART);
//        } else {
//            mix.setId(dto.getId());
//            mix.setEnable(PreConstants.PRE_ENABLE_TRUE);
//            mix.setMixMode(dto.getMode() == null ? PreConstants.MIX_MODE_SMART : dto.getMode());
//            mix.setName(dto.getName());
//            mix.setDefaultType(defaultType);
//            List<MixMemberDTO> dtoMembers = dto.getMembers();
//            if (CollectionUtils.isNotEmpty(dtoMembers)) {
//                CascadeMemberDTO mixMemvo;
//                List<BaseMemberBO> mixMemList = new ArrayList<>(dtoMembers.size());
//                for (MixMemberDTO dtoMember : dtoMembers) {
//                    mixMemvo = dtoMember;
//                    if (mixMemvo == null) {
//                        continue;
//                    }
//                    BaseMemberBO mixMem = new BaseMemberBO();
//                    mixMem.setAccount(mixMemvo.getAccount());
//                    mixMem.setName(mixMemvo.getName());
//                    mixMem.setAccountType(mixMemvo.getAccountType());
//                    mixMem.setParentId(mixMemvo.getConfE164());
//                    mixMemList.add(mixMem);
//                }
//                mix.setMemberList(mixMemList);
//            }
//        }
//        return mix;
//    }
//
//    public VMeetingMixBO toMeetingMix(Integer preType, Boolean enable) {
//        VMeetingMixBO mix = new VMeetingMixBO();
//        mix.setId(this.getId());
//        mix.setDefaultType(preType);
//        mix.setEnable(enable);
//        mix.setName(this.getName());
//        mix.setMixMode(this.getMode() == 2 ? PreConstants.MIX_MODE_CUSTOM : PreConstants.MIX_MODE_SMART);
//        if (PreConstants.MIX_MODE_CUSTOM.equals(mix.getMixMode())) {
//            if (CollectionUtils.isNotEmpty(this.getMembers())) {
//                mix.setMemberList(this.getMembers()
//                        .stream().map(CascadeMemberDTO::toBaseMember)
//                        .collect(Collectors.toList()));
//            }
//        }
//        return mix;
//    }
}

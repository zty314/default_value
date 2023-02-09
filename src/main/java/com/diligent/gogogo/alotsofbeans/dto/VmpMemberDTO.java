/*
 * @(#)VmpMember.java 2016年5月4日 Copyright 2016 it.kedacom.com, Inc. All rights
 * reserved.
 */

package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
@ToString(callSuper = true)
public class VmpMemberDTO extends MccMemberDTO {

    @ApiModelProperty(value = "跟随类型", dict = {"1:会控指定", "2:发言人跟随", "3:管理方跟随", "4:会议轮询跟随", "6:单通道轮询", "7:内容共享跟随"}, required = true, example = "6")
    private Integer memberType;

    @ApiModelProperty(value = "在画面合成中的位置", required = true, example = "0")
    private Integer chnIdx;

    @ApiModelProperty("单通道轮询设置")
    private PollDTO poll;

//    @ApiModelProperty("所属模板E164")
//    private String confE164;


//    public static List<VmpMemberDTO> fromTemplate(List<TemplateVmpMemberBO> memberList, String e164) {
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<TemplateVmpMemberBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//
//        //非moid账号，单独查询
//        List<VmpMemberDTO> vmpMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = null;
//                            // 当 account或accountType为空时，表示member_type为特殊类型，不查账号信息
//                            if (StringUtils.isNotBlank(m.getAccount()) && m.getAccountType() != null) {
//                                u = userAdapter.getUser(m.getAccount(), m.getAccountType(), null);
//                            }
//                            VmpMemberDTO mem = new VmpMemberDTO();
//                            mem.setChnIdx(m.getPositionIndex());
//                            mem.setMemberType(m.getType());
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//                            // 为真实成员时赋name 与 parentId
//                            if (u != null) {
//                                mem.setPortrait(u.getPortrait32());
//                                mem.setName(u.getName());
//                                mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                            }
//                            // 单通道轮询
//                            if (m.getPoll() != null) {
//                                // 与批量轮询同处理
//                                mem.setPoll(PollDTO.fromTemplate(m.getPoll(), e164));
//                            }
//                            return mem;
//                        }
//                ).filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        List<TemplateVmpMemberBO> platformMembers = mapMembers.get(Boolean.TRUE);
//        List<String> moidList = platformMembers.stream().map(TemplateVmpMemberBO::getAccount).distinct().collect(Collectors.toList());
//        // moid，批量查询
////        List<MUserBO> pollAttends = userAdapter.getAllUserByAccount(moidList);
//        List<MUserBO> pollAttends = userAdapter.getAllUserByAccountForCache(moidList);
//        //获取moid 与 成员 对应关系
//        Map<String, MUserBO> mapMoidMember = pollAttends.stream().collect(Collectors.toMap(MUserBO::getMoid, Function.identity()));
//        vmpMember.addAll(platformMembers.stream().map(
//                m -> {
//                    VmpMemberDTO mem = new VmpMemberDTO();
//                    MUserBO mUserBO = mapMoidMember.get(m.getAccount());
//                    //account取moid
//                    mem.setAccount(m.getAccount());
//                    mem.setAccountType(m.getAccountType());
//                    mem.setName(mUserBO == null ? m.getAccount() : mUserBO.getName());
//                    mem.setChnIdx(m.getPositionIndex());
//                    mem.setMemberType(m.getType());
//                    mem.setPortrait(null != mUserBO ? mUserBO.getPortrait32() : "");
//                    mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                    return mem;
//                }
//        ).collect(Collectors.toList()));
//        return vmpMember;
//    }
//
//    public static List<VmpMemberDTO> fromVMeeting(List<VMeetingVmpMemberBO> memberList, String e164, Boolean getMccInfo) {
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<VMeetingVmpMemberBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//
//        //非moid账号，单独查询
//        List<VmpMemberDTO> vmpMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = null;
//                            // 当 account或accountType为空时，表示member_type为特殊类型，不查账号信息
//                            if (StringUtils.isNotBlank(m.getAccount()) && m.getAccountType() != null) {
//                                u = userAdapter.getUser(m.getAccount(), m.getAccountType(), null);
//                            }
//                            VmpMemberDTO mem = new VmpMemberDTO();
//                            mem.setChnIdx(m.getPositionIndex());
//                            mem.setMemberType(m.getType());
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//                            // 为真实成员时赋name 与 parentId
//                            if (u != null) {
//                                mem.setName(u.getName());
//                                mem.setPortrait(u.getPortrait32());
//                                mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                            }
//                            // 单通道轮询
//                            if (Integer.valueOf(PreConstants.MCC_VMP_MEMBER_TYPE_VMPCHLPOLL).equals(m.getType())) {
//                                // 与批量轮询同处理
//                                mem.setPoll(PollDTO.fromVMeeting(m.getPoll(), e164, getMccInfo));
//                            }
//                            return mem;
//                        }
//                ).filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        List<VMeetingVmpMemberBO> platformMembers = mapMembers.get(Boolean.TRUE);
//        List<String> moidList = platformMembers.stream().map(VMeetingVmpMemberBO::getAccount).distinct().collect(Collectors.toList());
//        // moid，批量查询
////        List<MUserBO> pollAttends = userAdapter.getAllUserByAccount(moidList);
//        List<MUserBO> pollAttends = userAdapter.getAllUserByAccountForCache(moidList);
//        //获取moid 与 成员 对应关系
//        Map<String, MUserBO> mapMoidMember = pollAttends.stream().collect(Collectors.toMap(MUserBO::getMoid, Function.identity()));
//        vmpMember.addAll(platformMembers.stream().map(
//                m -> {
//                    VmpMemberDTO mem = new VmpMemberDTO();
//                    MUserBO mUserBO = mapMoidMember.get(m.getAccount());
//                    //account取moid
//                    mem.setAccount(m.getAccount());
//                    mem.setAccountType(m.getAccountType());
//                    mem.setName(mUserBO == null ? m.getAccount() : mUserBO.getName());
//                    mem.setChnIdx(m.getPositionIndex());
//                    mem.setMemberType(m.getType());
//                    mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                    if (null != mUserBO) {
//                        mem.setE164(mUserBO.getE164());
//                        mem.setPortrait(mUserBO.getPortrait32());
//                    }
//                    return mem;
//                }
//        ).collect(Collectors.toList()));
//        return vmpMember;
//    }
//
//    public VMeetingVmpMemberBO toVmpMember() {
//        VMeetingVmpMemberBO bo = new VMeetingVmpMemberBO();
//        bo.setAccount(this.getAccount());
//        bo.setAccountType(this.getAccountType());
//        bo.setPositionIndex(this.getChnIdx());
//        bo.setType(this.getMemberType());
//        bo.setParentId(this.getConfE164());
//        if (this.getPoll() != null) {
//            bo.setPoll(this.getPoll().toMeetingPoll(PreConstants.SETTING_TYPE_DEFAULT, true));
//        }
//        return bo;
//    }
}

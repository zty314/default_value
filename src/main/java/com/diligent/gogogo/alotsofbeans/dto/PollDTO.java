/*
  @(#)Poll.java 2016年5月4日 Copyright 2016 it.kedacom.com, Inc. All rights
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
public class PollDTO {

    @ApiModelProperty(open = false)
    private String id;// 画面合成预案id, 跨级建云会议机房专用

    @ApiModelProperty(value = "轮询模式",dict = {"1:视频轮询","3:音视频轮询"}, required = true, example = "3")
    private Integer mode;

    @ApiModelProperty(value = "预案名称", open = false)
    private String name;

    @ApiModelProperty(value = "轮询次数",notes = "0表示无限次轮询", required = true, example = "10")
    private Integer num;

    @ApiModelProperty(value = "轮询间隔时间(秒)", required = true, example = "5")
    private Integer keepTime;

    @ApiModelProperty(value = "轮询成员", required = true)
    private List<PollMemberDTO> members;

//    public static PollDTO fromTemplate(TemplatePollBO pollBO, String e164) {
//        PollDTO pollDTO = new PollDTO();
//        pollDTO.setName(pollBO.getName());
//        pollDTO.setNum(pollBO.getNum());
//        pollDTO.setKeepTime(pollBO.getPollInterval());
//        List<PollMemberDTO> pollMemberDTOS = PollMemberDTO.fromTemplate(pollBO.getMemberList(), e164);
//        pollDTO.setMembers(pollMemberDTOS);
//        //附属的轮询功能不需要设置mode,单独开启的需要设置mode
//        if (PreConstants.PRE_ENABLE_TRUE.equals(pollBO.getSpeaker())) {
//            pollDTO.setMode(PreConstants.POLL_MODE_SPEAKER);
//        } else {
//            pollDTO.setMode(PreConstants.POLL_MODE_IMAGE);
//        }
//        return pollDTO;
//    }
//
//    public static PollDTO fromVMeeting(VMeetingPollBO pollBO, String e164, Boolean getMccInfo) {
//        if (null == pollBO) {
//            return null;
//        }
//        PollDTO pollDTO = new PollDTO();
//        pollDTO.setName(pollBO.getName());
//        pollDTO.setNum(pollBO.getNum());
//        pollDTO.setKeepTime(pollBO.getPollInterval());
//        List<PollMemberDTO> pollMemberDTOS = PollMemberDTO.fromVMeeting(pollBO.getMemberList(), e164);
//        if (getMccInfo) {
//            pollMemberDTOS.forEach(m -> MccMemberDTO.setMccMTInfo(e164, m));
//        }
//        pollDTO.setMembers(pollMemberDTOS);
//        //附属的轮询功能不需要设置mode,单独开启的需要设置mode
//        if (PreConstants.PRE_ENABLE_TRUE.equals(pollBO.getSpeaker())) {
//            pollDTO.setMode(PreConstants.POLL_MODE_SPEAKER);
//        } else {
//            pollDTO.setMode(PreConstants.POLL_MODE_IMAGE);
//        }
//        return pollDTO;
//    }
//
//    public static TemplatePollBO toTemplateBO(PollDTO poll, Integer type) {
//        if(null == poll || PreConstants.POLL_MODE_NONE.equals(poll.getMode())){
//            return new TemplatePollBO();
//        }
//        TemplatePollBO pollBO = new TemplatePollBO();
//        pollBO.setDefaultType(type);
//        pollBO.setName(poll.getName());
//        pollBO.setEnable(PreConstants.PRE_ENABLE_TRUE);
//        pollBO.setId(poll.getId());
//        pollBO.setPollInterval(poll.getKeepTime());
//        if (PollKeepTimeEnum.FIFTEEN_SECONDS.getTime().equals(poll.getKeepTime())) {
//            pollBO.setIntervalType(PollKeepTimeEnum.FIFTEEN_SECONDS.getValue());
//        } else if (PollKeepTimeEnum.THIRTY_SECONDS.getTime().equals(poll.getKeepTime())) {
//            pollBO.setIntervalType(PollKeepTimeEnum.THIRTY_SECONDS.getValue());
//        } else if (PollKeepTimeEnum.SIXTY_SECONDS.getTime().equals(poll.getKeepTime())) {
//            pollBO.setIntervalType(PollKeepTimeEnum.SIXTY_SECONDS.getValue());
//        } else {
//            pollBO.setIntervalType(PollKeepTimeEnum.DEFAULT.getValue());
//        }
//        pollBO.setNum(poll.getNum());
//        pollBO.setSpeaker(PreConstants.POLL_MODE_SPEAKER.equals(poll.getMode()));
//
//        List<TemplatePollMemberBO> memberList =
//                Optional.ofNullable(poll.getMembers()).orElseGet(ArrayList::new)
//                        .stream()
//                        .map(m -> {
//                            TemplatePollMemberBO mm = new TemplatePollMemberBO();
//                            mm.setAccount(m.getAccount());
//                            mm.setAccountType(m.getAccountType());
//                            mm.setName(m.getName());
//                            mm.setParentId(m.getConfE164());
//                            return mm;
//                        }).collect(Collectors.toList());
//        pollBO.setMemberList(memberList);
//        return pollBO;
//    }
//
//    public static VMeetingPollBO toVMeetingBO(PollDTO poll, Integer defaultType) {
//        VMeetingPollBO pollBO = new VMeetingPollBO();
//        pollBO.setDefaultType(defaultType);
//        pollBO.setEnable(PreConstants.PRE_ENABLE_TRUE);
//        pollBO.setName(poll.getName());
//        pollBO.setId(poll.getId());
//        pollBO.setPollInterval(poll.getKeepTime());
//        if (PollKeepTimeEnum.FIFTEEN_SECONDS.getTime().equals(poll.getKeepTime())) {
//            pollBO.setIntervalType(PollKeepTimeEnum.FIFTEEN_SECONDS.getValue());
//        } else if (PollKeepTimeEnum.THIRTY_SECONDS.getTime().equals(poll.getKeepTime())) {
//            pollBO.setIntervalType(PollKeepTimeEnum.THIRTY_SECONDS.getValue());
//        } else if (PollKeepTimeEnum.SIXTY_SECONDS.getTime().equals(poll.getKeepTime())) {
//            pollBO.setIntervalType(PollKeepTimeEnum.SIXTY_SECONDS.getValue());
//        } else {
//            pollBO.setIntervalType(PollKeepTimeEnum.DEFAULT.getValue());
//        }
//        pollBO.setNum(poll.getNum());
//        pollBO.setSpeaker(PreConstants.POLL_MODE_SPEAKER.equals(poll.getMode()));
//        List<BaseMemberBO> memberList =
//                Optional.ofNullable(poll.getMembers()).orElseGet(ArrayList::new)
//                        .stream()
//                        .map(m -> {
//                            BaseMemberBO mm = new BaseMemberBO();
//                            mm.setAccount(m.getAccount());
//                            mm.setAccountType(m.getAccountType());
//                            mm.setName(m.getName());
//                            mm.setParentId(m.getConfE164());
//                            return mm;
//                        }).collect(Collectors.toList());
//        pollBO.setMemberList(memberList);
//        return pollBO;
//    }
//
//    public VMeetingPollBO toMeetingPoll(Integer preType, boolean enable) {
//        VMeetingPollBO pollBO = new VMeetingPollBO();
//        pollBO.setId(this.getId());
//        pollBO.setDefaultType(preType);
//        pollBO.setEnable(enable);
//        pollBO.setName(this.getName());
//        pollBO.setPollInterval(this.getKeepTime());
//        pollBO.setIntervalType(PollKeepTimeEnum.getByTime(this.getKeepTime()).getValue());
//        pollBO.setNum(this.getNum());
//        pollBO.setSpeaker(PreConstants.POLL_MODE_SPEAKER.equals(this.getMode()));
//        if (CollectionUtils.isNotEmpty(this.getMembers())) {
//            pollBO.setMemberList(this.getMembers()
//                    .stream().map(CascadeMemberDTO::toBaseMember).collect(Collectors.toList()));
//        }
//        return pollBO;
//    }
}

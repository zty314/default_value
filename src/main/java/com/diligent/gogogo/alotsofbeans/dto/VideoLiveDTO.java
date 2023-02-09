/**
 * @(#)Record.java 2016年4月27日 Copyright 2016 it.kedacom.com, Inc. All rights
 * reserved.
 */

package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 录像与直播
 *
 * @author kedacom
 */

@Data
@ApiModel
public class VideoLiveDTO {

    @ApiModelProperty(value = "录播服务器唯一标识", example = "e2b3f132-1307-11ed-8c83-000c293c33e2")
    private String vrsId;

    @ApiModelProperty(value = "发布模式", dataType = "java.lang.Integer", dict = {"0:不发布", "1:发布到视频点播"}, required = true, example = "0")
    private Boolean publishMode;

    @ApiModelProperty(value = "是否免登录观看直播", dataType = "java.lang.Integer", required = true, dict = {"0-不支持", "1-支持"}, example = "0")
    private Boolean anonymous;

    @ApiModelProperty(value = "录像模式", dict = {"1:录像", "2:直播", "3:录像+直播"}, required = true, example = "2")
    private Integer recorderMode;

    @ApiModelProperty(value = "是否内容共享录像", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", required = true, example = "0")
    private Boolean dualStream;

    @ApiModelProperty(value = "直播密码", notes = "6位字母与数字的组合")
    private String livePassword;

    @ApiModelProperty(value = "短信通知", dataType = "java.lang.Integer", open = false)
    private Boolean sms;

    @ApiModelProperty(value = "微信通知", dataType = "java.lang.Integer", open = false)
    private Boolean wechat;

    @ApiModelProperty(value = "邮件通知", dataType = "java.lang.Integer", open = false)
    private Boolean email;

    @ApiModelProperty(value = "直播人员通知列表", open = false)
    private List<PortraitMemberDTO> liveMembers;

//    public VMeetingVideoLiveBO toMeetingVideoLive() {
//        VMeetingVideoLiveBO bo = new VMeetingVideoLiveBO();
//        bo.setVrsId(this.getVrsId());
//        bo.setDoubleFlow(this.getDualStream());
//        bo.setPublish(this.getPublishMode());
//        bo.setLivePassword(this.getLivePassword());
//        bo.setNoLogin(this.getAnonymous());
//        if (VrsConstants.VIDEO_LIVE_ENABLE_INT.equals(this.getRecorderMode())) {
//            bo.setEnableLive(true);
//            bo.setEnableVideo(true);
//        } else if (VrsConstants.LIVE_ENABLE_INT.equals(this.getRecorderMode())) {
//            bo.setEnableLive(true);
//            bo.setEnableVideo(false);
//        } else if (VrsConstants.VIDEO_ENABLE_INT.equals(this.getRecorderMode())) {
//            bo.setEnableVideo(true);
//            bo.setEnableLive(false);
//        } else {
//            bo.setEnableLive(false);
//            bo.setEnableVideo(false);
//        }
//        //todo 剩下的预约会议用，创会不用，先不实现
//        return bo;
//    }
//
//    public static TemplateVideoLiveBO toTemplateBO(VideoLiveDTO dto) {
//        TemplateVideoLiveBO vl = new TemplateVideoLiveBO();
//        if (null != dto && null != dto.getRecorderMode()) {
//            if (VrsConstants.VIDEO_ENABLE_INT.equals(dto.getRecorderMode())) {
//                // 录像
//                vl.setEnableVideo(true);
//                vl.setEnableLive(false);
//            } else if (VrsConstants.LIVE_ENABLE_INT.equals(dto.getRecorderMode())) {
//                // 直播
//                vl.setEnableVideo(false);
//                vl.setEnableLive(true);
//            } else if (VrsConstants.VIDEO_LIVE_ENABLE_INT.equals(dto.getRecorderMode())) {
//                vl.setEnableVideo(true);
//                vl.setEnableLive(true);
//            } else {
//                vl.setEnableVideo(false);
//                vl.setEnableLive(false);
//            }
//            vl.setDoubleFlow(dto.getDualStream());
//            vl.setNoLogin(dto.getAnonymous());
//            vl.setPublish(dto.getPublishMode());
//            vl.setNoticeType(NotifyTypeUtils.EMAIL);
//            vl.setVrsId(dto.getVrsId());
//            vl.setLivePassword(dto.getLivePassword());
//            List<TemplateVideoLiveMemberBO> liveMemberBOS = Optional.ofNullable(dto.getLiveMembers()).orElseGet(ArrayList::new)
//                    .stream()
//                    .map(m -> {
//                        TemplateVideoLiveMemberBO mm = new TemplateVideoLiveMemberBO();
//                        mm.setAccount(m.getAccount());
//                        mm.setAccountType(m.getAccountType());
//                        mm.setName(m.getName());
//                        return mm;
//                    }).collect(Collectors.toList());
//            vl.setLiveMembers(liveMemberBOS);
//        } else {
//            vl.setNoticeType(NotifyTypeUtils.EMAIL);
//        }
//        return vl;
//    }

}

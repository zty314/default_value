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
public class TvwallStyleDTO {

    @ApiModelProperty("电视墙风格moid")
    private String styleId;

    @ApiModelProperty(value = "是否显示终端名称", dataType = "java.lang.Integer", example = "1")
    private Boolean showMtName;

    @ApiModelProperty(value = "电视墙模式", dict = {"1:定制画面", "2:批量轮询"}, example = "1")
    private Integer mode;

    @ApiModelProperty("电视墙成员")
    private List<TvwallMemberDTO> members;

    @ApiModelProperty("批量轮询")
    private PollDTO batchPoll;

//    public static List<TvwallStyleDTO> fromVMeeting(List<VMeetingTVWallStyleBO> styleBOS, String e164, Boolean getMccInfo) {
//        List<TvwallStyleDTO> styleDTOS = new ArrayList<>();
//        if (CollectionUtils.isEmpty(styleBOS)) {
//            return new ArrayList<>();
//        }
//        styleBOS.forEach(styleBO -> {
//            TvwallStyleDTO styleDTO = new TvwallStyleDTO();
//            styleDTO.setStyleId(styleBO.getStyle());
//            styleDTO.setShowMtName(styleBO.getShowMtName());
//            //电视墙模式,1:定制画面;2:批量轮询
//            if (styleBO.getTvWallBatchPoll() != null) {
//                //批量轮询
//                styleDTO.setMode(2);
//                styleDTO.setBatchPoll(PollDTO.fromVMeeting(styleBO.getTvWallBatchPoll(), e164, getMccInfo));
//            } else {
//                // 定制画面
//                styleDTO.setMode(1);
//                List<TvwallMemberDTO> tvwallMemberDTOs = TvwallMemberDTO.fromVMeeting(styleBO.getMemberList(), e164, getMccInfo);
//                if (getMccInfo) {
//                    // 批量获取hdu信息
//                    Set<String> hduids = new HashSet<String>();
//                    for (TvwallMemberDTO m : tvwallMemberDTOs) {
//                        if (StringUtils.isNotBlank(m.getHduId())) {
//                            hduids.add(m.getHduId().split("_")[0]);
//                        }
//                    }
//                    TVWallService tvWallService = ApplicationContextUtils.getBean(TVWallService.class);
//                    List<Veneer> vl = tvWallService.getHudsByIds(new ArrayList<String>(hduids), WebContext.getSessionUser().getUserDomainMoid());
//                    Map<String, Veneer> veneerMap = new HashMap<String, Veneer>();
//                    for (Veneer v : vl) {
//                        veneerMap.put(v.getHduid(), v);
//                    }
//                    tvwallMemberDTOs.stream().map(
//                            m -> {
//                                MccMemberDTO.setMccMTInfo(e164, m);
//                                if (StringUtils.isNotBlank(m.getHduId())) {
//                                    Veneer v = veneerMap.get(m.getHduId().split("_")[0]);
//                                    if (null != v) {
//                                        m.setIsOnline(VeneerConstants.ON_LINE.equals(v.getIsonline()) ? 1 : 0);
//                                        for (HduChannel chn : v.getChninfo()) {
//                                            if (chn.getChnnindx().equals(m.getHduId().split("_")[1])) {
//                                                if (chn.getIsused() != null) {
//                                                    m.setIsUsed(Integer.valueOf(chn.getIsused()));
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                                return m;
//                            }).collect(Collectors.toList());
//                }
//                styleDTO.setMembers(tvwallMemberDTOs);
//            }
//            styleDTOS.add(styleDTO);
//        });
//        return styleDTOS;
//    }
//
//    public static TvwallStyleDTO fromTemplate(TemplateTvwallStyleBO style, String e164) {
//        TvwallStyleDTO tv = new TvwallStyleDTO();
//        tv.setStyleId(style.getStyle());
//        tv.setShowMtName(style.getShowMtName());
//        //电视墙模式,1:定制画面;2:批量轮询
//        if (style.getTvWallBatchPoll() != null) {
//            //批量轮询
//            tv.setMode(2);
//            tv.setBatchPoll(PollDTO.fromTemplate(style.getTvWallBatchPoll(), e164));
//        } else {
//            // 定制画面
//            tv.setMode(1);
//            tv.setMembers(TvwallMemberDTO.fromTemplate(style.getMemberList(), e164));
//        }
//        return tv;
//    }
//
//    public static TemplateTvwallStyleBO toTemplateBO(TvwallStyleDTO tvwall, Integer type) {
//        TemplateTvwallStyleBO tvs = new TemplateTvwallStyleBO();
//        tvs.setStyle(tvwall.getStyleId());
//        tvs.setShowMtName(tvwall.getShowMtName());
//        if (PreConstants.TVWALL_STYLE_BATCH_POLL.equals(tvwall.getMode())) {
//            tvs.setTvWallBatchPoll(PollDTO.toTemplateBO(tvwall.getBatchPoll(), type));
//        } else {
//            List<TemplateTvwallMemberBO> memberList =
//                    Optional.ofNullable(tvwall.getMembers()).orElseGet(ArrayList::new)
//                            .stream()
//                            .map(m -> {
//                                TemplateTvwallMemberBO tm = new TemplateTvwallMemberBO();
//                                tm.setAccount(m.getAccount());
//                                tm.setAccountType(m.getAccountType());
////                                tm.setName(m.getName());
//                                tm.setType(m.getMemberType());
//                                if (StringUtils.isNotBlank(m.getHduId()) && m.getHduId().split("_").length == 2) {
//                                    String[] hduIds = m.getHduId().split("_");
//                                    tm.setHduId(hduIds[0]);
//                                    tm.setChannelIndex(Integer.valueOf(hduIds[1]));
//                                }
//                                tm.setParentId(m.getConfE164());
//                                if (m.getPoll() != null) {
//                                    tm.setPoll(PollDTO.toTemplateBO(m.getPoll(), type));
//                                }
//                                if (m.getVmp() != null) {
//                                    VmpDTO vmp = m.getVmp();
//                                    //电视墙不支持设置以下参数，赋默认值
//                                    vmp.setBroadcast(false);
//                                    vmp.setExceptSelf(0);
//                                    vmp.setVoiceHint(false);
//                                    vmp.setMtNameStyle(null);
//                                    tm.setVmp(VmpDTO.toTemplateBO(vmp, type));
//                                }
//                                if (CollectionUtils.isNotEmpty(m.getQuadMembers())) {
//                                    tm.setQuadMemberList(TvwallQuadMemberDTO.toTemplateQuadMembers(m.getQuadMembers()));
//                                    tm.setHduStyle(1);
//                                } else {
//                                    tm.setHduStyle(0);
//                                }
//                                return tm;
//                            }).collect(Collectors.toList());
//            tvs.setMemberList(memberList);
//        }
//        return tvs;
//    }
//
//    public static VMeetingTVWallStyleBO toVMeeting(TvwallStyleDTO tvWallStyleDTO, Integer defaultType) {
//        VMeetingTVWallStyleBO styleBO = new VMeetingTVWallStyleBO();
//        styleBO.setStyle(tvWallStyleDTO.getStyleId());
//        styleBO.setShowMtName(tvWallStyleDTO.getShowMtName());
//        List<TvwallMemberDTO> tvWallMemberDTOS = tvWallStyleDTO.getMembers();
//        if (tvWallMemberDTOS != null && !tvWallMemberDTOS.isEmpty()) {
//            List<VMeetingTVWallMemberBO> tvWallMemberBOS = new ArrayList<>(
//                    tvWallMemberDTOS.size());
//            TvwallMemberDTO memberDTO;
//            for (int i = 0; i < tvWallMemberDTOS.size(); i++) {
//                memberDTO = tvWallMemberDTOS.get(i);
//                if (memberDTO == null) {
//                    continue;
//                }
//                VMeetingTVWallMemberBO memberBO = new VMeetingTVWallMemberBO();
//                memberBO.setAccount(memberDTO.getAccount() == null ? "" : memberDTO.getAccount());
//                memberBO.setAccountType(memberDTO.getAccountType() == null ? 0 : memberDTO.getAccountType());
//                if (StringUtils.isNotBlank(memberDTO.getHduId()) && memberDTO.getHduId().split("_").length == 2) {
//                    String[] hduIds = memberDTO.getHduId().split("_");
//                    memberBO.setHduId(hduIds[0]);
//                    memberBO.setChannelIndex(Integer.valueOf(hduIds[1]));
//                }
//                PollDTO memberDTOPoll = memberDTO.getPoll();
//                // 模式设置 主席跟随等
//                memberBO.setType(memberDTO.getMemberType());
//                // 单通道轮询
//                if (memberDTOPoll != null) {
//                    VMeetingPollBO mempoll = PollDTO.toVMeetingBO(memberDTOPoll, null);
//                    memberBO.setPoll(mempoll);
//                }
//                VmpDTO memberDTOVmp = memberDTO.getVmp();
//                if (memberDTOVmp != null) {
//                    VMeetingVmpBO memvmp = VmpDTO.toVMeetingBO(memberDTOVmp, defaultType);
//                    memberBO.setVmp(memvmp);
//                }
//                memberBO.setHduStyle(memberDTO.getHduStyle() == null ? 0 : memberDTO.getHduStyle());
//                List<TvwallQuadMemberDTO> tvWallQuadMemberDTOS = memberDTO.getQuadMembers();
//                if (tvWallQuadMemberDTOS != null && !tvWallQuadMemberDTOS.isEmpty()) {
//                    List<VMeetingTVWallMemberQuadBO> vMeetingTVWallMemberQuadBOS = new ArrayList<>();
//                    for (TvwallQuadMemberDTO tvWallQuadMemberDTO : tvWallQuadMemberDTOS) {
//                        VMeetingTVWallMemberQuadBO meetingQuadMember = new VMeetingTVWallMemberQuadBO();
//                        meetingQuadMember.setAccount(tvWallQuadMemberDTO.getAccount());
//                        meetingQuadMember.setAccountType(tvWallQuadMemberDTO.getAccountType());
//                        meetingQuadMember.setSubChnIndex(tvWallQuadMemberDTO.getSubChnIndex());
//                        meetingQuadMember.setParentId(tvWallQuadMemberDTO.getConfE164());
//                        vMeetingTVWallMemberQuadBOS.add(meetingQuadMember);
//                    }
//                    memberBO.setQuadMemberList(vMeetingTVWallMemberQuadBOS);
//                }
//                memberBO.setParentId(memberDTO.getConfE164());
//                tvWallMemberBOS.add(memberBO);
//            }
//            styleBO.setMemberList(tvWallMemberBOS);
//        }
//        // 批量轮询
//        if (tvWallStyleDTO.getBatchPoll() != null) {
//            VMeetingPollBO batchPoll = PollDTO.toVMeetingBO(tvWallStyleDTO.getBatchPoll(), null);
//            styleBO.setTvWallBatchPoll(batchPoll);
//        }
//        return styleBO;
//    }
//
//    public VMeetingTVWallStyleBO toMeetingTvwallStyle() {
//        VMeetingTVWallStyleBO bo = new VMeetingTVWallStyleBO();
//        bo.setStyle(this.getStyleId());
//        bo.setShowMtName(this.getShowMtName());
//        if (this.getBatchPoll() != null) {
//            bo.setTvWallBatchPoll(this.getBatchPoll().toMeetingPoll(PreConstants.SETTING_TYPE_DEFAULT, true));
//        } else {
//            if (CollectionUtils.isNotEmpty(this.getMembers())) {
//                bo.setMemberList(this.getMembers().stream()
//                        .map(TvwallMemberDTO::toTvwallMember).collect(Collectors.toList()));
//            }
//        }
//        return bo;
//    }
}

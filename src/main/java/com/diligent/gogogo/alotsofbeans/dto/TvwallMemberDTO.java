package com.diligent.gogogo.alotsofbeans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author zhaoyubin
 * @date 2022/2/11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@ApiModel
public class TvwallMemberDTO extends MccMemberDTO {

    @ApiModelProperty(value = "跟随类型", dict = {"1:会控指定", "2:发言人跟随", "3:管理方跟随", "4:会议轮询跟随", "5:单通道轮询","6:选看画面合成", "8:自主多画面", "9:四分屏", "10:内容共享跟随"}, example = "5")
    private Integer memberType;

    @ApiModelProperty(value = "设备id号_通道索引号", example = "2_1")
    private String hduId;

    @ApiModelProperty(value = "通道索引0或1",open = false)
    private Integer channelIndex;

    @ApiModelProperty("单通道轮询")
    private PollDTO poll;

    @ApiModelProperty("自主多画面")
    private VmpDTO vmp;

    @ApiModelProperty(value = "hdu风格", open = false, example = "0")
    private Integer hduStyle;

    @ApiModelProperty("四分屏成员")
    @JsonProperty(value = "spilt")
    private List<TvwallQuadMemberDTO> quadMembers;

    @ApiModelProperty(value = "通道是否在线", dict = {"0:否", "1:是"}, notes = "仅用于会控返回", open = false)
    private Integer isOnline;

    @ApiModelProperty(value = "通道是否使用", dict = {"0:否", "1:是"}, notes = "仅用于会控返回", open = false)
    private Integer isUsed;

//    @ApiModelProperty("所属模板E164")
//    private String confE164;

//    public static List<TvwallMemberDTO> fromVMeeting(List<VMeetingTVWallMemberBO> memberList, String e164, Boolean getMccInfo) {
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<VMeetingTVWallMemberBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//        //非moid账号，单独查询
//        List<TvwallMemberDTO> tvWallMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = null;
//                            // 当 account或accountType为空时，表示member_type为特殊类型，不查账号信息
//                            if (StringUtils.isNotBlank(m.getAccount())
//                                    && m.getAccountType() != null) {
//                                u = userAdapter.getUser(m.getAccount(), m.getAccountType(),
//                                        null);
//                            }
//                            TvwallMemberDTO mem = new TvwallMemberDTO();
//                            mem.setHduId(m.getHduId() + "_" + m.getChannelIndex());
//                            mem.setMemberType(m.getType());
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//                            // 为真实成员时才赋name与parentId
//                            if (u != null) {
//                                mem.setPortrait(u.getPortrait32());
//                                mem.setName(u.getName());
//                                mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                            }
//                            // 单通道轮询
//                            if (m.getPoll() != null) {
//                                // 与批量轮询同处理
//                                mem.setPoll(PollDTO.fromVMeeting(m.getPoll(), e164, getMccInfo));
//                            }
//                            // 自主多画面
//                            if (m.getVmp() != null) {
//                                VmpDTO vmp = VmpDTO.fromVMeeting(m.getVmp(), e164, getMccInfo);
//                                // 电视墙自主多画面不支持以下设置，不返回
//                                vmp.setMtNameStyle(null);
//                                vmp.setBroadcast(null);
//                                vmp.setVoiceHint(null);
//                                vmp.setPoll(null);
//                                vmp.setExceptSelf(null);
//                                mem.setVmp(vmp);
//                            }
//                            // 四分屏
//                            if (CollectionUtils.isNotEmpty(m.getQuadMemberList())) {
//                                mem.setQuadMembers(TvwallQuadMemberDTO.fromVMeeting(m.getQuadMemberList(), e164));
//                            }
//                            return mem;
//                        }
//                )
//                .collect(Collectors.toList());
//
//        List<VMeetingTVWallMemberBO> platformMembers = mapMembers.get(Boolean.TRUE);
//        List<String> moidList = platformMembers.stream().map(VMeetingTVWallMemberBO::getAccount).distinct().collect(Collectors.toList());
//        // moid，批量查询
//        List<MUserBO> pollAttends = userAdapter.getAllUserByAccount(moidList);
//        //获取moid 与 成员 对应关系
//        Map<String, MUserBO> mapMoidMember = pollAttends.stream().collect(Collectors.toMap(MUserBO::getMoid, Function.identity()));
//        tvWallMember.addAll(platformMembers.stream().map(
//                m -> {
//                    TvwallMemberDTO mem = new TvwallMemberDTO();
//                    MUserBO userVO = mapMoidMember.get(m.getAccount());
//                    //account取moid
//                    mem.setAccount(m.getAccount());
//                    mem.setAccountType(m.getAccountType());
//                    mem.setName(userVO == null ? m.getAccount() : userVO.getName());
//                    mem.setHduId(m.getHduId() + "_" + m.getChannelIndex());
//                    mem.setMemberType(m.getType());
//                    mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                    if (null != userVO) {
//                        mem.setE164(userVO.getE164());
//                        mem.setPortrait(userVO.getPortrait32());
//                    }
//                    return mem;
//                }
//        ).collect(Collectors.toList()));
//        return tvWallMember;
//    }
//
//
//    public static List<TvwallMemberDTO> fromTemplate(List<TemplateTvwallMemberBO> memberList, String e164) {
//
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<TemplateTvwallMemberBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//        //非moid账号，单独查询
//        List<TvwallMemberDTO> tvWallMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = null;
//                            // 当 account或accountType为空时，表示member_type为特殊类型，不查账号信息
//                            if (StringUtils.isNotBlank(m.getAccount())
//                                    && m.getAccountType() != null) {
//                                u = userAdapter.getUser(m.getAccount(), m.getAccountType(), null);
//                            }
//                            TvwallMemberDTO mem = new TvwallMemberDTO();
//                            mem.setHduId(m.getHduId() + "_" + m.getChannelIndex());
//                            mem.setMemberType(m.getType());
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//
//                            // 为真实成员时才赋name与parentId
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
//                            // 自主多画面
//                            if (m.getVmp() != null) {
//                                VmpDTO vmp = VmpDTO.fromTemplate(m.getVmp(), e164);
//                                // 电视墙自主多画面不支持以下设置，不返回
//                                vmp.setMtNameStyle(null);
//                                vmp.setBroadcast(null);
//                                vmp.setVoiceHint(null);
//                                vmp.setPoll(null);
//                                vmp.setExceptSelf(null);
//                                mem.setVmp(vmp);
//                            }
//                            // 四分屏
//                            if (CollectionUtils.isNotEmpty(m.getQuadMemberList())) {
//                                mem.setQuadMembers(TvwallQuadMemberDTO.fromTemplate(m.getQuadMemberList(), e164));
//                            }
//                            return mem;
//                        }
//                )
//                .collect(Collectors.toList());
//
//        List<TemplateTvwallMemberBO> platformMembers = mapMembers.get(Boolean.TRUE);
//        List<String> moidList = platformMembers.stream().map(TemplateTvwallMemberBO::getAccount).distinct().collect(Collectors.toList());
//        // moid，批量查询
//        List<MUserBO> pollAttends = userAdapter.getAllUserByAccount(moidList);
//        //获取moid 与 成员 对应关系
//        Map<String, MUserBO> mapMoidMember = pollAttends.stream().collect(Collectors.toMap(MUserBO::getMoid, Function.identity()));
//        tvWallMember.addAll(platformMembers.stream().map(
//                m -> {
//                    TvwallMemberDTO mem = new TvwallMemberDTO();
//                    MUserBO userBO = mapMoidMember.get(m.getAccount());
//                    //account取moid
//                    mem.setAccount(m.getAccount());
//                    mem.setAccountType(m.getAccountType());
//                    mem.setName(userBO == null ? m.getAccount() : userBO.getName());
//                    mem.setHduId(m.getHduId() + "_" + m.getChannelIndex());
//                    mem.setMemberType(m.getType());
//                    mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                    mem.setPortrait(null != userBO ? userBO.getPortrait32() : "");
//                    return mem;
//                }
//        ).collect(Collectors.toList()));
//        return tvWallMember;
//    }
//
//    public VMeetingTVWallMemberBO toTvwallMember() {
//        VMeetingTVWallMemberBO bo = new VMeetingTVWallMemberBO();
//        bo.setAccount(this.getAccount());
//        bo.setAccountType(this.getAccountType());
//        bo.setType(this.getMemberType());
//        bo.setHduId(this.getHduId());
//        bo.setChannelIndex(this.getChannelIndex());
//        // todo 下面的逻辑是沿用终端创会，hdustyle 由终端传还是自定？
//        bo.setHduStyle(this.getMemberType().equals(9) ? 1 : 0);
//        bo.setParentId(this.getConfE164());
//        if (this.getPoll() != null) {
//            bo.setPoll(this.getPoll().toMeetingPoll(PreConstants.SETTING_TYPE_DEFAULT, true));
//        } else if (this.getVmp() != null) {
//            bo.setVmp(this.getVmp().toMeetingVmp(PreConstants.SETTING_TYPE_DEFAULT, true));
//        } else if (CollectionUtils.isNotEmpty(this.getQuadMembers())) {
//            bo.setQuadMemberList(this.getQuadMembers()
//                    .stream().map(TvwallQuadMemberDTO::toMeetingQuadMember).collect(Collectors.toList()));
//        }
//        return bo;
//    }
}

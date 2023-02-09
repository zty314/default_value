package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author zhaoyubin
 * @date 2022/2/11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@ApiModel
public class TvwallQuadMemberDTO extends MccMemberDTO {

    @ApiModelProperty(value = "四分屏索引", example = "2")
    private Integer subChnIndex;


//    public static List<TvwallQuadMemberDTO> fromVMeeting(List<VMeetingTVWallMemberQuadBO> memberList, String e164) {
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<VMeetingTVWallMemberQuadBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//        //非moid账号，单独查询
//        List<TvwallQuadMemberDTO> quadMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = userAdapter.getUser(m.getAccount(), m.getAccountType(),
//                                    null);
//                            if (u == null) {
//                                return null;
//                            }
//                            TvwallQuadMemberDTO mem = new TvwallQuadMemberDTO();
//                            mem.setSubChnIndex(m.getSubChnIndex());
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//                            mem.setName(u.getName());
//                            mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                            return mem;
//                        }
//                ).filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        List<VMeetingTVWallMemberQuadBO> platformMembers = mapMembers.get(Boolean.TRUE);
//        List<String> moidList = platformMembers.stream().map(VMeetingTVWallMemberQuadBO::getAccount).distinct().collect(Collectors.toList());
//        // moid，批量查询
//        List<MUserBO> pollAttends = userAdapter.getAllUserByAccount(moidList);
//        //获取moid 与 成员 对应关系
//        Map<String, MUserBO> mapMoidMember = pollAttends.stream().collect(Collectors.toMap(MUserBO::getMoid, Function.identity()));
//        quadMember.addAll(platformMembers.stream().map(
//                m -> {
//                    TvwallQuadMemberDTO mem = new TvwallQuadMemberDTO();
//                    MUserBO userVO = mapMoidMember.get(m.getAccount());
//                    mem.setSubChnIndex(m.getSubChnIndex());
//                    mem.setAccount(m.getAccount());
//                    mem.setAccountType(m.getAccountType());
//                    mem.setName(userVO == null ? m.getAccount() : userVO.getName());
//                    mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                    mem.setE164(userVO.getE164());
//                    mem.setPortrait(userVO.getPortrait32());
//                    return mem;
//                }
//        ).collect(Collectors.toList()));
//        return quadMember;
//    }
//
//    public static List<TvwallQuadMemberDTO> fromTemplate(List<TemplateTvwallMemberQuadBO> memberList, String e164) {
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<TemplateTvwallMemberQuadBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//        //非moid账号，单独查询
//        List<TvwallQuadMemberDTO> quadMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = userAdapter.getUser(m.getAccount(), m.getAccountType(), null);
//                            if (u == null) {
//                                return null;
//                            }
//                            TvwallQuadMemberDTO mem = new TvwallQuadMemberDTO();
//                            mem.setSubChnIndex(m.getSubChnIndex());
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//                            mem.setName(u.getName());
//                            mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                            return mem;
//                        }
//                ).filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        List<TemplateTvwallMemberQuadBO> platformMembers = mapMembers.get(Boolean.TRUE);
//        List<String> moidList = platformMembers.stream().map(TemplateTvwallMemberQuadBO::getAccount).distinct().collect(Collectors.toList());
//        // moid，批量查询
//        List<MUserBO> pollAttends = userAdapter.getAllUserByAccount(moidList);
//        //获取moid 与 成员 对应关系
//        Map<String, MUserBO> mapMoidMember = pollAttends.stream().collect(Collectors.toMap(MUserBO::getMoid, Function.identity()));
//        quadMember.addAll(platformMembers.stream().map(
//                m -> {
//                    TvwallQuadMemberDTO mem = new TvwallQuadMemberDTO();
//                    MUserBO userVO = mapMoidMember.get(m.getAccount());
//                    mem.setSubChnIndex(m.getSubChnIndex());
//                    mem.setAccount(m.getAccount());
//                    mem.setAccountType(m.getAccountType());
//                    mem.setName(userVO == null ? m.getAccount() : userVO.getName());
//                    mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                    return mem;
//                }
//        ).collect(Collectors.toList()));
//        return quadMember;
//    }
//
//
//    public static List<TemplateTvwallMemberQuadBO> toTemplateQuadMembers(List<TvwallQuadMemberDTO> quadMemberDTOS) {
//        return Optional.ofNullable(quadMemberDTOS).orElseGet(ArrayList::new)
//                .stream()
//                .map(m -> {
//                    TemplateTvwallMemberQuadBO tqm = new TemplateTvwallMemberQuadBO();
//                    tqm.setAccount(m.getAccount());
//                    tqm.setAccountType(m.getAccountType());
//                    tqm.setName(m.getName());
//                    tqm.setSubChnIndex(m.getSubChnIndex());
//                    tqm.setParentId(m.getConfE164());
//                    return tqm;
//                }).collect(Collectors.toList());
//    }
//
//    public VMeetingTVWallMemberQuadBO toMeetingQuadMember() {
//        VMeetingTVWallMemberQuadBO bo = new VMeetingTVWallMemberQuadBO();
//        bo.setAccount(this.getAccount());
//        bo.setAccountType(this.getAccountType());
//        bo.setParentId(this.getConfE164());
//        bo.setSubChnIndex(this.getSubChnIndex());
//        return bo;
//    }
}

package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author zhaoyubin
 * @date 2022/2/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@ApiModel
@NoArgsConstructor
public class MixMemberDTO extends MccMemberDTO {

    public MixMemberDTO(String account, Integer accountType, String name) {
        super(account, accountType, name);
    }

//    public static List<MixMemberDTO> fromVMeeting(List<BaseMemberBO> memberList, String e164) {
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<BaseMemberBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//        //非moid账号，单独查询
//        List<MixMemberDTO> pollMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = userAdapter.getUser(m.getAccount(), m.getAccountType(),
//                                    null);
//                            if (u == null) {
//                                return null;
//                            }
//                            MixMemberDTO mem = new MixMemberDTO();
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//                            mem.setName(u.getName());
//                            mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                            return mem;
//                        }
//                ).filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        List<BaseMemberBO> platformMembers = mapMembers.get(Boolean.TRUE);
//        List<String> moidList = platformMembers.stream().map(BaseMemberBO::getAccount).distinct().collect(Collectors.toList());
//        // moid，批量查询
////        List<MUserBO> pollAttends = userAdapter.getAllUserByAccount(moidList);
//        List<MUserBO> pollAttends = userAdapter.getAllUserByAccountForCache(moidList);
//        //获取moid 与 成员 对应关系
//        Map<String, MUserBO> mapMoidMember = pollAttends.stream().collect(Collectors.toMap(MUserBO::getMoid, Function.identity()));
//        pollMember.addAll(platformMembers.stream().map(
//                m -> {
//                    MixMemberDTO mem = new MixMemberDTO();
//                    MUserBO userVO = mapMoidMember.get(m.getAccount());
//                    //account取moid
//                    mem.setAccount(m.getAccount());
//                    mem.setAccountType(m.getAccountType());
//                    mem.setName(userVO == null ? m.getAccount() : userVO.getName());
//                    mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                    mem.setE164(userVO == null ? "" : userVO.getE164());
//                    mem.setPortrait(userVO == null ? "" : userVO.getPortrait32());
//                    return mem;
//                }
//        ).collect(Collectors.toList()));
//        return pollMember;
//    }
//
//    public static List<MixMemberDTO> fromTemplate(List<TemplateMixMemberBO> memberList, String e164) {
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<TemplateMixMemberBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//        //非moid账号，单独查询
//        List<MixMemberDTO> mixMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = userAdapter.getUser(m.getAccount(), m.getAccountType(), null);
//                            if (u == null) {
//                                return null;
//                            }
//                            MixMemberDTO mem = new MixMemberDTO();
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//                            mem.setName(u.getName());
//                            mem.setConfE164(StringUtils.isEmpty(m.getParentId()) ? e164 : m.getParentId());
//                            mem.setPortrait(u.getPortrait32());
//                            return mem;
//                        }
//                ).filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        List<TemplateMixMemberBO> platformMembers = mapMembers.get(Boolean.TRUE);
//        List<String> moidList = platformMembers.stream().map(TemplateMixMemberBO::getAccount).distinct().collect(Collectors.toList());
//        // moid，批量查询
//        List<MUserBO> pollAttends = userAdapter.getAllUserByAccount(moidList);
//        //获取moid 与 成员 对应关系
//        Map<String, MUserBO> mapMoidMember = pollAttends.stream().collect(Collectors.toMap(MUserBO::getMoid, Function.identity()));
//        mixMember.addAll(platformMembers.stream().map(
//                m -> {
//                    MixMemberDTO mem = new MixMemberDTO();
//                    MUserBO userVO = mapMoidMember.get(m.getAccount());
//                    //account取moid
//                    mem.setAccount(m.getAccount());
//                    mem.setAccountType(m.getAccountType());
//                    mem.setName(userVO == null ? m.getAccount() : userVO.getName());
//                    mem.setConfE164(StringUtils.isEmpty(m.getParentId()) ? e164 : m.getParentId());
//                    mem.setPortrait(userVO == null ? "" : userVO.getPortrait32());
//                    return mem;
//                }
//        ).collect(Collectors.toList()));
//        return mixMember;
//    }
}

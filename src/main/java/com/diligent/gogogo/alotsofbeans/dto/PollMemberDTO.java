package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhaoyubin
 * @date 2022/2/11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@ApiModel
@NoArgsConstructor
public class PollMemberDTO extends MccMemberDTO {

    public PollMemberDTO(String account, Integer accountType, String name) {
        super(account, accountType, name);
    }

//    public static List<PollMemberDTO> fromTemplate(List<TemplatePollMemberBO> memberList, String e164) {
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<TemplatePollMemberBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//        //非moid账号，单独查询
//        List<PollMemberDTO> pollMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = userAdapter.getUser(m.getAccount(), m.getAccountType(),
//                                    null);
//                            if (u == null) {
//                                return null;
//                            }
//                            PollMemberDTO mem = new PollMemberDTO();
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//                            mem.setName(u.getName());
//                            mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                            mem.setPortrait(u.getPortrait32());
//                            return mem;
//                        }
//                ).filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        List<TemplatePollMemberBO> platformMembers = mapMembers.get(Boolean.TRUE);
//        List<String> moidList = platformMembers.stream().map(TemplatePollMemberBO::getAccount).distinct().collect(Collectors.toList());
//        // moid，批量查询
////        List<MUserBO> pollAttends = userAdapter.getAllUserByAccount(moidList);
//        List<MUserBO> pollAttends = userAdapter.getAllUserByAccountForCache(moidList);
//        //获取moid 与 成员 对应关系
//        Map<String, MUserBO> mapMoidMember = pollAttends.stream().collect(Collectors.toMap(MUserBO::getMoid, Function.identity()));
//        pollMember.addAll(platformMembers.stream().map(
//                m -> {
//                    PollMemberDTO mem = new PollMemberDTO();
//                    MUserBO userVO = mapMoidMember.get(m.getAccount());
//                    //account取moid
//                    mem.setAccount(m.getAccount());
//                    mem.setAccountType(m.getAccountType());
//                    mem.setName(userVO == null ? m.getAccount() : userVO.getName());
//                    mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                    mem.setPortrait(userVO == null ? "" : userVO.getPortrait32());
//                    return mem;
//                }
//        ).collect(Collectors.toList()));
//        return pollMember;
//    }
//
//    public static List<PollMemberDTO> fromVMeeting(List<BaseMemberBO> memberList, String e164) {
//        UserServiceAdapter userAdapter = ApplicationContextUtils.getBean(UserServiceAdapter.class);
//        //将账号按是否moid分为两类
//        Map<Boolean, List<BaseMemberBO>> mapMembers =
//                Optional.ofNullable(memberList)
//                        .orElseGet(ArrayList::new)
//                        .stream()
//                        .collect(Collectors.partitioningBy(m -> MtTypeEnum.Platform.getValue().equals(m.getAccountType())));
//        //非moid账号，单独查询
//        List<PollMemberDTO> pollMember = mapMembers.get(Boolean.FALSE)
//                .stream().map(
//                        m -> {
//                            SimpleUserVO u = userAdapter.getUser(m.getAccount(), m.getAccountType(),
//                                    null);
//                            if (u == null) {
//                                return null;
//                            }
//                            PollMemberDTO mem = new PollMemberDTO();
//                            mem.setAccount(m.getAccount());
//                            mem.setAccountType(m.getAccountType());
//                            mem.setName(u.getName());
//                            mem.setConfE164(StringUtils.isBlank(m.getParentId()) ? e164 : m.getParentId());
//                            mem.setPortrait(u.getPortrait32());
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
//                    PollMemberDTO mem = new PollMemberDTO();
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
}

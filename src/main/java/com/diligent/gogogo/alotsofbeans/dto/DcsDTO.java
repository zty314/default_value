package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 数据会议
 */
@Data
@ApiModel
public class DcsDTO {

    @ApiModelProperty(value = "数据协作成员", open = false)
    private List<PortraitMemberDTO> dcsMembers;

    @ApiModelProperty(value = "数据协作模式", dict = {"0:关闭数据协作", "1:管理方控制", "2:自由协作"}, example = "2")
    private Integer mode;

//    public VMeetingDcsBO toMeetingDcs(Boolean enable) {
//        VMeetingDcsBO bo = new VMeetingDcsBO();
//        bo.setMode(this.getMode());
//        bo.setEnable(enable);
//        return bo;
//    }
//
//    public static DcsDTO fromVMeeting(VMeetingDcsBO dcsBO) {
//        if (null == dcsBO) {
//            return null;
//        }
//        DcsDTO dto = new DcsDTO();
//        dto.setMode(dcsBO.getMode());
//        dto.setDcsMembers(CollectionUtils.isNotEmpty(dcsBO.getMemberList()) ? dcsBO.getMemberList().stream()
//                .map(mem -> new PortraitMemberDTO(mem.getAccount(), mem.getAccountType(), mem.getName())).collect(Collectors.toList()) : new ArrayList<>());
//        return dto;
//    }
}

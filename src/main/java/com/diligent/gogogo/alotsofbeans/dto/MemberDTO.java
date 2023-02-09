package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zhaoyubin
 * @date 2022/2/18
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@ApiModel
public class MemberDTO extends BaseMemberDTO {

    @ApiModelProperty(value = "终端呼叫码率", notes = "不可超过会议码率，默认为会议码率", required = true, example = "2048")
    private Integer bitrate;

    @ApiModelProperty(value = "呼叫协议",
            dict = {"0:H323", "1:SIP", "2:RTC", "255:AUTO"}
            , notes = "若终端版本低于 6.1SP5 且为组织架构账号/E164号，则忽略下参，按规则匹配；否则，若终端下参，以下参为准，不下参按规则匹配\n" +
            "匹配规则:\n" +
            "  1.组织架构账号/E164号: protocol 为 AUTO\n" +
            "  2.ip账号:\n" +
            "    conf_protocol 为 H323或RTC : protocol 为 H323\n" +
            "    conf_protocol 为 SIP : protocol 为 SIP", example = "255")
    private Integer protocol;

    @ApiModelProperty(value = "头像信息，保存无需下参", open = false)
    private String portrait;

    @ApiModelProperty(value = "是否是互动终端，除Web其余禁传", dataType = "java.lang.Integer", open = false)
    private Boolean interactiveMt;

    @ApiModelProperty(value = "会议e164号，级联会议时为本级会议e164号", open = false)
    private String parentId;

    @ApiModelProperty(value = "账号密级", dict = {"0:未定义", "1:公开", "2:内部", "3:秘密", "4:机密"}, open = false)
    private Integer securityLevel; // 账号密级 0-未定义 1-公开 2-内部 3-秘密 4-机密

    @ApiModelProperty(value = "是否参会", dict = {" 0:否", "1:是"}, open = false)
    private Integer isParticipated;

    @ApiModelProperty(value = "是否有双流权限", dict = {" 0:否", "1:是"}, open = false)
    private Integer doubleFlow; // 是否有双流权限

    public MemberDTO(String account, Integer accountType, String name) {
        super(account, accountType, name);
    }

//    public MeetingMemberBO toMeetingMember(Boolean isInteractive, Integer isParticipated) {
//        MeetingMemberBO bo = new MeetingMemberBO();
//        bo.setAccount(this.getAccount());
//        bo.setAccountType(this.getAccountType());
//        bo.setProtocol(this.getProtocol());
//        bo.setBitrate(this.getBitrate());
//        bo.setInteractiveMt(isInteractive);
//        bo.setIsParticipated(isParticipated);
//        return bo;
//    }
//
//    public static MemberDTO fromCascadeMemberBO(CascadeMemberVO vo) {
//        MemberDTO dto = new MemberDTO();
//        BeanUtils.copyProperties(vo, dto);
//        dto.setInteractiveMt(MtConstants.INTERACTIVE_MT_INT.equals(vo.getInteractiveMt()));
//        return dto;
//    }
}

package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MccMemberDTO extends PortraitMemberDTO {

    @ApiModelProperty(value = "mtKey", notes = "仅用于会控返回", open = false)
    private String mtKey;
    @ApiModelProperty(value = "在线状态", dict = {"0:不在线", "1:在线"}, notes = "仅用于会控返回", open = false)
    private Integer online; // 在线状态：0-不在线，1-在线
    @ApiModelProperty(value = "哑音", dict = {"0:未哑音", "1:哑音"}, notes = "仅用于会控返回", open = false)
    private Integer mute; // 哑音：1-哑音 0-未哑音
    @ApiModelProperty(value = "是否多流", dict = {"0:否", "1:是"}, notes = "仅用于会控返回", open = false)
    private Integer stream;// 是否多流。0：否；1：是
    @ApiModelProperty(value = "mtType", notes = "仅用于会控返回", open = false)
    private String mtType;
    @ApiModelProperty(value = "e164", notes = "仅用于会控返回", open = false)
    private String e164;

    public MccMemberDTO(String account, Integer accountType, String name) {
        super(account, accountType, name);
    }

//    public static void setMccMTInfo(String confE164, MccMemberDTO mem) {
//        if (StringUtils.isNotBlank(mem.getAccount()) && mem.getAccountType() != null) {
//            mem.setOnline(0);
//            mem.setMtType("1");
//            if (MtTypeEnum.Phone.getValue().equals(mem.getAccountType())) {
//                mem.setMtType("3");
//            }
//            if ((mem.getAccountType() == 1 || mem.getAccountType() == 2) && StringUtils.isNotBlank(mem.getE164())) {
//                mem.setAccount(mem.getE164());
//                mem.setAccountType(5);
//            }
//            if (StringUtils.isBlank(mem.getConfE164())) {
//                mem.setConfE164(confE164); // 如果为空就设置为本级会议e164
//            }
//            //离线、离会的终端，在预案列表中也需要展示
//            mem.setMtKey(mem.getConfE164() + "_" + mem.getAccount());
//            MccMTService mccMTService = ApplicationContextUtils.getBean(MccMTService.class);
//            List<MccMTVO> mtvoList = mccMTService.getMccMTVOListBye164(confE164, mem.getAccount());
//            for (MccMTVO mtvo : mtvoList) {
//                if (StringUtils.equals(mem.getConfE164(), mtvo.getConfE164())) {
//                    mem.setMtKey(mtvo.getMtKey());
//                    mem.setOnline(mtvo.getOnline());
//                    mem.setName(mtvo.getName());
//                    mem.setMute(mtvo.getMute());
//                    mem.setStream(mtvo.getStream());
//                    mem.setMtType(mtvo.getMtType());
//                    break;
//                }
//            }
//        }
//    }

}

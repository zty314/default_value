package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoyubin
 * @date 2022/5/13 9:49
 */
@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class BaseMemberDTO {
    @ApiModelProperty(value = "帐号", notes = "最大字符长度：128个字节", required = true, example = "c69da1ef-5930-47e0-9a79-dfa083de0208", position = 1)
    private String account;
    @ApiModelProperty(value = "帐号类型", dict = {"1:moid", "4:非系统邮箱", "5:e164号", "6:电话", "7:ip地址", "8:别名@ip(监控前端)"}, required = true, example = "1", position = 2)
    private Integer accountType;
    @ApiModelProperty(value = "名称；仅作展示使用，下参无效", notes = "最大字符长度：128个字节", example = "我是xxx", position = 3,defaultValue = "2022年9月20日11:09:19")
    private String name;

//    public static BaseMemberDTO fromBaseMemberBO(BaseMemberBO member) {
//        BaseMemberDTO m = new BaseMemberDTO();
//        m.setAccount(member.getAccount());
//        m.setAccountType(member.getAccountType());
//        m.setName(member.getName());
//        return m;
//    }
//
//    public BaseMemberBO toBaseMember() {
//        BaseMemberBO bo = new BaseMemberBO();
//        bo.setAccount(this.getAccount());
//        bo.setAccountType(this.getAccountType());
//        return bo;
//    }
//
//    public static BaseMemberDTO fromMUserBO(MUserBO user) {
//        BaseMemberDTO dto = new BaseMemberDTO();
//        dto.setName(user.getName());
//        // 只取moid
//        dto.setAccount(user.getMoid());
//        dto.setAccountType(1);
//        return dto;
//    }

}

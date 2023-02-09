package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zhaoyubin
 * @date 2022/5/12 19:05
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
@NoArgsConstructor
public class CascadeMemberDTO extends BaseMemberDTO{
    @ApiModelProperty(value = "会议e164号",notes = "级联会议时为本级会议e164号", example = "000001")
    private String confE164;

    public CascadeMemberDTO(String account, Integer accountType, String name) {
        super(account, accountType, name);
    }

//    @Override
//    public BaseMemberBO toBaseMember() {
//        BaseMemberBO bo = new BaseMemberBO();
//        bo.setAccount(this.getAccount());
//        bo.setAccountType(this.getAccountType());
//        bo.setParentId(this.getConfE164());
//        return bo;
//    }
}

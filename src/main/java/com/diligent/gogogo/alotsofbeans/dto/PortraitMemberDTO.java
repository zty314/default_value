package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PortraitMemberDTO extends CascadeMemberDTO {
    @ApiModelProperty(value = "头像，仅作为显示使用，无需下参", open = false)
    private String portrait;
    @ApiModelProperty(value = "账号密级，仅作为显示使用，无需下参", open = false)
    private Integer securityLevel;
    @ApiModelProperty(value = "双流权限", open = false)
    private Integer doubleFlow;

	public PortraitMemberDTO(String account, Integer accountType, String name) {
		super(account, accountType, name);
	}
    
    
}

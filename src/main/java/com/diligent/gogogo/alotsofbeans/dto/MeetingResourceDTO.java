/**
 * @(#)MeetingResourceDTO.java 2018年3月24日 Copyright 2018 it.kedacom.com, Inc. All
 * rights reserved.
 */

package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 会议资源DTO
 *
 * @author leixiaojing
 * @date 2018年3月24日
 */
@Data
@ApiModel("会议资源DTO")
public class MeetingResourceDTO {

    @ApiModelProperty("会议室类型/规模id")
    public Integer id;
    @ApiModelProperty("已使用数")
    public Integer usedCount;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("setting表映射key")
    private String key;
    @ApiModelProperty("方数")
    private Integer multi;
    @ApiModelProperty("分辨率")
    private String resolution;
    @ApiModelProperty("总数")
    private Integer totalCount;

    public MeetingResourceDTO() {
    }

    public MeetingResourceDTO(Integer id) {
        this.id = id;
    }

//    public static MeetingResourceDTO fromConferenceLimit(UserDomainVO userDomain) {
//        if (null == userDomain || null == userDomain.getLargeConference())
//            return null;
//        MeetingResourceDTO resource = new MeetingResourceDTO();
//        resource.setId(9);
//        resource.setName("192方");
//        resource.setMulti(192);
//        resource.setResolution("");
//        resource.setKey("large_conference");
//        resource.setTotalCount(userDomain.getLargeConference());
//        return resource;
//    }

    public static MeetingResourceDTO fromLargeConference(Integer meetingRresourceId) {
        if (null == meetingRresourceId || 9 != meetingRresourceId) {
            return null;
        }
        MeetingResourceDTO resource = new MeetingResourceDTO();
        resource.setId(9);
        resource.setName("192方");
        resource.setMulti(192);
        resource.setResolution("");
        resource.setKey("large_conference");
        resource.setTotalCount(0);
        return resource;
    }


}

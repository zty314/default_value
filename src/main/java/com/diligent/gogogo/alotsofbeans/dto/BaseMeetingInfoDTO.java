package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author zhaoyubin
 * @date 2022/5/12 13:40
 */
@ApiModel
@Data
public class BaseMeetingInfoDTO {

    @ApiModelProperty(value = "会议名称", notes = "\n1.字符限制：\na.不支持输入特殊字符：% & * ^ ~ ' \" \" ? / \\ < > | ` \" $\n  b.且首字符和尾字符不支持输入，下划线（_） 减号（-） 小数点（.） @ （除首尾字符可以输入）\n2.最大字符长度：64个字节", required = true, position = 0, example = "传统会议")
    private String name;

    @ApiModelProperty(value = "会议时长", notes = "0为永久会议", defaultValue = "240")
    private Integer duration;

    @ApiModelProperty(value = "保留字段，无用", open = false)
    private Integer bitrate;

    @ApiModelProperty(value = "会议免打扰", dict = {"1:开启", "0:关闭"}, dataType = "java.lang.Integer", defaultValue = "0")
    private Boolean closedConf;

    @ApiModelProperty(value = "会议安全", dict = {"0:公开会议", "1:隐藏会议"}, defaultValue = "0")
    private Integer safeConf;

    @ApiModelProperty(value = "会议密码", notes = "1:字符限制：仅支持 英文字母(大小写) 数字 下划线(_) 小数点(.) 2:最大字符长度32个字节", example = "!QAZ2wsx")
    private String password;

    @ApiModelProperty(value = "传输加密类型", dict = {"0:不加密", "2:AES加密", "3:商密(SM4)", "4:商密(SM1)"}, defaultValue = "0")
    private Integer encryptedType;

    @ApiModelProperty(value = "终端双向认证", dict = {"0:关闭", "1:开启"}, defaultValue = "0", dataType = "java.lang.Integer")
    private Boolean encryptedAuth;

    @ApiModelProperty(value = "是否允许RTC接入", dict = {"0:关闭", "1:开启"}, dataType = "java.lang.Integer", defaultValue = "0")
    private Boolean enableRtc;

    @ApiModelProperty(value = "呼叫模式", dict = {"0:手动", "2:自动"}, defaultValue = "2")
    private Integer callMode;

    @ApiModelProperty(value = "呼叫次数", example = "0", defaultValue = "0")
    private Integer callTimes;

    @ApiModelProperty(value = "呼叫间隔(秒)", example = "20", defaultValue = "20")
    private Integer callInterval;

    @ApiModelProperty(value = "初始化哑音", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", example = "0", defaultValue = "0")
    private Boolean mute;

    @ApiModelProperty(value = "是否禁止终端侧解除哑音", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", open = false)
    private Boolean forceMute;

    @ApiModelProperty(value = "初始化静音", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", defaultValue = "0")
    private Boolean silence;

    @ApiModelProperty(value = "视频质量", notes = "其中租赁环境默认设为速度优先，自建环境默认为质量优先", dict = {"0:质量优先", "1:速度优先"}, defaultValue = "0")
    private Integer videoQuality;

    @ApiModelProperty(value = "归一重整", dict = {"0:不使用", "1:使用"}, defaultValue = "0", dataType = "java.lang.Integer")
    private Boolean oneReforming;

    @ApiModelProperty(value = "传输加密AES加密密钥", notes = "\n1:字符限制：仅支持 英文字母(大小写) 数字 下划线(_) 小数点(.),\n2:最大字符长度：32个字节", example = "!QAZ2wsx")
    private String encryptedKey;

    @ApiModelProperty(value = "双流权限", dict = {"0:发言会场", "1:任意会场", "2:指定会场"}, example = "1")
    private Integer dualMode;

    @ApiModelProperty(value = "是否开启语言激励", dict = {"0:不开启", "1:开启"}, dataType = "java.lang.Integer", required = true, example = "0")
    private Boolean voiceActivityDetection;

    @ApiModelProperty(value = "语音激励敏感度(s)", dict = {"3:3秒", "5:5秒", "15:15秒", "30:30秒"}, example = "5")
    private Integer vacinterval;

    @ApiModelProperty(value = "级联方式", dict = {"0:简单级联", "1:合并级联"}, example = "0")
    private Integer cascadeMode;

    @ApiModelProperty(value = "是否级联上传", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", example = "0")
    private Boolean cascadeUpload;

    @ApiModelProperty(value = "是否级联回传", dict = {"0:否", "1:是"}, dataType = "java.lang.Integetr", example = "0")
    private Boolean cascadeReturn;

    @ApiModelProperty(value = "级联回传带宽参数", example = "0")
    private Integer cascadeReturnPara;

    @ApiModelProperty(value = "最大与会终端数", dict = {"192:大型192方会议"}, defaultValue = "192")
    private Integer maxJoinMt;

    @ApiModelProperty(value = "会议中无终端时,是否自动结会", notes = "需要跟duration搭配使用，永久会议时默认为0", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", example = "1")
    private Boolean autoEnd;

    @ApiModelProperty(value = "预占资源模式(创会时就预占音视频适配器)", notes = "如会议类型为SFU则为纯转发", dict = {"0:不预占模式", "1:预占模式", "2:SFU纯转发模式"}, defaultValue = "0")
    private Integer preoccupyResource;
    private Integer preoccpuyResource;

    @ApiModelProperty(value = "是否来宾会议室", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", defaultValue = "0")
    private Boolean publicConf;

    @ApiModelProperty(value = "成为发言人后立即发起内容共享", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", defaultValue = "0")
    private Boolean doubleflow;

    @ApiModelProperty(value = "是否允许匿名登录", dict = {"0:不允许", "1:允许"}, dataType = "java.lang.Integer", defaultValue = "0")
    private Boolean anonymousMt;

    @ApiModelProperty(value = "是否开启多流", notes = "下级会议里存在多流终端需要回传的场景，需要设1", dict = {"0:不开启", "1:开启"}, dataType = "java.lang.Integer", defaultValue = "0")
    private Boolean multiStream;

    @ApiModelProperty(value = "是否开启视频水印", dict = {"0:不开启", "1:开启"}, dataType = "java.lang.Integer", defaultValue = "0")
    private Boolean watermark;

    @ApiModelProperty(value = "会议优选协议", notes = "\n如果终端下参，以下参为准，如果不下参，根据之前生成的enable_rtc来生成，规则如下：\n  1. enable_rtc为1: conf_protocol为 RTC \n  2. enable_rtc为0: conf_protocol为 SIP", dict = {"0:H323", "1:SIP", "2:RTC"}, example = "1")
    private Integer confProtocol;

    @ApiModelProperty(value = "是否超大方", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", defaultValue = "0")
    private Boolean enableAudience;

    @ApiModelProperty(value = "是否开启fec", dict = {"0:否", "1:是"}, dataType = "java.lang.Integer", example = "0", defaultValue = "0")
    private Boolean fecMode;

    @ApiModelProperty(value = "是否开启全场哑音例外", dict = {"0:不对任何人例外", "1:对发言方和管理方例外"}, dataType = "java.lang.Integer", example = "0", defaultValue = "0")
    private Boolean muteFilter;

    @ApiModelProperty("发言人")
    private CascadeMemberDTO speaker;

    @ApiModelProperty("主席")
    private BaseMemberDTO chairman;

    @ApiModelProperty(value = "主视频格式列表", notes = "如SFU纯转发,默认H264_HP+HD1080+30+4096,其余默认H264_HP+HD720+30+2048")
    private List<MediaDTO> videoFormats;

    @ApiModelProperty(value = "音频格式列表", notes = "不填默认支持所有，空列表默认支持所有",
            dict = {"1:G.722", "2:G711(ULAW)", "3:G.711(ALAW)", "4:G.729", "5:G.728", "6:G722.1.C", "7:MP3", "8:G.719", "9:MPEG-4 AAC LC", "10:MPEG-4 AAC LD", "11:MPEG-4 AAC LC(stereo)", "12:MPEG-4 AAC LD(stereo)", "13:OPUS"})
    private List<Integer> audioFormats;

    @ApiModelProperty("参会成员")
    private List<MemberDTO> inviteMembers;

    @ApiModelProperty("观众成员")
    private List<MemberDTO> audiences;

    @ApiModelProperty("追呼成员")
    private List<PortraitMemberDTO> keepCallingMembers;

    @ApiModelProperty("轮询设置")
    private PollDTO poll;

    @ApiModelProperty("AI")
    private AIDTO ai;

    @ApiModelProperty("数据协作")
    private DcsDTO dcs;

    @ApiModelProperty("混音设置")
    private MixDTO mix;

    @ApiModelProperty("直播录像设置")
    private VideoLiveDTO recorder;

    @ApiModelProperty("画面合成设置")
    private VmpDTO vmp;

    @ApiModelProperty(value = "电视墙", open = false)
    private TvwallDTO tvWall;

    @ApiModelProperty("vips列表")
    private List<PortraitMemberDTO> vips;

    @ApiModelProperty(value = "常用终端", open = false)
    private List<PortraitMemberDTO> oftenMts;

    @ApiModelProperty(value = "是否量子加密", dataType = "java.lang.Integer", open = false)
    private Boolean quantumEncryption;

    @ApiModelProperty(value = "会议密级", dict = {"0:未定义", "1:公开", "2:内部", "3:秘密", "4:机密"}, open = false)
    private Integer securityLevel;

    @ApiModelProperty(value = "双流权限列表", open = false)
    private List<PortraitMemberDTO> doubleflowMembers;
    //SM
    @ApiModelProperty(value = "会议责任人", open = false)
    private PortraitMemberDTO responsible;
    @ApiModelProperty(value = "会议主持人", open = false)
    private PortraitMemberDTO presenter;
    @ApiModelProperty(value = "参会人", open = false)
    private List<MemberDTO> attendances;
    @ApiModelProperty(value = "主呼方", open = false)
    private PortraitMemberDTO caller;
    @ApiModelProperty(value = "被呼方", open = false)
    private PortraitMemberDTO callee;
    @ApiModelProperty(value = "会议种类 ", dict = {"0:普通会议", "1:调度会议", "2:点对点会议"}, open = false)
    private Integer confCategory;
}

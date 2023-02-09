package com.diligent.gogogo.alotsofbeans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 画面合成参数
 *
 * @author liujiawei
 * @date 2018年5月9日
 */
@Data
@ApiModel("画面合成参数")
public class MtNameStyleDTO {

    /**
     * 台标字体大小
     * 0-小；
     * 1-中；
     * 2-大；
     */
    @ApiModelProperty(value = "台标字体大小", dict = {"0:小", "1:中", "2:大"}, required = true, example = "1")
    private Integer fontSize;
    /**
     * 台标字体三原色#RGB格式，十六进制表示，默认为：#FFFFFF白色
     */
    @ApiModelProperty(value = "台标字体三原色#RGB格式，十六进制表示", defaultValue = "#FFFFFF", required = true)
    private String fontColor;
    /**
     * 台标显示位置，默认为1
     * 0-左上角；
     * 1-左下角；
     * 2-右上角；
     * 3-右下角；
     * 4-底部中间；
     */
    @ApiModelProperty(value = "台标显示位置", dict = {"0:左上角", "1:左下角", "2:右上角", "3:右下角", "4:底部中间"}, required = true, defaultValue = "1")
    private Integer position;

    public static String fromRGB(Integer r, Integer g, Integer b) {
        try {
            if (r != null && g != null && b != null) {

                String rStr = String.format("%02x", r).toUpperCase();

                String gStr = String.format("%02x", g).toUpperCase();

                String bStr = String.format("%02x", b).toUpperCase();

                return "#" + rStr + gStr + bStr;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static Integer[] toRGB(String text) {
        try {
            if (text.length() == 7) {
                Integer[] rgbInt = new Integer[3];
                String r = text.substring(1, 3);
                String g = text.substring(3, 5);
                String b = text.substring(5, 7);
                rgbInt[0] = Integer.parseInt(r, 16);
                rgbInt[1] = Integer.parseInt(g, 16);
                rgbInt[2] = Integer.parseInt(b, 16);
                return rgbInt;
            }
        } catch (Exception e) {
            return new Integer[]{
                    255, 255, 255
            };
        }
        return new Integer[]{
                255, 255, 255
        };
    }

    public static String toDTO(Integer[] text) {
        return String.format("#%02X%02X%02X", text[0], text[1], text[2]);
    }
}

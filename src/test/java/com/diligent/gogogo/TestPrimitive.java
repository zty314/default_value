package com.diligent.gogogo;

import com.diligent.gogogo.alotsofbeans.dto.TemplatePersonalDTO;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/9/20 13:46
 */
public class TestPrimitive {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(((Class) Integer.class.getField("TYPE").get(null)).isPrimitive());
        System.out.println(((Class) TemplatePersonalDTO.class.getField("TYPE").get(null)).isPrimitive());
        System.out.println(int.class.isPrimitive());
        System.out.println(void.class.isPrimitive());

    }
}
package com.diligent.gogogo;

import lombok.Data;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/9/7 9:19
 */
public class TestStaticInstance {
    public static void main(String[] args) {
        StaticBean bean1 = new StaticBean();
        StaticBean bean2 = new StaticBean();
        System.out.println(bean1.a);
        System.out.println(bean2.a);
        bean1.a = 2;
        System.out.println(bean1.a);
        System.out.println(bean2.a);
        bean2.a = 1;
        System.out.println(bean1.a);
        System.out.println(bean2.a);
    }
}
@Data
class StaticBean{
    static int a = 1;
}
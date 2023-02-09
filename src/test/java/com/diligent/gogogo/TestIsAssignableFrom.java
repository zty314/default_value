package com.diligent.gogogo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/9/23 13:27
 */
public class TestIsAssignableFrom {

    public static void main(String[] args) {
        System.out.println(Collection.class.isAssignableFrom(List.class));
        System.out.println(Map.class.isAssignableFrom(List.class));
        System.out.println(Map.class.isAssignableFrom(HashMap.class));
    }
}
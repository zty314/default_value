package com.diligent.gogogo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/7/29 16:09
 */
public class TestAddInStream {

//    public static void main(String[] args) {
//        ArrayList<Integer> objects = new ArrayList<>();
//        objects.add(1);
//        objects.add(2);
//        objects.add(3);
//        objects.stream().forEach(m->{
//            //不能加
//            objects.add(m);
//        });
//        System.out.println(objects);
//    }

    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        List<Integer> collect = objects.stream().peek(o -> {

        }).collect(Collectors.toList());
        System.out.println(collect);
    }
}
package com.diligent.gogogo;

import com.diligent.gogogo.hash.HashBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/7/22 12:02
 */
@SpringBootTest
public class TestTreeify {

    @Test
    public void hash_collision() {
        Map<HashBean, Integer> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(new HashBean(i), i);
        }
    }
}
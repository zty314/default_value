package com.diligent.gogogo.hash;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/7/22 12:01
 */
@Data
@AllArgsConstructor
public class HashBean {
    private Integer hash;

    @Override
    public int hashCode() {
        return 1;
    }
}
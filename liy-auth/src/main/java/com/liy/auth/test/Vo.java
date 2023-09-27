package com.liy.auth.test;

import lombok.Data;

/**
 * @Author LiY
 */

@Data

public class Vo {

    private Integer i;


    Po po = null;




    @Override
    public String toString() {
        return "Vo{" +
                "i=" + i +
                '}';
    }
}

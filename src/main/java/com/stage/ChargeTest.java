package com.stage;

import java.math.BigDecimal;

/**
 * @Auther: 张扬
 * @Date: 2018/9/28 16:22
 * @Description:
 */
public class ChargeTest {

    public static void main(String args[]){
       BigDecimal bigDecimal = ChargeFactory.getInstance().createChargeStage(ChargeEuem.GENNERAL).charge(ChargeEuem
                     .GENNERAL);
        System.out.println(bigDecimal);
    }

}

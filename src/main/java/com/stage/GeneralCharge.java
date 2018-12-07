package com.stage;

import java.math.BigDecimal;

/**
 * @Auther: 张扬
 * @Date: 2018/9/28 11:14
 * @Description:
 */
@AmountInterface(chargeType = 100)
public class GeneralCharge implements ChargeInterface {

    @Override
    public BigDecimal charge(ChargeEuem chargeEuem) {
        return BigDecimal.ONE;
    }
}

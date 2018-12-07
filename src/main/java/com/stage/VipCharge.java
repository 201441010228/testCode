package com.stage;

import com.stage.ChargeInterface;
import java.math.BigDecimal;

/**
 * @Auther: 张扬
 * @Date: 2018/9/28 11:11
 * @Description:
 */
@AmountInterface(chargeType = 200)
public class VipCharge implements ChargeInterface {

    @Override
    public BigDecimal charge(ChargeEuem chargeEuem) {
        return BigDecimal.TEN;
    }
}

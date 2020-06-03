package com.demo.test.test2;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDeciamlTest {
    public static void main(String[] args) {
        BigDecimal aggramt = BigDecimal.TEN;
        BigDecimal aa = new BigDecimal("0.00051");
        BigDecimal gintAmt = new BigDecimal("33.54");
        aggramt = gintAmt.multiply(new BigDecimal("360")).divide(new BigDecimal("0.0035"),2,BigDecimal.ROUND_HALF_DOWN);
        gintAmt = gintAmt.divide(new BigDecimal("0.0035"),3,BigDecimal.ROUND_DOWN);
        System.out.println(gintAmt);
        System.out.println(aggramt);
        System.out.println(aa.divide(new BigDecimal("100")));
        System.out.println(new BigDecimal("0.41").setScale(2).toString());
        System.out.println(new DecimalFormat("#.00").format(new BigDecimal("0.11")));

    }
}

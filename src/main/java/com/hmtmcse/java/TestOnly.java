package com.hmtmcse.java;

import java.math.BigDecimal;

public class TestOnly {

    public static void main(String[] args) {
        Double priceD = 1.15;
        Double taxRateD = 10.0;
        Double result = (priceD * taxRateD) / 100;
        System.out.println(result);


        BigDecimal priceB = new BigDecimal("1.15");
        BigDecimal taxRateB = new BigDecimal("10.0");

        System.out.println(priceB.multiply(taxRateB).divide(new BigDecimal(100)));
    }

}

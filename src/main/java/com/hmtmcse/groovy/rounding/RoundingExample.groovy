package com.hmtmcse.groovy.rounding

import java.math.RoundingMode

class RoundingExample {

    /*
    ROUND_HALF_UP:


    */

    public static void main(String[] args) {
        Integer precision = 2
        RoundingMode roundingMode = RoundingMode.HALF_EVEN
        BigDecimal bigDecimal
        BigDecimal valueOf
        System.out.println("D value  valueOf actual")
        def dataSet = [5.3999999999999995,5.3999,
                0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9,

                1.011, 1.022, 1.033, 1.044, 1.055, 1.066, 1.077, 1.088, 1.099,
                1.045, 1.044,
        ]


        println("Rounding Mode ROUND_HALF_UP")
        dataSet.each {Double data ->
            valueOf = BigDecimal.valueOf(data).setScale(precision, BigDecimal.ROUND_HALF_UP)
            bigDecimal = new BigDecimal(data).setScale(precision, BigDecimal.ROUND_HALF_UP)
            System.out.println(bigDecimal.doubleValue() + " " + valueOf + " " + data)
        }

        roundingMode = RoundingMode.HALF_UP
        println("Rounding Mode " + roundingMode.toString())
        dataSet.each {Double data ->
            bigDecimal = new BigDecimal(data).setScale(precision, roundingMode)
            valueOf = BigDecimal.valueOf(data).setScale(precision, roundingMode)
            System.out.println(bigDecimal.doubleValue() + " " + valueOf + " " + data)
        }

        println("Rounding Mode " + roundingMode.toString())
        dataSet.each {Double data ->
            bigDecimal = new BigDecimal(data).setScale(precision, roundingMode)
            valueOf = BigDecimal.valueOf(data).setScale(precision, roundingMode)
            System.out.println(bigDecimal.doubleValue() + " " + valueOf + " " + data)
        }


        roundingMode = RoundingMode.HALF_DOWN
        println("Rounding Mode " + roundingMode.toString())
        dataSet.each {Double data ->
            bigDecimal = new BigDecimal(data).setScale(precision, roundingMode)
            valueOf = BigDecimal.valueOf(data).setScale(precision, roundingMode)
            System.out.println(bigDecimal.doubleValue() + " " + valueOf + " " + data)
        }


    }
}

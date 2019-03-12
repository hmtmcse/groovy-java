package com.hmtmcse.java.number;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NumberFormating {


    public static void dk() {
        NumberFormat numberFormat =
                NumberFormat.getCurrencyInstance(new Locale("da", "DK"));
        numberFormat.setCurrency(Currency.getInstance("EUR"));

        String currencyString = numberFormat.format(120.99);
        System.out.println(currencyString);
    }

    public static void main(String[] args) {
        Locale locale = new Locale( "", "AUD");
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
//        NumberFormat numberFormat = new DecimalFormat("00.###############");
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        numberFormat.setCurrency(Currency.getInstance("AUD"));
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        String number = numberFormat.format(10000.99);
        System.out.println(number);

        dk();
    }

}

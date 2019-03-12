package com.hmtmcse.groovy.rounding;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TMMath {

    private BigDecimal bigDecimal = null;

    public TMMath(Double number) {
        this.bigDecimal = toBigDecimal(number);
    }

    public TMMath(Long number) {
        this.bigDecimal = toBigDecimal(number);
    }

    public TMMath(Float number) {
        this.bigDecimal = toBigDecimal(number);
    }

    public TMMath(BigDecimal number) {
        this.bigDecimal = number;
    }

    public TMMath(String number) {
        this.bigDecimal = toBigDecimal(number);
    }


    private TMMath() {}

    public TMMath(Integer number) {
        this.bigDecimal = toBigDecimal(number);
    }

    public BigDecimal toBigDecimal(Double number){
        return BigDecimal.valueOf(number);
    }

    public BigDecimal toBigDecimal(Integer number){
        return BigDecimal.valueOf(number);
    }

    public BigDecimal toBigDecimal(String number){
        return new BigDecimal(number);
    }

    public BigDecimal toBigDecimal(Long number){
        return BigDecimal.valueOf(number);
    }


    public BigDecimal toBigDecimal(Float number){
        return BigDecimal.valueOf(number);
    }

    public Double toDouble(){
        return this.bigDecimal.doubleValue();
    }

    public Long toLong(){
        return this.bigDecimal.longValue();
    }

    public Integer toInteger(){
        return this.bigDecimal.intValue();
    }

    public BigDecimal toBigDecimal(){
        return this.bigDecimal;
    }


    public String toString(){
        return this.bigDecimal.toString();
    }

    public TMMath add(Double ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.add(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath add(Integer ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.add(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath add(Long ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.add(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath add(Float ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.add(this.toBigDecimal(number[i]));
        }
        return this;
    }


    public TMMath add(Double number){
        this.bigDecimal = this.bigDecimal.add(this.toBigDecimal(number));
        return this;
    }

    public TMMath add(Integer number){
        this.bigDecimal = this.bigDecimal.add(this.toBigDecimal(number));
        return this;
    }

    public TMMath add(Long number){
        this.bigDecimal = this.bigDecimal.add(this.toBigDecimal(number));
        return this;
    }


    public TMMath add(Float number){
        this.bigDecimal = this.bigDecimal.add(this.toBigDecimal(number));
        return this;
    }

    public TMMath multiply(Double number){
        this.bigDecimal = this.bigDecimal.multiply(this.toBigDecimal(number));
        return this;
    }

    public TMMath multiply(Integer number){
        this.bigDecimal = this.bigDecimal.multiply(this.toBigDecimal(number));
        return this;
    }

    public TMMath multiply(Long number){
        this.bigDecimal = this.bigDecimal.multiply(this.toBigDecimal(number));
        return this;
    }


    public TMMath multiply(Float number){
        this.bigDecimal = this.bigDecimal.multiply(this.toBigDecimal(number));
        return this;
    }

    public TMMath multiply(Double ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.multiply(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath multiply(Integer ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.multiply(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath multiply(Long ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.multiply(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath multiply(Float ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.multiply(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath subtract(Double number){
        this.bigDecimal = this.bigDecimal.subtract(this.toBigDecimal(number));
        return this;
    }

    public TMMath subtract(Integer number){
        this.bigDecimal = this.bigDecimal.subtract(this.toBigDecimal(number));
        return this;
    }

    public TMMath subtract(Long number){
        this.bigDecimal = this.bigDecimal.subtract(this.toBigDecimal(number));
        return this;
    }


    public TMMath subtract(Float number){
        this.bigDecimal = this.bigDecimal.subtract(this.toBigDecimal(number));
        return this;
    }

    public TMMath subtract(Double ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.subtract(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath subtract(Integer ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.subtract(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath subtract(Long ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.subtract(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath subtract(Float ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.subtract(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath divide(Double number, RoundingMode roundingMode, Integer scale){
        this.bigDecimal = this.bigDecimal.divide(this.toBigDecimal(number), scale, roundingMode);
        return this;
    }

    public TMMath divide(BigDecimal number){
        this.bigDecimal = this.bigDecimal.divide(number);
        return this;
    }

    public TMMath divide(Double number){
        this.bigDecimal = this.bigDecimal.divide(this.toBigDecimal(number));
        return this;
    }

    public TMMath divide(Integer number){
        this.bigDecimal = this.bigDecimal.divide(this.toBigDecimal(number));
        return this;
    }

    public TMMath divide(Long number){
        this.bigDecimal = this.bigDecimal.divide(this.toBigDecimal(number));
        return this;
    }


    public TMMath divide(Float number){
        this.bigDecimal = this.bigDecimal.divide(this.toBigDecimal(number));
        return this;
    }

    public TMMath divide(Double ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.divide(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath divide(Integer ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.divide(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath divide(Long ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.divide(this.toBigDecimal(number[i]));
        }
        return this;
    }

    public TMMath divide(Float ...number) {
        for (int i = 0; i < number.length; i++){
            this.bigDecimal = this.bigDecimal.divide(this.toBigDecimal(number[i]));
        }
        return this;
    }

    private BigDecimal roundBig(Integer scale, RoundingMode roundingMode){
        return this.bigDecimal.setScale(scale, roundingMode);
    }

    public TMMath round(Integer scale, RoundingMode roundingMode){
        this.bigDecimal = this.roundBig(scale, roundingMode);
        return this;
    }

    public TMMath mathRound(Integer scale){
        this.bigDecimal = this.roundBig(scale, RoundingMode.HALF_UP);
        return this;
    }

    public static TMMath start(Long number){
        return new TMMath(number);
    }

    public static TMMath start(Float number){
        return new TMMath(number);
    }


    public static TMMath start(Integer number){
        return new TMMath(number);
    }


    public static TMMath start(Double number){
        return new TMMath(number);
    }

    public static TMMath start(BigDecimal number){
        return new TMMath(number);
    }


    public static TMMath fromString(String number){
        return new TMMath(number);
    }

}

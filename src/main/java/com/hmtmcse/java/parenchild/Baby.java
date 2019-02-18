package com.hmtmcse.java.parenchild;

public class Baby extends Father{

    public String gender;

    public Baby(String name, Double age) {
        super(name, age);
    }

    public Baby setGender(String gender) {
        this.gender = gender;
        return this;
    }
}

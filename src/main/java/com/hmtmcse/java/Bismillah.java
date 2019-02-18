package com.hmtmcse.java;

import com.hmtmcse.java.parenchild.Baby;
import com.hmtmcse.java.parenchild.CastingTest;
import com.hmtmcse.java.parenchild.Father;

public class Bismillah {
    public static void main(String[] args) {
        System.out.println("Bismillah Java");

        Father father = new Father("My Father", 50.00);
        Baby baby = new Baby("My Child", 10.0).setGender("Male");
        CastingTest.takeBaby(baby);
        CastingTest.takeFather(baby);
        father = baby;
        CastingTest.takeFather(father);

    }

}

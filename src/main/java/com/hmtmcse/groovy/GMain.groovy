package com.hmtmcse.groovy

class MyClass {
    String myString = "myString1"
    def outerClosure = {
        println myString;     // outputs myString1
        def nestedClosure = {
            println myString;  // outputs myString1
        }
        nestedClosure()
    }
}

class GMain {





    public static void main(String[] args) {

        MyClass myClass = new MyClass()
        def closure = new MyClass().outerClosure
        closure()

        println myClass.myString


    }


}

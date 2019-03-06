package com.hmtmcse.groovy.closure

class ClosureTest {

    def  simpleClosure = {
        println("Bismillah")
    }

    public static void main(String[] args) {
        ClosureTest closureTest = new ClosureTest()
        closureTest.simpleClosure()
        closureTest.simpleClosure.call()
    }

}

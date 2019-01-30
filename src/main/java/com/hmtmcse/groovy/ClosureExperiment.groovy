package com.hmtmcse.groovy

class ClosureExperiment {

    Closure leftOption = {
        println("leftOption")
    }

    Closure rightOption = {
        right {
            println("xyz")
        }
    }


}

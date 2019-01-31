package com.hmtmcse.groovy.gc

class GroovyClosure {


    Closure closureForCalling = { println("Called") }

    def closureWithOneArg = { string -> string.toUpperCase() }
    def closureWithOneArgAndExplicitType = { String string -> string.toUpperCase() }
    def closureWithImplicitParameter = { println "Hello, $it!" }
    def closureWithVarargs = { String... args -> args.join(', ') }


    public static void main(String[] args) {
        GroovyClosure groovyClosure = new GroovyClosure()

//        Closure Calling
        groovyClosure.closureForCalling.call()
        groovyClosure.closureForCalling()


        groovyClosure.closureWithImplicitParameter("Here")
        println groovyClosure.closureWithVarargs("Abul", "Babul", "Sabul")


    }

}

package com.hmtmcse.groovy.gc

class OwnerDelegateAndThis {


    public static void main(String[] args) {


        def p = new PersonDelegateTest(name: 'Igor')
        def cl = { name.toUpperCase() }
        cl.resolveStrategy = Closure.DELEGATE_ONLY
        cl.delegate = p
        assert cl() == 'IGOR'
    }
}

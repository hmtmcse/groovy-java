package com.hmtmcse.groovy.gc

import com.hmtmcse.groovy.gc.delegate.Person

class OwnerDelegateAndThis {


    public static void main(String[] args) {


        def p = new Person(name: 'Igor')
        def cl = { name.toUpperCase() }
        cl.resolveStrategy = Closure.DELEGATE_ONLY
        cl.delegate = p
        assert cl() == 'IGOR'
    }
}

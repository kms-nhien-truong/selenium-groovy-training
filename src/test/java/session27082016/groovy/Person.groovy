package session27082016.groovy

/**
 * Created by nhientruong on 8/27/2016.
 */
class Person {
    def name

    //Constructor
    def Person(){
        //Count=Count+1
        Count++
        println 'creating a person...'
    }

    def sayHi(){
        //println name+": hi!"
        println "$name: hi!"
        //INTERPOLATION
    }

    def static displayCount(){
        println "There are $Count person(s) in the world."
    }
    def static Count = 0
}

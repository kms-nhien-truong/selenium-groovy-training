package session22102016.oop

/**
 * Created by nhientruong on 10/22/2016.
 */
class Person {
    private def name
    private def gender
    private def yearOfBirth

    Person(name, gender, yearOfBirth) {
        this.name = name
        this.gender = gender
        this.yearOfBirth = yearOfBirth
    }
    def eat(){
        println 'eating something'
    }
    def work(){
        println 'doing something'
    }
    def getName(){
        return name
    }
}

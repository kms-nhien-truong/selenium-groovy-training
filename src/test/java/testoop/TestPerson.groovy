package testoop

import session22102016.oop.Person

/**
 * Created by nhientruong on 10/22/2016.
 */
class TestPerson {
    public static void main(String[] args) {
        def nam
        nam = new Person('Nam', 'male', '1990')
        nam.name ='Nam Nguyen'
        println nam.name
        nam.eat()
        nam.work()
    }
}

package session27082016.groovy

/**
 * Created by nhientruong on 8/27/2016.
 */
class TestPerson {
    public static void main(String[] args) {
        def hau = new Person()
        hau.name="Hau"
        hau.sayHi() //not a static

        def nam = new Person()
        nam.name="Nam"
        //Person.sayHi() :
        //Problem, since sayHi is not a static method
        Person.displayCount()
        //Main point
        // Call static method directly from class
        // Call non-static method by an instance of the class

    }
}

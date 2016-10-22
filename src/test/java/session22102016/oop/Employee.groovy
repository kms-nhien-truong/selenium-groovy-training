package session22102016.oop

/**
 * Created by nhientruong on 10/22/2016.
 */
class Employee extends Person implements Codable{
    def employeeId
    def salary
    def jobTitle

    Employee(name, gender, yearOfBirth, employeeId, salary, jobTitle) {
        super(name, gender, yearOfBirth)
        this.employeeId = employeeId
        this.salary = salary
        setJobTitle(jobTitle)
    }
    def setJobTitle(jobTitle){

        this.jobTitle =jobTitle.trim().toLowerCase()
    }

    def work(){

        if(jobTitle=='qa'){
            println 'finding bugs'
        }
        else if(jobTitle=='dev'){
            println 'creating bugs'
        }
        else{
            println 'monitoring people'
        }
    }
    def eat(){
        if(salary>500 && salary <1000){
            println 'eating rice'
        }
        else if(salary>1000 && salary<2000){
            println 'eating pizza'
        }
        else{
            println 'eating bread'
        }
    }

    def code() {
        println 'coding groovy'
    }
}

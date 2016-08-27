package session27082016.groovy

/**
 * Created by nhientruong on 8/27/2016.
 */
class LearnStaticMethod {

    def sum(int a,int b){
        return a+b
    }
    def caller(){
        sum(3,4)
    }
    public static void main(String[] args) {
        println sum(3,4)
    }


}

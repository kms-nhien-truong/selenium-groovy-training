package session24092016.selenium.groovy

import org.testng.annotations.Test
import session24092016.selenium.java.JavaTest

/**
 * Created by nhientruong on 9/24/2016.
 */
class CallJavaTest {
    @Test
    void testJavaMethod(){
        new JavaTest()
            .sayHi()
    }
}

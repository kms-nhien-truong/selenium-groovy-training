package testoop

import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by nhientruong on 10/22/2016.
 */
class DataDrivenTest {

    //parameterize
    @Test(dataProvider = "testdata")
    void testSum(String stringA, String stringB, String stringExpectedResult){
        def a=stringA.toInteger()
        def b=stringB.toInteger()
        def expectedResult = stringExpectedResult.toInteger()
        def actualResult = Calculator.sum(a,b)
        assertThat(actualResult)
            .as("actual result of sum($a,$b)")
            .isEqualTo(expectedResult)

    }

    @DataProvider(name = "testdata")
    String[][] getData(){
        return [
            ["1","3","4"],
            ["2","7","8"],
        ]
    }
}

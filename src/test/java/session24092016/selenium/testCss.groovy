package session24092016.selenium

import common.TestBase
import org.openqa.selenium.By
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by nhientruong on 9/24/2016.
 */
class testCss extends TestBase{

    @BeforeClass
    void BeforeClass() {
        BaseUrl = 'http://www.w3schools.com/'

    }
    @Test
    void testColors(){
        def tryItLink= driver.findElement(By.partialLinkText('Try it Yourself'))
        def color = tryItLink.getCssValue('color')
        println "Color: '$color'"
        def bgColor = tryItLink.getCssValue('background-color')
        println "Color: '$bgColor'"

    }

}

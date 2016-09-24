package session24092016.selenium

import common.Keywords
import common.TestBase
import org.openqa.selenium.By
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by nhientruong on 9/24/2016.
 */
class TestNewWindow extends TestBase{

    @BeforeClass
    void BeforeClass() {
        BaseUrl = 'http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open3'

    }
    @Test(enabled = false)
    void testNewWindow(){
        //Pre-condition (before method)

        //Actions
        Keywords.clickButtonThroughFrames driver,'Try it'
        driver
                .switchTo()
                .window('MsgWindow')
        def bodyElement = driver.findElement(By.tagName('body'))

        //verification
        assertThat(bodyElement.getText())
            .as('Body content')
            .contains(' I am 200px wide and 100px tall')

        //post-condition
        //After method
    }

}

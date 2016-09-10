package session10092016.selenium

import common.Keywords
import common.TestBase
import org.openqa.selenium.By
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by nhientruong on 9/10/2016.
 */
class TestModernPopUp extends TestBase {
    @BeforeClass
    void BeforeClass() {
        BaseUrl = 'http://www.w3schools.com/howto/howto_css_modals.asp'
    }

    @Test
    void testPopup(){
        def result = Keywords.clickButtonThroughFrames(driver,'Open Modal')
        assertThat(result)
            .as('Button found')
            .isTrue()
        Thread.sleep(5000)
        def headerElement =Keywords.findElement(driver,By.xpath('//div[@id="id01"]/div/header/h2'))

        assertThat(headerElement.getText())
            .as('Popup header')
            .isEqualToIgnoringCase('modal header')

        def closeIcon = Keywords.findElement(driver,By.xpath('//div[@id="id01"]/div/header/span'))
        closeIcon.click()

    }

}

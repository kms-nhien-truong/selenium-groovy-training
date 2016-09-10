package session10092016.selenium

import common.Keywords
import common.TestBase
import org.openqa.selenium.By
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by nhientruong on 8/27/2016.
 */
class AlertTest extends TestBase {
    @BeforeClass
    void BeforeClass() {
        BaseUrl = TestBase.LOCAL_ROOT_FOLDER + 'frame.html'
    }

    @Test(enabled = false)
    void testAlertMessage(){
        //Defines elements
        driver
            .switchTo()
            .frame(0)

        def nameTextbox = driver.findElement(By.id('name'))
        def submitButton = driver.findElement(By.id('sayHello'))
        def googleLink = driver.findElement(By.id('google'))

        //data
        def name = 'Hoa'

        nameTextbox.sendKeys(name)
        submitButton.click()

        //Verification
        def alert = driver.switchTo()
                .alert()
        //def expectedMessage = 'hello ' +name
        //def expectedMessage = (String)"hello $name"//.toString()
        String expectedMessage = "hello $name"
        assertThat(alert)
            .as('an alert')
            .isNotNull()
        assertThat(alert.getText())
            .as('Alert message')
            .isEqualTo(expectedMessage)
        alert.accept()

        driver.switchTo()
                .defaultContent()
        //More step
        def by =By.xpath('//button[text()="Click me"]')
        def clickMeButton = driver.findElement(by)
        clickMeButton.click()
        alert = driver.switchTo().alert()
        if(alert!=null)
            alert.dismiss()

    }

    @Test
    void testClickMeKeyword(){
        Keywords.clickButtonThroughFrames(driver,'Say Hello')
        Thread.sleep(5000)
    }
}

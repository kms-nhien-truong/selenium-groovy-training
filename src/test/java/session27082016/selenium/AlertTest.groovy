package session27082016.selenium

import org.openqa.selenium.By
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import common.TestBase

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by nhientruong on 8/27/2016.
 */
class AlertTest extends TestBase {
    @BeforeClass
    void BeforeClass() {
        BaseUrl = TestBase.LOCAL_ROOT_FOLDER + 'hello.html'
    }

    @Test(enabled = false)
    void testAlertMessage(){
        //Defines elements
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
    }


    @Test(enabled = false)
    void testAcceptConfirm(){
        //Defines elements
        def nameTextbox = driver.findElement(By.id('name'))
        def submitButton = driver.findElement(By.id('writeName'))
        def contentDiv = driver.findElement(By.id('content'))
        //data
        def name = 'Hoa'
        def expectedMessage ='Is that your name?'

        nameTextbox.sendKeys(name)
        submitButton.click()
        //Verification
        def alert = driver.switchTo()
                .alert()
        assertThat(alert)
                .as('an alert')
                .isNotNull()
        assertThat(alert.getText())
                .as('Alert message')
                .isEqualTo(expectedMessage)
        alert.accept()
        assertThat(contentDiv.getText())
            .as('New content')
            .isEqualTo(name)


    }
    @Test
    void testDismissConfirm(){
        //Defines elements
        def nameTextbox = driver.findElement(By.id('name'))
        def submitButton = driver.findElement(By.id('writeName'))
        def contentDiv = driver.findElement(By.id('content'))
        //data
        def name = 'Hoa'
        def expectedMessage ='Is that your name?'

        nameTextbox.sendKeys(name)
        submitButton.click()
        //Verification
        def alert = driver.switchTo()
                .alert()
        assertThat(alert)
                .as('an alert')
                .isNotNull()
        assertThat(alert.getText())
                .as('Alert message')
                .isEqualTo(expectedMessage)
        alert.dismiss()
        assertThat(contentDiv.getText())
                .as('New content')
                .isEqualTo('a stranger')


    }
}

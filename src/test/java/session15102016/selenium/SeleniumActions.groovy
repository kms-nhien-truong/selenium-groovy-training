package session15102016.selenium

import common.Keywords
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.os.WindowsUtils
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by nhientruong on 10/15/2016.
 */
class SeleniumActions extends common.TestBase {

    @BeforeClass
    void BeforeClass() {
        WindowsUtils.killByName('firefox.exe')
        BaseUrl = 'file:///D:/08_YSV/12_aug-class/src/htmlsample/hoverMenu.html'
    }

    @Test(enabled = false)
    void hoverTest() {
        def dropdownButtonXpath = "//button[translate(text(),  'ABCDEFGHIJKLMNOPQRSTUVWXYZ'   ,'abcdefghijklmnopqrstuvwxyz')='dropdown']"
        def dropdownButton = driver.findElement(By.xpath(dropdownButtonXpath))

        def action  = new Actions(driver)
        action
                .moveToElement(dropdownButton)
                //.build()
                .perform()
        def facebookLink
        assertLinkPresent('Google')
        facebookLink = assertLinkPresent('Facebook')
        assertLinkPresent('Yahoo')
        facebookLink.click()

        //verify clicking on a menu item.
        def url = driver.getCurrentUrl()
        assertThat(url)
            .as('new url')
            .contains('facebook.com')


    }
    @Test
    void javascriptTest(){
        //todo: learn DOM object
        def textbox = driver.findElement(By.id('a-textbox'))
        def text='hello javascript'
        def script = "arguments[0].value='$text'"
        ((JavascriptExecutor) driver).executeScript(script,textbox)

        Thread.sleep(5000)
    }

    @Test(enabled = false)
    void doubleClickTest(){
        //Actions
        //1. identify the link
        def link = driver.findElement(By.name('double-click-link'))

        //2. double click
        new Actions(driver)
            .moveToElement(link)
            .doubleClick()
            .perform()

        //Verification
        //assert that an alert with message 'hello' present
        def alert = driver.switchTo().alert()
        assertThat(alert)
            .as('alert object')
            .isNotNull()
        def message = alert.getText()
        assertThat(message)
            .as('alert message')
            .isEqualTo('hello')
    }





    def assertLinkPresent(linkText){
        //todo: homework
        //Thread.sleep(3000)
        def by =//By.xpath("//a[text()='$linkText']")
        By.partialLinkText(linkText)
        def link = Keywords.findElement(driver,by)
        assertThat(link)
            .as(linkText)
            .isNotNull()
        return link
    }

    def assertLinkPresents(linkText){
        //todo: homework
        //get all links using find...elements
        //assert contains..
    }
}

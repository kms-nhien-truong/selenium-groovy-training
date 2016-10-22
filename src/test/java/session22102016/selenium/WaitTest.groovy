package session22102016.selenium

import common.Keywords
import common.TestBase
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import org.openqa.selenium.support.ui.ExpectedCondition
import org.jetbrains.annotations.Nullable

/**
 * Created by nhientruong on 10/22/2016.
 */
class WaitTest extends TestBase {
    @BeforeClass
    void BeforeClass(){
        BaseUrl="file:///D:/08_YSV/12_aug-class/src/htmlsample/waitForAlert.html"
    }

    @Test(enabled = false)
    void driverWaitTest(){

        def button = driver.findElement(By.tagName('button'))
        button.click()
        def wait = new WebDriverWait(driver,10)
        wait.until(ExpectedConditions.alertIsPresent())
        def alert = driver.switchTo().alert()
        alert.dismiss()
    }

    @Test(enabled = false)
    void driverWaitTestForDiv(){

        def button = driver.findElement(By.tagName('button'))
        button.click()
        def wait = new WebDriverWait(driver,10)
        wait.until(ExpectedConditions.textToBePresentInElement(By.tagName('div'),'new texts'))

    }

    @Test(enabled = false)
    void driverWaitTestForInputValue(){

        def button = driver.findElement(By.tagName('button'))
        button.click()
        def wait = new WebDriverWait(driver,10)
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.tagName('input'),'sample'))

    }

    @Test()
    void driverWaitValuePresent(){

        def button = driver.findElement(By.tagName('button'))
        button.click()
        //def wait = new WebDriverWait(driver,Configs.WAITING_TIMEOUT_IN_SECOND)
        def wait = Keywords.getDriverWaitObject(driver);
        //wait.until(new ValuePresent(By.tagName('input'),'sample'))
        wait.until(ValueOfElementIs(By.tagName('input'),'sample'))
    }

    static ExpectedCondition<Boolean> ValueOfElementIs(by, expectedValue){
        return new ExpectedCondition() {
            Object apply(@Nullable Object o) {
                def webDriver = (WebDriver)o;
                def input =webDriver.findElement(by)
                def value =input.getAttribute('value');
                return value==expectedValue
            }
        };
    }
}

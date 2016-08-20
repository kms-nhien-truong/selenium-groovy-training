package session13082016

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.Select
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.FacebookPage

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by USER on 13/08/2016.
 */
class TestUI {
    WebDriver driver =null
    @BeforeMethod(enabled = true)
    public void BeforeMethod(){
        driver = new FirefoxDriver()
        driver.get(FacebookPage.URL)
    }

    @AfterMethod(enabled = true)
    public void AfterMethod(){
        if(driver!=null)
            driver.quit()
    }
    @Test(enabled = false)
    public void TestEmailTextBox(){

        def emailTextbox = driver
                .findElement(By.name("email"))

        def isVisible = emailTextbox.isDisplayed()
        def isEnabled = emailTextbox.isEnabled()
        def currentText = emailTextbox.getText()
        def tabIndex = emailTextbox.getAttribute("tabIndex")
        assertThat(isVisible)
            .as("Is Visible")
            .isTrue()

        assertThat(isEnabled)
            .as("Is enabled")
            .isTrue()

        assertThat(currentText)
            .as("Current text")
            .isEqualTo("")

        assertThat(tabIndex)
                .as("Tab Index")
                .isEqualTo("1")
    }
    @Test(enabled = false)
    void TestRadioButton(){
        def femaleRadioButton = driver.findElement(By.id("u_0_e"))
        def maleRadioButton = driver.findElement(By.id("u_0_f"))
        //BreakPoint
        //step into
        //step over
        assertThat(femaleRadioButton.isSelected())
            .isFalse()
        assertThat(maleRadioButton.isSelected())
            .isFalse()

        maleRadioButton.click()
        assertThat(maleRadioButton.isSelected())
                .isTrue()
        femaleRadioButton.click()
        assertThat(maleRadioButton.isSelected())
                .isFalse()
        assertThat(femaleRadioButton.isSelected())
                .isTrue()
    }
    @Test(enabled = false)
    void TestNumberOfRadioButton(){
        def xpath='//input[@name="sex" and @type="radio"]'
        def sexItems = driver.findElements(By.xpath(xpath))
        assertThat(sexItems)
            .as("List of sex items")
            .isNotNull()
            .hasSize(3)
    }
    @Test(enabled = false)
    void testDayDropdownList(){
        //def expectedTexts = getExpectedText()
        //print(expectedTexts)
        //return

        def dayDropdownList = driver.findElement(By.id('day'))
        def select = new Select(dayDropdownList)
        def options = select.getOptions()
        def actualTexts = getActualText(options)

        assertThat(options)
            .as('Day dropdown list')
            .isNotNull()
            .hasSize(32)
        assertThat(actualTexts)
            .as('list of item text')
            .contains('Ngày','1','2','31')

        assertThat(select.firstSelectedOption.text)
            .as('selected text')
            .isEqualTo('Ngày')

    }

    @Test
    void testListText(){

        def dayDropdownList = driver.findElement(By.id('day'))
        def select = new Select(dayDropdownList)
        def options = select.getOptions()
        options.each{
            println it.text
        }
        for(def option : options){
            println option.text
        }
        for(def i=0;i<options.size();i++){
            println options[i].text
        }

    }

    //List
    //Closure
    //Range
    //for, foreach, reach




    List<String> getActualText(Select select){
        def result = []
        select.getOptions().each{
            result.add(it.text)
        }
        return result
    }




    def getExpectedText(){
        def result = ['Ngày'] //List
        //Range
        (1..31).each { //Closure
            result.add(it.toString())
        }
        return result
    }
}

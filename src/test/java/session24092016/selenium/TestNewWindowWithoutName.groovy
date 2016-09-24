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
class TestNewWindowWithoutName extends TestBase{

    @BeforeClass
    void BeforeClass() {
        BaseUrl = 'http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open5'

    }
    @Test(enabled = false)
    void testWindowSize(){

        //assert that there is only one window
        def handles = driver.getWindowHandles()
        assertThat(handles.size())
            .as("Number of windows")
            .isEqualTo(1)

        Keywords.clickButtonThroughFrames driver,'Try it'
        //assert that there is a new window opened!
        assertThat(driver.getWindowHandles().size())
                .as("Number of windows")
                .isEqualTo(2)
    }
    @Test(enabled = false)
    void testWindowSelectionByUrl(){

        Keywords.clickButtonThroughFrames driver,'Try it'
        def handles = driver.getWindowHandles()
        for(def handle : handles){
            driver
                .switchTo()
                .window(handle)

            if(driver.getCurrentUrl()=='http://www.w3schools.com/'){
                break
            }
        }


        assertThat(driver.getTitle())
                .as('Page title')
                .isEqualTo('W3Schools Online Web Tutorials')

    }
    @Test
    void testWindowSelectionWith3Windows(){

        def final popup3 = 'http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open3'
        Keywords.clickButtonThroughFrames driver,'Try it'
        Keywords.selectWindowByUrl driver,'http://www.w3schools.com'
        assertThat(driver.getTitle())
                .as('Page title')
                .isEqualTo('W3Schools Online Web Tutorials')

        driver.get popup3
        Keywords.clickButtonThroughFrames driver,'Try it'

        def handles = driver.getWindowHandles()
        println "Number of windows: #${handles.size()}"
        Keywords.selectWindowByUrl driver,popup3
        def bodyElement = driver.findElement(By.tagName('body'))

        //verification
        assertThat(bodyElement.getText())
                .as('Body content')
                .contains(' I am 200px wide and 100px tall')

        Thread.sleep(10000)
    }

}

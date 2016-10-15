package session15102016.selenium

import common.TestBase
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by nhientruong on 10/15/2016.
 */
class TestDragDrop extends TestBase{
    @BeforeClass
    void BeforeClass() {
        BaseUrl = 'http://www.w3schools.com/html/html5_draganddrop.asp'
    }

    @Test
    void DragDropTest(){
        //Identify the image.

        def logoImageBy = By.id('drag1')
        def div1 = driver.findElement(By.id('div1'))
        def div2 = driver.findElement(By.id('div2'))
        //Pre-condition
        //1. the div1 contains the image.
        def logoImage = div1.findElement(logoImageBy)
        assertThat(logoImage)
            .as('Logo image')
            .isNotNull()
        //2. the div2 contains no image.
        def images = div2.findElements(By.tagName('img'))
        assertThat(images)
            .as("child images")
            .isNullOrEmpty()

        //Actions
        //Todo: known problem on firefox

        //2. drag and drop the image to the div 2.
        // Verification
        def actions = new Actions(driver)
                .moveToElement(logoImage)
            .clickAndHold(logoImage)
            .moveToElement(div2)
            .release(div2)
//            .dragAndDrop(logoImage,div2)
            .build()
            .perform()
        //1. div 2 contains the image
        //2. div 1 contains no image.



    }
}

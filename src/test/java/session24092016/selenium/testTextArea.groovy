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
class testTextArea extends TestBase{

    @BeforeClass
    void BeforeClass() {
        BaseUrl = 'http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_textarea'

    }
    @Test(enabled = false)
    void testContent(){
        def textArea = driver.findElement(By.id('textareaCode'))
        println textArea.getText()
        assertThat(textArea.getText())
            .as('area\'s content')
            .contains('<html>\n<body>')
    }
    @Test(enabled = false)
    void testNumberOfLines(){
        def textArea = driver.findElement(By.id('textareaCode'))
        def text = textArea.getText()
        def numberOfLines = text.count("\n")
        assertThat(numberOfLines)
                .as('number of lines')
                .isEqualTo(9)
    }
    @Test
    void testSpecificLineText(){
        def textArea = driver.findElement(By.id('textareaCode'))
        def text = textArea.getText()
        def textArray = text.split("\n")
        assertThat(textArray[2])
                .as('Line#3\'s content')
                .contains('<body>')
    }
}

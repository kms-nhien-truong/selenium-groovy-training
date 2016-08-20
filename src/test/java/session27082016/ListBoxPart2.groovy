package session27082016

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat
import static org.fest.assertions.api.Assertions.entry

/**
 * Created by nhientruong on 8/20/2016.
 */
class ListBoxPart2 extends TestBase {

    @BeforeClass
    void BeforeClass(){
        BaseUrl="file:///D:/08_YSV/aug-class/src/htmlsample/listbox.html"
    }


    @Test(enabled = false)
    void Test1(){
        //By.xpath('//select'
        def listElement = driver.findElement(By.tagName('select'))
        def select = new Select(listElement)
        def selectedTexts = GetSelectedTexts(select)

        assertThat(select.isMultiple())
        assertThat(selectedTexts)
            .as('Selected option')
            .containsExactly('Nam','Hoa')
            //.hasSize(2)
            //.contains('Hoa', 'Nam')
    }

    @Test
    void TestMultiSelect(){
        try{
            def listElement = driver.findElement(By.tagName('selects'))
            def select = new Select(listElement)
            select.deselectAll()
            select.selectByVisibleText("Dai")
            select.selectByVisibleText("Linh")
            def selectedTexts = GetSelectedTexts(select)
            assertThat(selectedTexts)
                    .as('Selected option')
                    .containsExactly('Linh','Dai')

            Thread.sleep(3000)
        }
        catch (Exception ex ){
            println "The listbox is not found!"
            println ex.getMessage()
        }


    }

    List<String> GetSelectedTexts(Select select){
        def options = select.getAllSelectedOptions()
        def result = []
        //ArrayList<String> result = new ArrayList<String>();
        options.each{
            result.add it.getText()
        }
        return result

    }
}

package session27082016

import org.openqa.selenium.By
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat

/**
 * Created by nhientruong on 8/20/2016.
 */
class TestTable extends TestBase {
    @BeforeClass
    void BeforeClass() {
        BaseUrl = TestBase.LOCAL_ROOT_FOLDER + 'table.html'
    }




    @Test(enabled = false)
    void TestResult1() {
        //assert that Hoa's result is 9.5
        def resultTable = driver.findElement(By.xpath('//table[1]'))
        def rows = resultTable.findElements(By.tagName('tr'))

        for (def row : rows) {
            def cells = row.findElements(By.tagName('td'))
            if (cells.size() >= 3) {
                def name = cells[1].getText()
                println 'Verifying...' + name
                if (name == 'Hoa') {
                    def result = cells[2].getText()
                    assertThat(result)
                            .as("Exam's result")
                            .isEqualTo("9.5")
                    break //exit the for statement
                }
            }

        }

    }

    @Test
    void Test2(){
        assertResult('Hoa','9.5')
    }

    void assertResult(name, result){

        //Xpath1: //table[1]//tr[td[text()='Hoa']]/td[3]
        def xpath='//table[1]//td[text()="'+name+'"]/following-sibling::td'
        def resultCell = driver.findElement(By.xpath(xpath))

        assertThat(resultCell)
                .as('Result cell')
                .isNotNull()

        assertThat(resultCell.getText())
                .as('result text')
                .isEqualTo(result)

    }
}


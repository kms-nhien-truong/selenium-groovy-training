package session22102016.selenium

import org.jetbrains.annotations.Nullable
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition

/**
 * Created by nhientruong on 10/22/2016.
 */
class ValuePresent implements ExpectedCondition<Boolean> {

    def _by
    def _expectedValue
    //Constructor
    ValuePresent(by, expectedValue){
        _by = by
        _expectedValue = expectedValue
    }
    Boolean apply(@Nullable WebDriver webDriver) {
        def input =webDriver.findElement(_by)
        def value =input.getAttribute('value');
        return value==_expectedValue
    }
}

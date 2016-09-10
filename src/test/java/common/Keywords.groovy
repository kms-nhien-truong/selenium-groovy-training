package common

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

/**
 * Created by nhientruong on 9/10/2016.
 */
class Keywords {
    static def clickButton(driver, buttonCaption){
        //Interpolation

        def by =By.xpath("//button[text()='$buttonCaption']")
        def clickMeButton = driver.findElement(by)
        clickMeButton.click()
    }

    static def findElement(WebDriver driver, By by){
        try{
            return driver.findElement(by)
        }
        catch (Exception ex){
           return null
        }
    }
    static def clickButtonThroughFrames(WebDriver driver, buttonCaption){
        def buttonBy =By.xpath("//button[text()='$buttonCaption']")
        def button = findElement(driver,buttonBy)
        if(button!=null){
            button = driver.findElement(buttonBy)
            button.click()
            return true
        }
        else
        {
            //find all frames
            def frames = driver.findElements(buttonBy.tagName('iframe'))
            if(frames == null || frames.size() <=0)
                return false
            for(def frame : frames){
                driver.switchTo().frame(frame)
                button = findElement(driver,buttonBy)
                if(button!=null){
                    button.click()
                    return true
                }
                driver.switchTo().defaultContent()
//                else{
//                    driver.switchTo().defaultContent()
//                }
            }
        }



    }
}

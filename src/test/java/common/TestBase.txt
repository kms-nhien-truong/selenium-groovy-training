package common

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod

/**
 * Created by nhientruong on 8/20/2016.
 */
class TestBase {

    //Access Modifier
    protected String BaseUrl = "https://facebook.com"
    protected WebDriver driver =null
    protected static final String  LOCAL_ROOT_FOLDER="file:///D:/08_YSV/aug-class/src/htmlsample/"

    @BeforeMethod(enabled = true)
    public void BeforeMethod(){
        driver = new FirefoxDriver()
        driver.get(BaseUrl)
    }


    @AfterMethod(enabled = true)
    public void AfterMethod(){
        if(driver!=null)
            driver.quit()
    }
}

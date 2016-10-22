package common

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.os.WindowsUtils
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

import java.util.concurrent.TimeUnit

/**
 * Created by nhientruong on 10/15/2016.
 */
class TestBase {

    //Access Modifier
    protected String BaseUrl = "https://facebook.com"
    protected WebDriver driver =null
    protected static final String  LOCAL_ROOT_FOLDER="file:///D:/08_YSV/aug-class/src/htmlsample/"

    @BeforeMethod(enabled = true)
    public void BeforeMethod(){
        //WindowsUtils.killByName('firefox.exe')
        driver = new FirefoxDriver()
//        driver
//                .manage()
//                .timeouts()
//                .implicitlyWait(10,TimeUnit.SECONDS)
        driver.get(BaseUrl)
    }



    @AfterMethod(enabled = true)
    public void AfterMethod(){
        if(driver!=null)
            driver.quit()
    }
}

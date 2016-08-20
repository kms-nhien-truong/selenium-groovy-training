package session06082016

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import static org.fest.assertions.api.Assertions.assertThat


/**
 * Created by USER on 06/08/2016.
 */
class FaceBookTest {

    final String FACEBOOK_URL ="https://facebook.com"

    WebDriver driver
    @BeforeMethod
    void beforeMethod(){
        driver = new FirefoxDriver()
        driver.get(FACEBOOK_URL)
    }

    @AfterMethod
    void afterMethod(){
        driver.quit()
    }

    @Test
    void testHomePage(){

        def realTitle = driver.getTitle()
        def expectedTitle ="Đăng nhập, Đăng ký hoặc Tìm hiểu thêm."
        driver.quit()
        assertThat(realTitle)
            .as("Facebook Homepage's title")
            .contains(expectedTitle)

        //S.O.L.I.D
    }

    @Test
    void testLogin(){
        //elements
        def txtUsername = driver.findElement(By.id("email"))
        def txtPassword = driver.findElement(By.id("pass"))
        def btnLogin = driver.findElement(By.id("u_0_m"))

        //actions
        txtUsername.sendKeys "tmsnhien@gmail.com"
        txtPassword.sendKeys "fakepassword"
        btnLogin.click()
    }
}

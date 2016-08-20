package session06082016

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * Created by USER on 06/08/2016.
 */
class OpenFacebook {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver()
        driver.get("https://facebook.com")
        def realTitle = driver.getTitle()
        driver.quit()
        assert realTitle.equals("Chào mừng bạn đến với Facebook - Đăng nhập, Đăng ký hoặc Tìm hiểu thêm")


    }
}
//Entry Point

//OpenFaceBook url
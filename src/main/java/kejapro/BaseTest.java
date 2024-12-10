package kejapro;

import kejapro.helpers.SeleniumHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void loginTest() {
        driver.get("http://127.0.0.1:8000");

        SeleniumHelpers helpers = new SeleniumHelpers(driver);
        helpers.waitForSeconds(2);
        helpers.typeTextById("username", "muilipato");
        helpers.waitForSeconds(1);
        helpers.typeTextById("password", "Kabarak8074");
        helpers.waitForSeconds(1);
        helpers.clickByCss("button[type='submit'].btn");
        helpers.waitForSeconds(2);
    }

    @Test(priority = 2)
    public void logoutTest() {
        //loginTest();
        SeleniumHelpers helpers = new SeleniumHelpers(driver);
        helpers.waitForSeconds(2);
        helpers.clickById("dropdownUser1");
        helpers.waitForSeconds(1);
        helpers.clickByCss("span.ms-1.d-none.d-sm-inline\n");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
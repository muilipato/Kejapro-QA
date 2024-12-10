package kejapro.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHelpers {
    private WebDriver driver;

    public SeleniumHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public void typeTextById(String id, String text) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(text);
    }

    public void clickByCss(String cssSelector) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.click();
    }

    public void clickById(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.click();
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getAttribute(By locator, String attribute) {
        return driver.findElement(locator).getAttribute(attribute);
    }

    public String getCssValue(By locator, String property) {
        return driver.findElement(locator).getCssValue(property);
    }
}


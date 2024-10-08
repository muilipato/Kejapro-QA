package org.example;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        loginTest(driver);
        assertDashboardHighlight(driver);
        assertBuildingsCard(driver);
        logoutTest(driver);
        driver.quit();

    }
    public static void loginTest(WebDriver driver) {
        driver.get("http://127.0.0.1:8000");
        try {
            Thread.sleep(1000);

            // Locate the username field and enter a value
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("muilipato");

            Thread.sleep(1000);

            // Locate the password field and enter a value
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Kabarak8074");
            Thread.sleep(1000);

            // Locate the sign-in button and click it
            WebElement signInButton = driver.findElement(By.cssSelector(("button[type='submit'].btn")));
            signInButton.click();
            Thread.sleep(1000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //I'll add assertions later

    }
    public static void assertDashboardHighlight(WebDriver driver) {
        try {
            // Wait for the dashboard to load
            Thread.sleep(2000);

            // Locate the Dashboard menu item in the sidebar
            WebElement dashboardMenu = driver.findElement(By.cssSelector("a.nav-link.active[aria-current='page']"));

            // Assert that the Dashboard menu item has the correct background color and class
            String backgroundColor = dashboardMenu.getCssValue("background-color");
            boolean isActive = dashboardMenu.getAttribute("class").contains("active");

            if (isActive && backgroundColor.equals("rgba(255, 255, 255, 1)")) {
                System.out.println("Test passed: Dashboard menu is highlighted as expected.");
            } else {
                System.out.println("Test failed: Dashboard menu is not highlighted correctly.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Method to assert that the Buildings card is displayed correctly
    public static void assertBuildingsCard(WebDriver driver) {
        try {
            // Wait for the card to load
            Thread.sleep(2000);

            // Locate the card by its class
            WebElement card = driver.findElement(By.cssSelector("div.card-body.d-flex.justify-content-between.align-items-center"));

            // Assert that the card is displayed
            if (card.isDisplayed()) {
                // Locate the title (number of buildings) and the text (Buildings)
                WebElement cardTitle = card.findElement(By.cssSelector("h3.card-title"));
                WebElement cardText = card.findElement(By.cssSelector("p.card-text"));

                // Assert the card title and text
                String cardTitleText = cardTitle.getText();
                String cardTextValue = cardText.getText();

                if (cardTitleText.equals("0") && cardTextValue.equals("Buildings")) {
                    System.out.println("Test passed: Card displays '0 Buildings' correctly.");
                } else {
                    System.out.println("Test failed: Card content is incorrect. Found: " + cardTitleText + " " + cardTextValue);
                }
            } else {
                System.out.println("Test failed: Card is not displayed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void logoutTest(WebDriver driver) {
        try {
            // Wait for 2 seconds to allow the page to fully load
            Thread.sleep(2000);

            // Locate the username <span> and click it to open the dropdown
            WebElement userName = driver.findElement(By.id("dropdownUser1"));
            userName.click();

            Thread.sleep(1000);  // Wait for 1 second to see the dropdown

            // Locate the logout option and click it
            WebElement logoutButton = driver.findElement(By.cssSelector("a.dropdown-item-logout"));
            logoutButton.click();

            Thread.sleep(2000);  // Wait for 2 seconds to observe the logout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void  clickDashboard(WebDriver driver) {
        driver.findElement(By.cssSelector("a.dropdown-toggle")).click();
        driver.quit();
    }
}



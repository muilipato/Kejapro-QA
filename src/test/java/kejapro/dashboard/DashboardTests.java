package kejapro;

import kejapro.helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTests extends BaseTest {

    private SeleniumHelpers helpers;

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        helpers = new SeleniumHelpers(driver);
        loginTest(); // Log in before each test
    }

    @AfterMethod
    @Override
    public void teardown() {
        logoutTest(); // Log out after each test
        super.teardown();
    }

    @Test
    public void testNavigateToDashboard() {
        String dashboardMenuCss = "span.d-none.d-sm-inline";
        helpers.clickByCss(dashboardMenuCss);
        helpers.waitForSeconds(1);
        String excpectedUrl = "http://127.0.0.1:8000/Dashboard";
        helpers.waitForSeconds(2);
        Assert.assertEquals(driver.getCurrentUrl(), excpectedUrl, "Failed to navigate to the Dashboard page");
    }
    @Test
    public void testDashboardHighlight() {

        // Locate the dashboard menu
        testNavigateToDashboard();
        String dahsboardSelector = "a.nav-link.align-middle.px-3.py-2.text-dark.bg-white.text-decoration-none.d-flex.align-items-center.gap-2.active[href='/Dashboard']\n";
        Assert.assertTrue(helpers.isElementDisplayed(By.cssSelector(dahsboardSelector)),
                "Dashboard menu is not displayed.");

        String backgroundColor = helpers.getCssValue(By.cssSelector(dahsboardSelector), "background-color");
        boolean isActive = helpers.getAttribute(By.cssSelector(dahsboardSelector), "class").contains("active");

        Assert.assertTrue(isActive, "Dashboard menu is not marked as active.");
        Assert.assertEquals(backgroundColor, "rgba(255, 255, 255, 1)",
                "Dashboard menu background color is incorrect.");
    }

    @Test
    public void testBuildingsCard() {
        // Locate the buildings card
        String cardCss = "div.card-body.d-flex.justify-content-between.align-items-center";
        Assert.assertTrue(helpers.isElementDisplayed(By.cssSelector(cardCss)),
                "Buildings card is not displayed.");

        String cardTitleText = helpers.getText(By.cssSelector(cardCss + " h3.card-title"));
        String cardTextValue = helpers.getText(By.cssSelector(cardCss + " p.card-text"));

        Assert.assertEquals(cardTitleText, "1", "Card title does not display '1'.");
        Assert.assertEquals(cardTextValue, "Buildings", "Card text does not display 'Buildings'.");
    }
    public void checKout(){

    }
}

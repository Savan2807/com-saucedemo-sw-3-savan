package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 1. userSholdLoginSuccessfullyWithValid
 * <p>
 * Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * <p>
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * <p>
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 * on page
 */
public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //username element
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys("standard_user");

        //Password element
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("secret_sauce");

        //Login element
        WebElement LoginField = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginField.click();

        //actual result
        WebElement actualResult = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMsg = actualResult.getText();
        System.out.println(actualMsg);

        //expectedResult
        String expectedMsg = "Products";

        //match actual and expected result
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        //Enter username element
        sendTextToElement(By.xpath("//input[@id='user-name']"),"problem_user");


        //Password element
        sendTextToElement(By.id("password"),"secret_sauce");

        //Login element
        clickOnElement(By.xpath("//input[@id='login-button']"));


        // aseration
        int expectedresult = 6;
        Thread.sleep(2000);
        List<WebElement> listofitems = listOfWebElementsList(By.className("inventory_item"));
        int actualresult = listofitems.size();
        Assert.assertEquals(actualresult, expectedresult);
    }

    @After
    //Here After method for close the browser
    public void teardown() {
        closeBrowser();

    }
}
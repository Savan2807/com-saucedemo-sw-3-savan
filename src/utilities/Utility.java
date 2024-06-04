package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Savan kakadiya
 */
public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    public void clearText(By by) {
        WebElement element = driver.findElement(by);
        element.clear();
    }
    public List<WebElement> listOfWebElementsList(By by){
        return  driver.findElements(by);
    }

    /**
     * This method will send text to Element
     */
    public void sendTextToElement(By by) {
        driver.findElement(by).clear();
    }
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //************************* Alert Methods *****************************************************
    //Total 5 method Need to create
    //1. switchToAlert
    public void switchToAlert() {
        Alert alert = driver.switchTo().alert(); //Create alert object reference and switch to alert
    }

    //2. acceptAlert
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert(); //Create alert object reference and switch to alert
        alert.accept();
    }

    //3. dismissAlert
    public void dismissAlert() {
        Alert alert = driver.switchTo().alert(); //Create alert object reference and switch to alert
        alert.dismiss();
    }

    //4. sendTextToAlert
    public void sendTextToAlert(String value) {
        Alert alert = driver.switchTo().alert();//Creating alert object reference and switch to alert
        alert.sendKeys(value);
        alert.accept();
    }

    //5. getTextFromAlert
    public String getTextFromAlert(String value) {
        Alert alert = driver.switchTo().alert();//Creating alert object reference and switch to alert
        return alert.getText();
    }

    //*************************** Select Class Methods ***************************************//
    //1. selectByValueFromDropDown(By by, String value)
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select class
        Select select = new Select(dropDown);
        // Select by visible Text
        select.selectByValue(value);
    }

    //2. selectByIndexFromDropDown(By by, int index)
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }


    //3. selectByVisibleTextFromDropDown(By by, String text)
    public void SelectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    //*************************** Action Methods ***************************************//
    public void mouseHoverOnElement(By by){
        WebElement element1= driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).click().build().perform();
    }
    //*************************** Select Day date and month ***************************************//
    public void selectDayMonthAndYear(By by, String year, String month, String date, By byMonthYear, By byNextYear, By byDate) {
        clickOnElement(by); // Open the calendar
        while (true) {
            String monthAndYear = getTextFromElement(byMonthYear);
            System.out.println(monthAndYear);
            String[] a = monthAndYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equals(month) && yer.equals(year)) {
                break;
            } else {
                clickOnElement(byNextYear);
            }
        }
        // Select the Date
        List<WebElement> allDates = driver.findElements(byDate);
        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;

            }
        }
    }
    public List<WebElement> getMultipleElements(By by) {
        return driver.findElements(by);
    }
}
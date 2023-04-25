package utilities;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Utility extends BaseTest {
   public static String baseUrl = " https://magento.softwaretestingboard.com/";

   @Before
   public void setUp(){
       openBrowser(baseUrl);
   }
    public void sendTextToTheElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public void clearText(By by){
        driver.findElement(by).clear();
    }
    public void mouseHoverOnTheElement(By by){
        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void clickOnTheElement(By by){
        driver.findElement(by).click();
    }

    public void dropDownOption(By by, String preferance){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(preferance);
    }

    public void compareElements(String text, ArrayList expectedArray, ArrayList actualArray ){
        Assert.assertEquals(text,expectedArray,actualArray);
    }

    public String getTextFromTheElement(By by){
        return driver.findElement(by).getText();
    }
    public void compareText(String text, String expectedText, By by){
        Assert.assertEquals(text,expectedText,getTextFromTheElement(by) );
    }




    @After
    public void tearDown(){
       //closeBrowser();
    }
}

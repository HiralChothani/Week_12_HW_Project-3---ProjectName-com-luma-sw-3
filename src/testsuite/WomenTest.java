package testsuite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    @Test
    public void verifyTheSortByProductNameFilter() {
        // Mouse Hover on Women Menu
        mouseHoverOnTheElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        // Mouse Hover on Tops
        mouseHoverOnTheElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        // Click on Jackets
        clickOnTheElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        // Select Sort By filter “Product Name”
        dropDownOption(By.xpath("//select[@id='sorter']"), "name");
        // Verify the products name display in alphabetical order
        List<WebElement> actualProductName = driver.findElements(By.xpath("//div[@class='product details product-item-details']//strong[@class='product name product-item-name']"));
        ArrayList<String> actualProductSequence = new ArrayList<String>();
        for (WebElement element : actualProductName) {
            actualProductSequence.add(element.getText());
        }

        List<WebElement> expectedProductName = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        ArrayList<String> expectedProductSequence = new ArrayList<String>();
        for (WebElement element : expectedProductName) {
            expectedProductSequence.add(element.getText());
        }
        Collections.sort(expectedProductSequence);

        compareElements("Products are not in alphabetical order", expectedProductSequence, actualProductSequence);
        //Assert.assertEquals("Products are not in alphabetical order", expectedProductSequence, actualProductSequence);

    }


    @Test
    public void verifyTheSortByPriceFilter() {
        // Mouse Hover on Women Menu
        mouseHoverOnTheElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        // Mouse Hover on Tops
        mouseHoverOnTheElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        // Click on Jackets
        clickOnTheElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        // Select Sort By filter “Price”
        dropDownOption(By.xpath("//select[@id='sorter']"), "price");

        //Verify the products price display in Low to High
        List<WebElement> actualPriceOfProduct = driver.findElements(By.xpath("//span[@class='normal-price']//span[@class='price-wrapper ']"));
        ArrayList<String> actualPriceSequence = new ArrayList<String>();
        for (WebElement element : actualPriceOfProduct) {
            actualPriceSequence.add(element.getText());
        }

        List<WebElement> expectedPriceOfProduct = driver.findElements(By.cssSelector("div[class='price-box price-final_price'] span[class='price']"));
        ArrayList<String> expectedPriceSequence = new ArrayList<String>();
        for (WebElement element : expectedPriceOfProduct) {
            expectedPriceSequence.add(element.getText());
        }
        Collections.sort(expectedPriceSequence);

        compareElements("Product Price is not displayed in Low to High ", expectedPriceSequence, actualPriceSequence);
        //Assert.assertEquals("Product Price is not displayed in Low to High ", expectedPriceSequence, actualPriceSequence);
    }
}

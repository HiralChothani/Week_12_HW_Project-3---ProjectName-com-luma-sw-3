package testsuite;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Gear Menu
        mouseHoverOnTheElement(By.xpath("//a[@role='menuitem']//span[contains(text(),'Gear')]"));

        // Click on Bags
        clickOnTheElement(By.xpath("//span[contains(text(),'Bags')]/.."));

        // Click on Product Name ‘Overnight Duffle’
        clickOnTheElement(By.xpath("//a[contains(text(),'Overnight Duffle')]/.."));

        // Verify the text ‘Overnight Duffle’
        compareText("Text not matched", "Overnight Duffle", By.xpath("//span[contains(text(),'Overnight Duffle')]"));

        // Change Qty 3
        clickOnTheElement(By.xpath("//input[@id='qty']"));
        clearText(By.xpath("//input[@id='qty']"));
        sendTextToTheElement(By.xpath("//input[@id='qty']"), "3");

        // Click on ‘Add to Cart’ Button.
        clickOnTheElement(By.xpath("//button[@class='action primary tocart']//span[contains(text(),'Add to Cart')]"));

        // Verify the text‘You added Overnight Duffle to your shopping cart.’
        compareText("Text not matched", "You added Overnight Duffle to your shopping cart.", By.xpath("//div[@class='messages']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        // Click on ‘shopping cart’ Link into message
        clickOnTheElement(By.linkText("shopping cart"));

        // Verify the product name ‘Overnight Duffle’
        compareText("Text not matched", "Overnight Duffle", By.linkText("Overnight Duffle"));

        // Verify the Qty is ‘3’
        String actualQuantity = driver.findElement(By.xpath("//input[@class='input-text qty']")).getAttribute("value");
        String expectedQuantity = "3";
        Assert.assertEquals("Qty not matched", expectedQuantity, actualQuantity );

        //  Verify the product price ‘$135.00’
        compareText("Price not matched", "$135.00", By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));

        // Change Qty to ‘5’
        clickOnTheElement(By.xpath("//input[@class='input-text qty']"));
        clearText(By.xpath("//input[@class='input-text qty']"));
        sendTextToTheElement(By.xpath("//input[@class='input-text qty']"), "5");

        //  Click on ‘Update Shopping Cart’ button
        clickOnTheElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        // Verify the product price ‘$225.00’
        Thread.sleep(1000);
        compareText("Price not matched", "$225.00", By.xpath("//td[@class='col subtotal']//span[@class='cart-price']"));
    }
}

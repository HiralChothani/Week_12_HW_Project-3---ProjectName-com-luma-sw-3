package testsuite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.Utility;

public class MenTest extends Utility {
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //Mouse Hover on Men Menu
        //mouseHoverOnTheElement(By.xpath("//span[contains(text(),'Men')]/parent::a"));
        mouseHoverOnTheElement(By.xpath("//span[contains(text(),'Men')]//preceding-sibling::span"));
        // Mouse Hover on Bottoms
        mouseHoverOnTheElement(By.xpath("//a[@id='ui-id-18']"));
        // Click on Pants
        clickOnTheElement(By.xpath("//a[@id='ui-id-23']"));
        // Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverOnTheElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnTheElement(By.id("option-label-size-143-item-175"));
        // Mouse Hover on colour Black and click on colour Black.
        mouseHoverOnTheElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        clickOnTheElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        // Mouse Hover on product name‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button
        mouseHoverOnTheElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnTheElement(RelativeLocator.with(By.tagName("SPAN")).below(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']")));
       // Verify the text‘You added Cronus Yoga Pant to your shopping cart.’
        compareText("Text not matched","You added Cronus Yoga Pant to your shopping cart.",By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
          // Click on ‘shopping cart’ Link into message
        clickOnTheElement(By.linkText("shopping cart"));
        // Verify the text ‘Shopping Cart.’
        compareText("Text not matched","Shopping Cart",By.xpath("//span[@data-ui-id='page-title-wrapper']"));
        // Verify the product name ‘Cronus Yoga Pant’
        compareText("name not matched","Cronus Yoga Pant",By.xpath("//strong[@class='product-item-name']"));
        // Verify the product size ‘32’
        compareText("Size not matched","32",By.xpath("//dd[contains(text(),'32')]"));
       // Verify the product colour ‘Black’
        compareText("colour not matched", "Black", By.xpath("//dd[contains(text(),'Black')]"));
    }

}

package saksfifth.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import saksfifth.framework.base.PageBase;

import java.util.List;

/**
 * Created by zakirkhan on 6/2/17.
 */

public class ProductArrayPage extends PageBase {

    public ProductArrayPage() {
        super.closeTriggerPopup();
    }

    public void clickFirstItem(){

        List<WebElement> productArray = driver.findElements(By.xpath("//div[@id='product-container']/div[contains(@id, 'product-')]"));
        System.out.println(productArray.size());
        WebElement productDesingItem = productArray.get(0).findElement(By.xpath(".//span[@class='product-designer-name']"));
        highlightElement(productDesingItem);

        String expectedProductDesignName = productDesingItem.getText();
        productArray.get(0).click();

        System.setProperty("ProductNameText", expectedProductDesignName);

    }

}

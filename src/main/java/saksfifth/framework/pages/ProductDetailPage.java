package saksfifth.framework.pages;

import com.paxovision.execution.reporter.service.ReporterService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import saksfifth.framework.base.PageBase;

import java.util.List;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class ProductDetailPage extends PageBase {

    protected ReporterService reporter = ReporterService.reporter();


    @FindBy(css = ".product-variant-attribute-value--swatch")
    protected List<WebElement> COLOR_SWATCH;

    @FindBy(xpath = "//div[@class='product-size-options']//ul[@class='product-variant-attribute-values']/li")
    protected List<WebElement> PRODUCT_SIZE;

    @FindBy(xpath = "//button[contains(@class, 'product__add-to-bag-button')]")
    protected WebElement ADD_TO_BAG_BUTTON;

    @FindBy(css = ".drawer.drawer--right")
    protected WebElement DRAWER_RIGHT;

    @FindBy(xpath = "//a[@class='hbc-button hbc-button--block hbc-button--primary']")
    protected WebElement  MINI_BAG_CHECKOUT_BUTTON;


    public ProductDetailPage() {

        PageFactory.initElements(driver, this);
        super.closeTriggerPopup();
    }

    public WebElement getColorSwatch() {
        List<WebElement> COLOR_SWATCH = driver.findElements(By.cssSelector(".product-variant-attribute-value--swatch"));

        WebElement COLOR = null;

        if (COLOR_SWATCH.size() > 0) {
            String availabeColor;
            for (WebElement color : COLOR_SWATCH) {
                availabeColor = color.getAttribute("class");
                System.out.println(availabeColor);
                if (!availabeColor.contains("product-variant-attribute-value--unavailable")) {
                    COLOR = color;
                    System.out.println("Found the color swatch");

                    break;
                } else {
                    System.out.println("NO color");
                }
            }
        }else {
            System.out.println("There is no Color Swatch");
        }
        return COLOR;
    }

    public WebElement getSize(){

        List<WebElement> PRODUCT_SIZE = driver.findElements(By.xpath("//div[@class='product-size-options']//ul[@class='product-variant-attribute-values']/li"));

        WebElement SIZE = null;

        if(PRODUCT_SIZE.size()>0) {
            String availableSize;

            for (WebElement size : PRODUCT_SIZE) {
                availableSize = size.getAttribute("class");
                System.out.println(availableSize);
                if (!availableSize.contains("product-variant-attribute-value--unavailable")) {
                    SIZE = size;
                    //ADD_TO_BAG_BUTTON.click();
                    System.out.println("Found Size");
                    break;
                } else {
                    System.out.println("No Size Available");
                }
            }
        }
        else {
            System.out.println("size is not Applicable ");

        }
        return SIZE;
    }

    public WebElement addToButton(){
        return ADD_TO_BAG_BUTTON;
    }


    /**
     * Adds product in the bag.
     * getColorSwatch() returns color Webelement
     * getSi
     * */
    public void addToBag(){
        if (getColorSwatch() != null){
            reporter.logInfo("Color Swatch", "Available Color Clicked");
            getColorSwatch().click();
        }

        if(getSize()!=null){
            reporter.logInfo("Size", "Available Size Clicked");
            getSize().click();
        }

        reporter.logInfo("Bag Button", "Add to bag button clicked");
        addToButton().click();
        delayFor(2000);
    }

    public void addToShoppingBag(){
        WebElement MINI_BAG_CHECKOUT_BUTTON = driver.findElement(By.xpath("//a[@class='hbc-button hbc-button--block hbc-button--primary']"));

        reporter.logInfo("Mini Bag Checkout Button", "Mini Bag Checkout Button clicked");
        MINI_BAG_CHECKOUT_BUTTON.click();
    }

    /****************************  Start  Validation  Code   **************************/

    public void validateFirstItem(){

        WebElement productOverview  = driver.findElement(By.xpath("//h2[@class='product-overview__brand']/a"));
        String actualResult = productOverview.getText();
        String expectedResult = System.getProperty("ProductNameText");
        Assert.assertEquals( expectedResult,actualResult );
    }

    public void validateShoppingBag(){
        String miniBagHeaderText  = driver.findElement(By.xpath("//div[@class='mini-bag-content__header']")).getText().trim();

        String actual = miniBagHeaderText.substring(0,12).trim();
        String expected = "Shopping Bag".trim();
        System.out.println("SUBSTRING: "+ actual);


        reporter.logInfo("validateShoppingBag", "Validate the Sopping bag works");
        Assert.assertEquals(expected, actual);
    }

    /****************************  End  Validation  Code   **************************/
}


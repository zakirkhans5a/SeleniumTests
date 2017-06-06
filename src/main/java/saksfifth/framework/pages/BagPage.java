package saksfifth.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import saksfifth.framework.base.PageBase;
import saksfifth.framework.extendReport.ExtentManager;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class BagPage extends PageBase {

    private static ExtentManager extentManager = ExtentManager.getInstance();  //for extend report

    @FindBy(xpath = "//input[@id='jsBagZipCode']")
    protected WebElement ZIP_CODE_TEXTBOX;

    @FindBy(xpath = ".//select[@id='jsSelectShippingMethod']")
    protected WebElement SHIPPING_METHOD_DROPDOWN_BOX;

    @FindBy(xpath = ".//*[@id='jsLoginWrap']//h1[text()='Welcome']")
    protected WebElement SIGNIN_OVERLAY_HEADING;

    @FindBy(css = "#jsCheckoutRemediationGuestCheckout")
    protected WebElement SIGNIN_OVERLAY_CHECKOUT_BUTTON;

    @FindBy(css = "jsQuickCheckout")
    protected WebElement SIGNIN_AND_CHECKOUT_BUTTOM;

    @FindBy(xpath = ".//*[@id='jsLoginWrap']")
    protected WebElement LOGIN_OVERLAY;

   /* @FindBy(xpath = "//a[@id='jsStartCheckout']")
    protected WebElement BAG_CHECKOUT_BUTTON;
*/
   /* @FindBy(id = "jsCheckoutRemediationGuestCheckout")
    protected WebElement GUEST_CHECKOUT_BUTTON;*/




    public BagPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickCheckout(){
        delayFor(3000);
        ZIP_CODE_TEXTBOX.sendKeys("11040");

        //SHIPPING_METHOD_DROPDOWN_BOX.click();
        //TODO : Fix this code
       /*List<WebElement> dropdownList = SHIPPING_METHOD_DROPDOWN_BOX.findElements(By.tagName("option"));
        for (int i = 0; i < dropdownList.size(); i++){
            System.out.println(dropdownList.get(i).getText());
            if(dropdownList.get(i).getText().contentEquals("Saturday -  $35.00 (Est. Delivery N/A)")){
                dropdownList.get(i).click();
                break;
            }
        }*/

        Select shippingDropdown = new Select(SHIPPING_METHOD_DROPDOWN_BOX);
        shippingDropdown.selectByIndex(3);

        delayFor(1000);

        WebElement  BAG_CHECKOUT_BUTTON = driver.findElement(By.xpath(".//*[@id='jsStartCheckout']"));
        highlightElement(BAG_CHECKOUT_BUTTON);
        BAG_CHECKOUT_BUTTON.click();
        delayFor(1000);
        highlightElement(LOGIN_OVERLAY);




    }



    public void guestCheckout(){
        WebElement GUEST_CHECKOUT_BUTTON = driver.findElement(By.id("jsCheckoutRemediationGuestCheckout"));
        highlightElement(GUEST_CHECKOUT_BUTTON);
        GUEST_CHECKOUT_BUTTON.click();
        extentManager.log(GUEST_CHECKOUT_BUTTON.getText() + "Clicked");  // for extend report
    }

    public void varifyGuestCheckoutOverlay() {


        highlightElement(SIGNIN_OVERLAY_CHECKOUT_BUTTON);
        String actual = SIGNIN_OVERLAY_CHECKOUT_BUTTON.getText().trim();
        String expected = "Checkout as Guest".trim().toUpperCase();
        Assert.assertEquals(expected, actual);

    }


    public void varifySigninAndCheckoutOverlay(){
        highlightElement(SIGNIN_AND_CHECKOUT_BUTTOM);
        String actual = SIGNIN_AND_CHECKOUT_BUTTOM.getText().trim();
        String expected = "Sign In & Checkout".trim().toUpperCase();
        Assert.assertEquals(expected, actual);
    }



}


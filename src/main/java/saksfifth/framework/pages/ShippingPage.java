package saksfifth.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import saksfifth.framework.base.PageBase;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class ShippingPage extends PageBase {

    @FindBy(xpath = ".//select[@id='shipTitle']")
    WebElement titleDropdown;

    @FindBy(xpath = ".//*[@id='shipFirst']")
    WebElement firstNameTestbox;

    @FindBy(xpath = ".//*[@id='shipMI']")
    WebElement middleNameTextbox;

    @FindBy(id = "shipLast")
    WebElement lastNameTextbox;

    @FindBy(id = "shipCompany")
    WebElement companyNameTextbox;

    @FindBy(id = "shipAddress1")
    WebElement addressLIne1Textbox;

    @FindBy(id = "shipAddress2")
    WebElement addressLIne2Textbox;

    @FindBy(id = "shipCity")
    WebElement cityTextbox;

    @FindBy(id = "shipState")
    WebElement stateDropdown;

    @FindBy(id = "shipZip")
    WebElement zipCodeTextbox;

    @FindBy(id = "shipEmail")
    WebElement emailAddressTextbox;

    @FindBy(id = "shipPhone")
    WebElement phoneNumberTextbox;

    @FindBy(css = ".sfa-button.large.transactional")
    WebElement shippingContinueCheckoutButton;



    /*@FindBy(css = "#jsUseEntered")
    WebElement useAddressAsEnteredButton;*/



    public ShippingPage(){
        PageFactory.initElements(driver, this);
        super.closeTriggerPopup();
    }


    public void addShippingAddress(){

        selectOption(titleDropdown, "Mr.");
        firstNameTestbox.sendKeys("Logan");
        middleNameTextbox.sendKeys("S");
        lastNameTextbox.sendKeys("Phoenix");
        companyNameTextbox.sendKeys("MaizeKernels");
        addressLIne1Textbox.sendKeys("Hollywood Blvd");
        addressLIne2Textbox.sendKeys("at Vine St");
        cityTextbox.sendKeys("Los Angeles");
        selectOption(stateDropdown, "California");
        zipCodeTextbox.sendKeys("90028");
        emailAddressTextbox.sendKeys("logan123@usa.com");
        phoneNumberTextbox.sendKeys("4801232475");
        shippingContinueCheckoutButton.click();
        delayFor(2000);
        //WebElement addressVarificationPopup = driver.findElement(By.id("jsAddressVerificationLayer"));
        //WebElement useAddressAsEnteredButton = addressVarificationPopup.findElement(By.xpath(".//button[@id='jsUseEntered']"));
        WebElement useAddressAsEnteredButton = driver.findElement(By.xpath("//*[@id='jsUseEntered']"));
        useAddressAsEnteredButton.click();
        delayFor(3000);
    }

}



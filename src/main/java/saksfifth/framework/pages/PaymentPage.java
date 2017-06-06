package saksfifth.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import saksfifth.framework.base.PageBase;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class PaymentPage extends PageBase {

    @FindBy(id = "payCC")
    WebElement paymentTypeDropdown;

    @FindBy(id = "payCCNum")
    WebElement creditCardNumberTextbox;

    @FindBy(id = "payCCName")
    WebElement nameOnCardTextbox;

    @FindBy(id = "ccMonth")
    WebElement  monthDropdown;

    @FindBy(id = "ccYear")
    WebElement  yearDropdown;

    @FindBy(id = "payCCV")
    WebElement  securityCodeTextbox;

    @FindBy(id = "jsCompletePayment")
    WebElement  paynmentContinueCheckoutButton;




    public PaymentPage() {
        PageFactory.initElements(driver, this);
        super.closeTriggerPopup();
    }

    public void enterPayment(){

        selectOption(paymentTypeDropdown, "Visa");
        creditCardNumberTextbox.sendKeys("4400548734209814");
        nameOnCardTextbox.sendKeys("Professor Xeivior");
        selectOption(monthDropdown, "03");
        selectOption(yearDropdown, "2020");
        securityCodeTextbox.sendKeys("123");
        paynmentContinueCheckoutButton.click();

    }
}


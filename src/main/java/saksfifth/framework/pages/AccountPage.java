package saksfifth.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import saksfifth.framework.base.PageBase;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class AccountPage extends PageBase {

    @FindBy(xpath = ".//*[@id='toolbar']/li[1]/a/span")
    protected WebElement signUp;

    @FindBy(xpath = ".//*[@id='account-content-area']/div/div[2]/div[1]/div/div[1]/div/button")
    protected WebElement createAccount;

    @FindBy(id = "create-new-account-first-name")
    protected WebElement firstName;

    @FindBy(id = "create-new-account-last-name")
    protected WebElement lastName;

    @FindBy(id = "create-new-account-email")
    protected WebElement emailTextBox;

    @FindBy(id = "create-new-account-password")
    protected WebElement password;

    @FindBy(id = "create-new-account-confirm-password")
    protected WebElement conPassword;

    @FindBy(xpath = ".//*[@id='account-content-area']/div/div[2]/div[1]/form/div[6]/div[1]/button")
    protected WebElement submitAccount;

    @FindBy(name = "phone_number")
    protected WebElement phoneNumber;

    @FindBy(name = "zip")
    protected WebElement zipCode;


    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    public void createNewAccount(String firstname, String lastname, String email,
                                 String pass, String conPass, String phone, String zipcode) {

        signUp.click();
        createAccount.click();
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        emailTextBox.sendKeys(email);
        password.sendKeys(pass);
        conPassword.sendKeys(conPass);
        phoneNumber.sendKeys(phone);
        zipCode.sendKeys(zipcode);
        submitAccount.click();

    }

}




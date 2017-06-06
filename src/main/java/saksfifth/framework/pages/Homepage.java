package saksfifth.framework.pages;

import com.paxovision.execution.annotations.LogReport;
import com.paxovision.execution.reporter.service.ReporterService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import saksfifth.framework.base.PageBase;
import saksfifth.framework.extendReport.ExtentManager;
import saksfifth.framework.utils.DriverFactory;
import saksfifth.framework.utils.ExplicitWaitUtils;
import saksfifth.framework.utils.Helper;

import java.util.List;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class Homepage extends PageBase {

    private static ExtentManager extentManager = ExtentManager.getInstance(); //extend manager
    protected ReporterService reporter = ReporterService.reporter();

    @FindBy(xpath = "//div[@class='header-nav']//ul[@class='header-nav-menu__list']/li")
    protected List<WebElement> TOP_NAV_LIST;

    @FindBy(css = ".header-utils-search__input")
    protected WebElement SEARCH_BAR;

    @FindBy(xpath = "//div[@class='fsrFloatingContainer']")
    protected WebElement TRIGGER_POPUP;

    public Homepage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        //PageFactory.initElements(driver, this);
        super.closeTriggerPopup();
    }

    /**
     * Navigate to homepage
     * */
    public void naviageteToHomepage(){
        driver.navigate().to("http://www.saksfifthavenue.com/");
    }

    public void naviagetePage(String url){
        driver.navigate().to(url);
    }

    public void varifyHomepage(){
        Assert.assertEquals("Designer Women's Apparel, Men's Apparel, Shoes & Handbags - Saks.com", driver.getTitle());
        extentManager.log("Designer Women's Apparel, Men's Apparel, Shoes & Handbags - Saks.com" + driver.getTitle()); //for extend report
    }


    /**
     * Navigate to every single menu from the top navigation bar
     * */
    public void gotoTopNav(String name){
        for (WebElement topNav : TOP_NAV_LIST){

            System.out.println("Top Menu: " + topNav.getText());

            if(topNav.getText().contentEquals(name.toUpperCase())){
                mouseOn(topNav);
            }
        }
    }

    /**
     * Close the email popup from homepage
     * */
    @LogReport(name = "Close Homepage Popup", description = "Closing Popup")
    public void closePopup(){
        WebElement promoPopupElement = null;
        ExplicitWaitUtils wait = new ExplicitWaitUtils(driver);

        try {
            promoPopupElement = wait.waitForElement(By.xpath(".//*[@id='generic-modal']"));
            extentManager.log("Popup showedup");

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        if(promoPopupElement != null){
            WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[contains(@src, 'email_popup')]"));
            driver.switchTo().frame(iframe);
            WebElement closeButton = driver.findElement(By.xpath("//div[@id='close-button']"));
            closeButton.click();
            extentManager.log("popup closed");
        }else {
            System.out.println("Script is running... ... ...");
        }
    }


    /**
     * This method is for Get the Top navigation menu list from the
     * homepage and pass the top navigation Web element to
     * getSubmenuList methods.
     * */

    @LogReport(name = "Navigate to Product Page", description = "Navigate")
    public void navigateToProductPages(String productName, String subProductName){
        WebElement TOP_NAV = driver.findElement(By.cssSelector("ul[class='header-nav-menu__list']"));
        highlightElement(TOP_NAV);
        List<WebElement> TOP_NAV_LIST = driver.findElements(By.xpath("//div[@class='header-nav']//ul[@class='header-nav-menu__list']/li"));
        for(WebElement topNav : TOP_NAV_LIST){
            if(topNav.getText().contentEquals(productName)){
                mouseOn(topNav);
                getSubmenuList(topNav, subProductName);
                break;

            }
        }
    }

    @LogReport(name = "Checks all submenu Links", description = "Submenu Link check")
    public void linkCheck(){

        WebElement designerMenu = driver.findElement(By.xpath("//div[@class='header-nav']//ul[@class='header-nav-menu__list']/li//span[text()='DESIGNERS']/.."));

        mouseOn(designerMenu);
        delayFor(2000);

        List<WebElement> submenuLinks = designerMenu.findElements(By.xpath("./..//ul[@class='header-nav-flyout__columns']/li//a"));
        System.out.println("Sublinsk Size:" + submenuLinks.size());

        for (int i = 0; i < submenuLinks.size(); i++){
            closeTriggerPopup();
            try {
                WebElement menu = driver.findElement(By.xpath("//div[@class='header-nav']//ul[@class='header-nav-menu__list']/li//span[text()='DESIGNERS']/.."));

                highlightElement(menu);
                mouseOn(menu);

                submenuLinks = menu.findElements(By.xpath("./..//ul[@class='header-nav-flyout__columns']/li//a"));
                WebElement link = submenuLinks.get(i);

                highlightElement(link);
                link.click();

                System.out.println("Page Title: " + driver.getTitle());
                driver.navigate().back();
            }catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

    }


    public void checkSubmenuLinks(String topNavMenu){

        List<WebElement> TOP_NAV_LIST = driver.findElements(By.xpath("//div[@class='header-nav']//ul[@class='header-nav-menu__list']/li"));

        WebElement topMenu = null;

        for(WebElement topNav : TOP_NAV_LIST){
            if(topNav.getText().contentEquals(topNavMenu)){
                mouseOn(topNav);
                topMenu = topNav;
                break;
            }
        }

        List<WebElement> subMenuLinks = topMenu.findElements(By.xpath(".//ul[@class='header-nav-flyout__columns']/li//a"));
        delayFor(1000);
        for (int i = 0; i < subMenuLinks.size(); i++) {
            WebElement menu = topMenu;
            Actions actions = new Actions(driver);
            actions.moveToElement(menu).perform();


            subMenuLinks = menu.findElements(By.xpath(".//ul[@class='header-nav-flyout__columns']/li//a"));
            WebElement submenu = subMenuLinks.get(i);

            String url = submenu.getAttribute("href");
            String menuText = submenu.getText();
            System.out.println("Menu: " + menuText + " URL: " + url);

            submenu.click();
            System.out.println("Page Title: " + driver.getTitle());
            driver.navigate().back();
        }

    }


    /**
     * This method is for getting the SebMenu from the homepage
     * */
    public void getSubmenuList(WebElement element, String subProductName){
        WebElement topNav = element;

        List<WebElement> subMenuList = topNav.findElements(By.xpath(".//ul[@class='header-nav-flyout__columns']/li//a"));
        Helper.delayFor(3000);
        //System.out.println("Size: " + subMenuList.size());

        for(int i = 0; i< subMenuList.size(); i++){
            WebElement menu = subMenuList.get(i);
            System.out.println(menu.getText());
            if(menu.getText().contentEquals(subProductName)){
                menu.click();
                break;
            }
        }
    }

    /**
     * Assert method: for validating all link
     * from the top navigation bar on Homepage
     * */
    @LogReport(name = "Product Page Validation", description = "Product Page validated")
    public void validateProductPage(String text){
        WebElement labelElement = driver.findElement(By.xpath(".//*[@id='pa-topnav']/h1/span"));
        highlightElement(labelElement);
        String actual = labelElement.getText();
        Assert.assertEquals(text.toUpperCase(), actual);
    }

    /**
     * Search by product ID
     * */
    public void search(String upc){
        WebElement SEARCH_TEXT_BOX = driver.findElement(By.name("SearchString"));
        highlightElement(SEARCH_TEXT_BOX);
        SEARCH_BAR.sendKeys(upc , Keys.ENTER);
    }



}



package saksfifth.testScripts;

import org.testng.annotations.Test;
import saksfifth.framework.base.ScriptBase;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class HomepageTests extends ScriptBase {

    @Test
    public void navigateHomepageTest(){
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        saksFifth.homepage().closePopup();
    }

    @Test
    public void navigatetoProductArrayPagesTest(){
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        saksFifth.homepage().closePopup();
        saksFifth.homepage().navigateToProductPages("SHOES", "Iconic Shoes");
        saksFifth.homepage().validateProductArrayPage("ICONIC SHOES");
    }

    @Test
    public void navigatetoProductArrayPagesTest2(){
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        saksFifth.homepage().closePopup();
        saksFifth.homepage().navigateToProductPages("HANDBAGS", "Shop All Handbags");
        saksFifth.homepage().validateProductArrayPage("Shop All");
    }

    @Test
    public void navigatetoPDPTest(){
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        saksFifth.homepage().closePopup();
        saksFifth.homepage().navigateToProductPages("SHOES", "Exotics");
        saksFifth.homepage().validateProductArrayPage("EXOTICS");
        saksFifth.productArrayPage().clickFirstItem();
    }

    @Test
    public void submenuLinksTest(){
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        saksFifth.homepage().closePopup();
        saksFifth.homepage().linkCheck();
    }

}

package saksfifth.testScripts;

import org.testng.annotations.Test;
import saksfifth.framework.base.ScriptBase;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class PaymentPageTests extends ScriptBase {

    @Test
    public void test(){
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        saksFifth.homepage().closePopup();
        saksFifth.homepage().search("0402229864423");
        saksFifth.productDetailPage().addToBag();
        saksFifth.bagPage().clickCheckout();
        saksFifth.shippingPage().addShippingAddress();
        saksFifth.paymentPage().enterPayment();
    }

    @Test
    public void tes2(){
        saksFifth.homepage().naviagetePage("https://www.saksfifthavenue.com/account/login?_k=%2Faccount%2Fsummary");
        saksFifth.homepage().closePopup();
        saksFifth.homepage().search("0400094277400");
        saksFifth.productDetailPage().addToBag();
        saksFifth.productDetailPage().addToShoppingBag();
        saksFifth.bagPage().clickCheckout();
        saksFifth.shippingPage().addShippingAddress();
        saksFifth.paymentPage().enterPayment();

        //0400094277400
        //0402229864423


    }
}


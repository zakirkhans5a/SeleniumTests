package saksfifth.framework.base;

import com.paxovision.execution.reporter.interceptor.ProxyGenerator;
import saksfifth.framework.pages.*;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class ApplicationController {
    private Homepage homepage;
    private ProductArrayPage productArrayPage;
    private ProductDetailPage productDetailPage;
    private BagPage bagPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private AccountPage accountPage;
    private ReviewSubmitPage reviewSubmitPage;

    public ApplicationController() {}

    /**Paxo report we need to add
     * ProxyGenerator.getEnhancedObject(Classname.class)
     * instate of Instantiate class object.
     * */

    public Homepage homepage(){
        if(homepage==null){
            //homepage = new Homepage();
            homepage = ProxyGenerator.getEnhancedObject(Homepage.class);
        }
        return homepage;
    }

    public ProductArrayPage productArrayPage(){
        if(productArrayPage==null){
            //productArrayPage = new ProductArrayPage();
            productArrayPage = ProxyGenerator.getEnhancedObject(ProductArrayPage.class);
        }
        return  productArrayPage;
    }

    public ProductDetailPage productDetailPage(){
        if(productDetailPage == null){
            //productDetailPage = new ProductDetailPage();
            productDetailPage = ProxyGenerator.getEnhancedObject(ProductDetailPage.class);
        }
        return  productDetailPage;
    }

    public BagPage bagPage(){
        if (bagPage==null){
            //bagPage = new BagPage();
            bagPage = ProxyGenerator.getEnhancedObject(BagPage.class);


        }
        return bagPage;
    }

    public ShippingPage shippingPage(){
        if(shippingPage==null){
            //shippingPage = new ShippingPage();
            shippingPage = ProxyGenerator.getEnhancedObject(ShippingPage.class);
        }
        return shippingPage;
    }

    public PaymentPage paymentPage(){
        if(paymentPage == null){
            //paymentPage = new PaymentPage();
            paymentPage = ProxyGenerator.getEnhancedObject(PaymentPage.class);
        }
        return paymentPage;
    }

    public AccountPage accountPage(){
        if(accountPage == null){
            //accountPage = new AccountPage();
            accountPage = ProxyGenerator.getEnhancedObject(AccountPage.class);
        }
        return accountPage;
    }

    public ReviewSubmitPage reviewSubmitPage(){
        if(reviewSubmitPage == null) {
            //reviewSubmitPage = new ReviewSubmitPage();
            reviewSubmitPage = ProxyGenerator.getEnhancedObject(ReviewSubmitPage.class);
        }
        return reviewSubmitPage;
    }

}


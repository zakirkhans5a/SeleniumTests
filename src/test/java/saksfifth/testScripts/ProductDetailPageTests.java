package saksfifth.testScripts;

import org.testng.annotations.Test;
import saksfifth.framework.base.ScriptBase;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class ProductDetailPageTests extends ScriptBase {

    @Test
    public void test(){
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        saksFifth.homepage().closePopup();
        saksFifth.homepage().search("0402229864423");
        saksFifth.productDetailPage().addToBag();

    }
}

package saksfifth.testScripts;

import org.testng.annotations.Test;
import saksfifth.framework.base.ScriptBase;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class AccountPageTests extends ScriptBase {

    @Test
    public void accountPageTest(){
        saksFifth.homepage().naviageteToHomepage();
        saksFifth.homepage().varifyHomepage();
        saksFifth.homepage().closePopup();
        saksFifth.accountPage().createNewAccount (  "Zakir",
                "Khan",
                "abid@gmail.com",
                "!Password1",
                "!Password1",
                "516-453-8976",
                "12040"
        );


    }


}


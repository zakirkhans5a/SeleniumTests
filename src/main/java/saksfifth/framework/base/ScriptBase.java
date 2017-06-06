package saksfifth.framework.base;

/**
 * Created by zakirkhan on 6/2/17.
 */

/** Extend Report Listener*/
//@Listeners({ExtentTestNGITestListener.class})

import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.paxovision.execution.reporter.service.ReporterService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import saksfifth.framework.extendReport.ExtentTestNGITestListener;
import saksfifth.framework.utils.ApplicationFactory;
import saksfifth.framework.utils.DriverFactory;

import java.util.concurrent.TimeUnit;

/** Paxo report Listener*/
@Listeners({ReporterTestListener.class, ExtentTestNGITestListener.class})
public class ScriptBase {

    protected ReporterService reporter = ReporterService.reporter();
    protected ApplicationController saksFifth;

    @BeforeClass
    public void beforeClass(){

    }

    @BeforeMethod
    public void setup(){
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        saksFifth = ApplicationFactory.getInstance().getApplicationController();

        reporter.setReportPath(System.getProperty("user.dir") + "/test-output/htmlReport/");
        reporter.setReportName("Saks Fifth Avenue Report");
        reporter.setReportTitle("Saks Fifth Functional Test");
        reporter.setCreateUniqueFileName(true);

    }

    @AfterMethod
    public void teardown(){
        //DriverFactory.getInstance().closeDriver();
        //DriverFactory.getInstance().quitDriver();
        //ApplicationFactory.getInstance().remove();
        //saksFifth = null;

    }
}


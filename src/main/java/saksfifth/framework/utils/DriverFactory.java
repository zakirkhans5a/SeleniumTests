package saksfifth.framework.utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class DriverFactory {

    private static DriverFactory instance = new DriverFactory();

    /*public static final String USERNAME = "saadabdullah"; // Insert Username for BrowserStack account
    public static final String AUTOMATE_KEY = "WsjTqspKpUUjt4sLbSza"; //Set the Token from BrowserStack Account
    public static final String BROWSER_STACK_REMOTE_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";*/

    private DriverFactory()
    {
        //Do-nothing..Do not allow to initialize this class from outside
    }

    public static DriverFactory getInstance()
    {
        return instance;
    }

    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>() // thread local driverThreadLocal object for webdriver
    {
        @Override
        protected WebDriver initialValue()
        {

            //FirefoxDriverManager.getInstance().setup();

            //ProfilesIni profiles = new ProfilesIni();
            //FirefoxProfile seleniumProfile = profiles.getProfile("Selenium");
            //return new FirefoxDriver();

            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver();

            /*DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "58.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "7");
            caps.setCapability("resolution", "1920x1080");
            try {
                return new RemoteWebDriver(new URL(BROWSER_STACK_REMOTE_URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;*/
        }
    };
    public WebDriver getDriver() // call this method to get the driverThreadLocal object and launch the browser
    {
        return driverThreadLocal.get();
    }
    public void closeDriver()
    {
        driverThreadLocal.get().close();
    }
    public void quitDriver()
    {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}



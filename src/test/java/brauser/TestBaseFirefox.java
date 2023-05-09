package brauser;

import constant.PathBrowserDriver;
import constant.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TestBaseFirefox {
    WebDriver driver;

    @BeforeEach
    public void setUp() {

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

//        FirefoxProfile profile = new FirefoxProfile();
//        FirefoxOptions options = new FirefoxOptions();
//        options.setProfile(profile);
//        driver = new RemoteWebDriver(options);


//        //System.setProperty("webdriver.gecko.driver", PathBrowserDriver.PATH_TO_GECKODRIVER);
//        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL.URL_BASE);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testQABibleImageDisplayed() {
        final By imgQABible = By.xpath("//img[@class='r-z2wwpe r-dnmrzs']");
        Assert.assertTrue(driver.findElement(imgQABible).isDisplayed());
    }
}
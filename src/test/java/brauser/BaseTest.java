package brauser;

import constant.PathBrowserDriver;
import constant.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected static String browserType;

    /**
     * для запуска теста команда:
     */

    @BeforeEach
    @Parameters("browserType")
    public void setUp(String browserType) throws Exception {
        BaseTest.browserType = browserType;

        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "yandex":
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", PathBrowserDriver.PATH_TO_YANDEX_DRIVER);
                ChromeOptions options = new ChromeOptions();
                options.setBinary(PathBrowserDriver.BINARY_PATH_YANDEX);
                driver = new ChromeDriver(options);
                break;

            default:
                throw new Exception("Invalid browser passed: " + browserType);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL.URL_BASE);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        final By imgQABible = By.xpath("//img[@class='r-z2wwpe r-dnmrzs']");
        Assert.assertTrue(driver.findElement(imgQABible).isDisplayed());
    }
    /**
     * Для запуска тестов необходимо запустить testng.xml файл через раннер TestNG.
     * Также TestNG можно запустить из командной строки, например, так:
     *
     * java -cp "path/to/testng.jar:path/to/classes/folder" org.testng.TestNG path/to/testng.xml
     */
}
package brauser;

import constant.PathBrowserDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static constant.URL.URL_BASE;

public class TestBaseYandexBrowser {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", PathBrowserDriver.PATH_TO_YANDEX_DRIVER);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(PathBrowserDriver.BINARY_PATH_YANDEX);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL_BASE);
    }

    private final By imgQABible = By.xpath("//img[@class='r-z2wwpe r-dnmrzs']");
    @Test
    public void testQABibleImageDisplayed() {
        Assert.assertTrue(driver.findElement(imgQABible).isDisplayed());
    }




    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

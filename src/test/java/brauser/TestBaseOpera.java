package brauser;

import constant.PathBrowserDriver;
import constant.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class TestBaseOpera {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.operadriver().setup();
        // Установка пути к драйверу оперы
        // Драйвер скачать с:
        // https://github.com/operasoftware/operachromiumdriver/releases
        System.setProperty("webdriver.opera.driver", PathBrowserDriver.PATH_TO_OPERA);
        // Инициализация драйвера оперы
        ChromeOptions options = new ChromeOptions();
        options.setBinary(PathBrowserDriver.BINARY_PATH_OPERA);
        driver = new ChromeDriver(options);
        //driver = new OperaDriver();
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
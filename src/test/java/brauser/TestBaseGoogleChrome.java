package brauser;

import constant.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TestBaseGoogleChrome {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
    public void test() {
        final By imgQABible = By.xpath("//img[@class='r-z2wwpe r-dnmrzs']");
        Assert.assertTrue(driver.findElement(imgQABible).isDisplayed());
    }
}
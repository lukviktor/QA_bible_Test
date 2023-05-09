package brauser;

import constant.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TestBaseFirefox {
    WebDriver driver;

    @BeforeEach
    public void setUp() {

        // Загрузка драйвера для Firefox
        WebDriverManager.firefoxdriver().setup();

        // Создание опций браузера Firefox


        // Создание экземпляра браузера Firefox
        WebDriver driver = new FirefoxDriver();

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
        final By btnCloseCookies = By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div/div");
        final By imgQABible = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/main/div[2]/div[1]/div/div[1]/div/div/div/div/div/div/div/div/div/div/div/div/img");
        final By btnCloseImgQABible = By.xpath("/html/body/div[2]/div[9]/div[2]/div/div/div/div/div/div[4]/div[3]/div/svg");
        driver.findElement(btnCloseCookies).click();
        driver.findElement(imgQABible).click();
        driver.findElement(btnCloseImgQABible).click();
    }
}
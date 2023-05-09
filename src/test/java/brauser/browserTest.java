package brauser;

import constant.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class browserTest {

    WebDriver driver;



    @Test
    void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ya.ru/");
    }
    //WebDriverManager.firefoxdriver().setup();
    //WebDriverManager.edgedriver().setup();
    //WebDriverManager.operadriver().setup();
    //WebDriverManager.chromiumdriver().setup()
    //WebDriverManager.iedriver().setup();

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        // Exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();
        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}
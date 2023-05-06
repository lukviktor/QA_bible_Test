package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        String browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // укажите путь до chromedriver
                driver = new ChromeDriver();
                break;
            case "yandex":
                String yandexHubUrl = "http://localhost:4444/wd/hub"; // вы можете заменить на адрес вашей сети или хостинга
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("yandex");
                ChromeOptions chromeOptions = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("intl.accept_languages", "ru-RU");
                chromeOptions.setExperimentalOption("prefs", prefs);
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                driver = new RemoteWebDriver(new URL(yandexHubUrl), capabilities);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}
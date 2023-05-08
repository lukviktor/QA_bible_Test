package qa_bible;

import constant.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;



public class BaseSetBrowsers {
    // актуальный драйвер берем от сюда:
    // https://chromedriver.chromium.org/downloads

    protected WebDriver driver;
    private static final String YANDEX_BROWSER = "yandex";
    private static final String CHROME_BROWSER = "chrome";
    private static final String PATH_TO_YANDEX_DRIVER = "src/main/resources/yandex/chromedriver.exe";
    private static final String PATH_TO_CHROME_DRIVER = "src/main/resources/chrome/chromedriver.exe";
    private static final String BINARY_PATH = "C:/Users/lvikt/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        String browser = System.getProperty("browser", CHROME_BROWSER);
        switch (browser) {
            case CHROME_BROWSER:
                System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER); // укажите путь до chromedriver
                driver = new ChromeDriver();
                break;
            case YANDEX_BROWSER:
                System.setProperty("webdriver.chrome.driver", PATH_TO_YANDEX_DRIVER);
                ChromeOptions options = new ChromeOptions();
                options.setBinary(BINARY_PATH);
                driver = new ChromeDriver(options);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL.URL_BASE);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }
}
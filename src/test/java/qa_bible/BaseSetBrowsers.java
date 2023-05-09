package qa_bible;

import constant.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseSetBrowsers {
    // актуальный драйвер берем отсюда:
    // https://chromedriver.chromium.org/downloads

    protected WebDriver driver;
    private static final String YANDEX_BROWSER = "yandex";
    private static final String CHROME_BROWSER = "chrome";
    private static final String PATH_TO_YANDEX_DRIVER = "src/main/resources/yandex/chromedriver.exe";
    private static final String PATH_TO_CHROME_DRIVER = "src/main/resources/chrome/chromedriver.exe";
    private static final String BINARY_PATH = "C:/Users/lvikt/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", CHROME_BROWSER);
        switch (browser) {
            case CHROME_BROWSER:
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
            case YANDEX_BROWSER:
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", PATH_TO_YANDEX_DRIVER);
                ChromeOptions yandexOptions = new ChromeOptions();
                yandexOptions.setBinary(BINARY_PATH);
                driver = new ChromeDriver(yandexOptions);
                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL.URL_BASE);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
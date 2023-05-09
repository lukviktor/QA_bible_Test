package multithreading;

import constant.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
/**
 * @TestInstance (TestInstance.Lifecycle.PER_CLASS)` для создания одного экземпляра класса тестов на весь набор тестов.
 * Это позволяет нам совершать инициализацию только один раз перед запуском всех тестов.
 */
@Execution(ExecutionMode.CONCURRENT)
/**
 * @Execution для запуска тестов в разных потоках.
 */
public class TestMultiGoogleChrome {

    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL.URL_BASE);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @RepeatedTest(value = 2)
    /**
     * @RepeatedTest(value = 2)` для выполнения теста несколько раз.
     */
    public void test() throws InterruptedException {
        final By imgQABible = By.xpath("//img[@class='r-z2wwpe r-dnmrzs']");
        Assert.assertTrue(driver.findElement(imgQABible).isDisplayed());
        sleep(2000); // Добавим задержку для демонстрации переключения потоков
    }
}
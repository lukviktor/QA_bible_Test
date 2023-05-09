package qa_bible;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class SmokeTest extends BaseSetBrowsers {
    private final By imgQABible = By.xpath("//img[@class='r-z2wwpe r-dnmrzs']");

    @Test
    public void testQABibleImageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(imgQABible));
        Assert.assertTrue(driver.findElement(imgQABible).isDisplayed());
    }
}
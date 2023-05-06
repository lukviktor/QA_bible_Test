package qa_bible;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseSetBrowsers {
    private final By imgQABible = By.xpath("//img[@class='r-z2wwpe r-dnmrzs']");

    @Test
    public void testQABibleImageDisplayed() {
        Assert.assertTrue(driver.findElement(imgQABible).isDisplayed());
    }
}

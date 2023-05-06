package googlechrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SmokeTest extends TestBaseChrome {
    private final By imgQABible = By.xpath("//img[@class='r-z2wwpe r-dnmrzs']");

    @Test
    public void testQABibleImageDisplayed() {
        Assertions.assertTrue(driver.findElement(imgQABible).isDisplayed());
    }
}
package qa_bible;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseSetBrowsers {
    private final By imgQABible = By.xpath("//img[@class='r-z2wwpe r-dnmrzs']");

    @Test
    public void testQABibleImageDisplayed() {
        Assert.assertTrue(driver.findElement(imgQABible).isDisplayed());
    }
    String oj = "FAQ для новичков";
    @Step("Переход по оглавлению")
    public WebElement siteTableOfContents() {

        return driver.findElement(By.xpath(String.format("//*[text()='%s']", oj)));


    }

}

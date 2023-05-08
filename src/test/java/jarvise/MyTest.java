package jarvise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest extends BaseTest {

    @Test
    public void testGoogleSearch() throws Exception {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();
        WebElement searchResult = driver.findElement(By.xpath("//h3[contains(text(),'Selenium WebDriver')]"));
        Assert.assertNotNull(searchResult);
    }

}
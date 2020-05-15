package labs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@Category(SmokeTest.class)
public class CatalogTest {

    WebDriver driver;
    Catalog page;

    @Before  
    public void openSite()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.ikea.com/ru/ru/cat/tovary-products/");
        page = PageFactory.initElements(driver, Catalog.class);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("каталог");
            }
        });
    }

    @Test
    public void testClickOnDekor()
    {
        page.clickOnDekor();
        new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("декор");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("Декор для дома - купить в интернет-магазине - IKEA", page.getPageName());
    }

    @Test
    public void testClickOnFood()
    {
        page.clickOnFood();
        new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("еда");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("Еда в ИКЕА, шведские продукты - IKEA", page.getPageName());
    }

    @After
    public void closeSite()
    {
        driver.quit();
    }

}
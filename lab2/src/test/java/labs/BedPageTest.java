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
public class BedPageTest {

    WebDriver driver;
    BedPage page;

    @Before  
    public void openSite()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.ikea.com/ru/ru/cat/krovati-bm003/");
        page= PageFactory.initElements(driver, BedPage.class);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("кровати");
            }
        });
    }

    @Test
    public void testClickOnDoubleBed()
    {
        page.clickOnDoubleBed();
        new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("двуспальные");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("Двуспальные кровати - купить по низкой цене в IKEA - IKEA", page.getPageName());
    }

    @Test
    public void testClickOnChildrenBed()
    {
        page.clickOnChildrenBed();
        new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("детские");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("Детские кровати от 3 лет и раздвижные кровати купить - IKEA", page.getPageName());
    }

    @After
    public void closeSite()
    {
        driver.quit();
    }

}
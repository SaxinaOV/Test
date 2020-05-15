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
public class HomePageTest {
    WebDriver driver;
    HomePage page;

    @Before
    public void openSite()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.ikea.com/ru/ru/");
        page= PageFactory.initElements(driver, HomePage.class);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("IKEA");
            }
        });
    }

    @Test
    public void testClickOnBedroom()
    {
        page.clickOnBedroom();
        new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("спальни");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("Спальни купить - мебель в спальню, гарнитур ИКЕА - IKEA", page.getPageName());
    }

    @Test
    public void testClickOnNews()
    {
        page.clickOnNews();
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("новинки");
            }
        });
        Assert.assertEquals("Новинки - IKEA", page.getPageName());
    }

    @After
    public void closeSite()
    {
        driver.quit();
    }
}


/*
public class HomePageTest 
{
    WebDriver driver = new FirefoxDriver();

    @Test
    public void HomePageName()
    {
        driver.get("https://www.ikea.com/ru/ru/");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS); 

        HomePage homePage = new HomePage(driver);

        assertEquals("ИКЕА - официальный интернет-магазин мебели - IKEA", homePage.getHomePageName());

        driver.quit();
    }

    @Test
    public void TestCatalogue()
    {
        driver.get("https://www.ikea.com/ru/ru/");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS); 

        HomePage homePage = new HomePage(driver);

        homePage.clickCatalogue();
        String newPageURL = driver.getCurrentUrl();

        assertEquals("https://onlinecatalogue.ikea.com/RU/ru/IKEA_Catalogue/?index#/", newPageURL);
        //System.out.println(newPageURL);

        driver.quit();
    }
}
*/
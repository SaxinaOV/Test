package lab4;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import cucumber.api.PendingException;

public class Catalog {
    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(3)>a")
    WebElement dekor;

    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(5)>a")
    WebElement food;

    WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Given("^Open catalog$")
    public void openPage() {
        driver.get("https://www.ikea.com/ru/ru/cat/tovary-products/");
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("каталог");
            }
        });
    }
    

	@When("^Choose dekor$")
    public void clickOnDekor(){
        dekor.click();
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("декор");
            }
        });
    }

	@Then("^Verify dekor results$")
    public void verifyDekorTitle(){
            Assert.assertTrue(driver.getTitle().toLowerCase().contains("декор"));
	}	

	@When("^Choose food$")
	public void clickOnFood()
    {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", food);
		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("еда");
            }
        });
	}

	@Then("^Verify food results$")
    public void verify_food_results()throws Throwable {
            Assert.assertTrue(driver.getTitle().toLowerCase().contains("еда"));
            //throw new PendingException();
        }
	
    @After
    public void closeBrowser(){
        driver.quit();
	}
}



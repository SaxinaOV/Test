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
import cucumber.api.PendingException;

public class BedPage {
    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(2)")
    WebElement doubleBed;

    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(5)")
    WebElement childrenBed;

    WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Given("^Open bed page$")
    public void openPage() {
        driver.get("https://www.ikea.com/ru/ru/cat/krovati-bm003/");
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("кровати");
            }
        });
    }
    

	@When("^Choose double bed$")
    public void clickOnDoubleBed(){
        doubleBed.click();
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("двуспальные");
            }
        });
    }

	@Then("^Verify double bed results$")
    public void verifyBedTitle(){
            Assert.assertTrue(driver.getTitle().toLowerCase().contains("двуспальные"));
	}	

	@When("^Choose children bed$")
	public void choose_children_bed()
    {
		childrenBed.click();
		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("детские");
            }
        });
	}

	@Then("^Verify children bed results$")
    public void verify_children_bed_results() throws Throwable {
            Assert.assertTrue(driver.getTitle().toLowerCase().contains("детские"));
            //throw new PendingException();
        }
	
    @After
    public void closeBrowser(){
        driver.quit();
	}
}


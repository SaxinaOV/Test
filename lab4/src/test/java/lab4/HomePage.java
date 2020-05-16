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

public class HomePage {

    @FindBy(css=".search-field__input ")
    WebElement searchBox;

	@FindBy(css=".search-box__button.search-box__button--search")
    WebElement searchButton;
	
	@FindBy(css=".header__main-nav--wrapper > ul:nth-child(1) > li:nth-child(6)")
	WebElement news;
	
	@FindBy(css="div.header__wrapper>div.header__container>nav.header__main-nav>div.header__main-nav--wrapper>ul.main-bygga-menu>li:nth-child(2)>div.main-bygga-menu__sub.main-bygga-menu__dropdown>ul.main-bygga-menu__level1>li:nth-child(3)>a")
	WebElement bedroom;

	WebDriver driver;
	
	@Before
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Given("^Open home page$")
    public void openHomePage() {
        driver.get("https://www.ikea.com/ru/ru/");
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("IKEA");
            }
        });
    }


	@When("^Choose bedroom$")
    public void choose_bedroom() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", bedroom);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("спальни");
            }
        });
        //throw new PendingException();
	}

	@Then("^Verify bedroom results$")
    public void verify_bedroom_results(){
            Assert.assertTrue(driver.getTitle().toLowerCase().contains("спальни"));
	}	

	@When("^Choose news$")
	public void choose_news() throws Throwable{
		news.click();
		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("новинки");
            }
        });
        //throw new PendingException();
	}

	@Then("^Verify news results$")
    public void verifyNewsTitle(){
            Assert.assertTrue(driver.getTitle().toLowerCase().contains("новинки"));
	}
	
    @After
    public void closeBrowser(){
        driver.quit();
	}
}

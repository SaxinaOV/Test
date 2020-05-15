package labs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

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

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    void clickOnBedroom()
    {
		//WebDriverWait wait = new WebDriverWait(driver, 50); 
		//wait.until(ExpectedConditions.visibilityOf(bedroom)); //this will wait for elememt to be visible for 20 seconds
		//Actions act=new Actions(driver);
		//act.moveToElement(bedroom).click().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", bedroom);
		String s = bedroom.getAttribute("outerHTML");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(s);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Page title is: " + driver.getTitle());
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//bedroom.click();
	}
	
	void clickOnNews()
    {
        news.click();
	}
	
    public String getPageName(){
		return	driver.getTitle();
	}
}

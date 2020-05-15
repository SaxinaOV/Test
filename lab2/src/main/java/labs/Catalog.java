package labs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class Catalog {
    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(3)>a")
    WebElement dekor;

    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(5)>a")
    WebElement food;

    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(13)")
    WebElement lighting;

    WebDriver driver;

    public Catalog(WebDriver driver)
    {
        this.driver = driver;
    }

    void clickOnDekor(){
        dekor.click();
        String s = dekor.getAttribute("outerHTML");
        System.out.println(s);
    }

    void clickOnFood(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", food);
    }

    void clickOnLighting(){
        lighting.click();
    }

    public String getPageName(){
		return	driver.getTitle();
	}

}
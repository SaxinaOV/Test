package labs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BedPage {
    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(2)")
    WebElement doubleBed;

    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(5)")
    WebElement childrenBed;

    @FindBy(css="div.range-catalog-list.js-range-catalog-list>nav.range-catalog-list__inner>ul.range-catalog-list__list>li:nth-child(3)")
    WebElement sofa;

    WebDriver driver;

    public BedPage(WebDriver driver)
    {
        this.driver = driver;
    }

    void clickOnDoubleBed(){
        doubleBed.click();
    }

    void clickOnChildrenBed(){
        childrenBed.click();
    }

    void clickOnSofa(){
        sofa.click();
    }

    public String getPageName(){
		return	driver.getTitle();
	}

}
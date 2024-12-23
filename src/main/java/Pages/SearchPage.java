package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By HeaderSectionLocator = By.xpath("//h1[contains(text(),'Results for')]");
    private final By NameOfItemLocator = By.xpath("//div[contains(@class, 'text-text')]//p[@class='line-clamp-2'][1]");
    private final By DestinationFilterLocator = By.xpath("//aside[contains(@class, 'col-span-full')]//button[@placeholder='Search']");
    private final By SearchInsideFilterLocator = By.cssSelector("input[data-orientation='vertical']");
    private final By RiyadhLocator = By.xpath("//div[contains(text(),'Riyadh')]");
    private final By LocationItemLocator = By.xpath("//div[contains(@class, 'text-text')]//p[contains(@class, 'line-clamp-1')]");
    public String GetTextFromResultsHeaders() {
        return getText(HeaderSectionLocator);
    }

    public String GetTextOfItemName(){
        return getText(NameOfItemLocator);
    }
    public void FilterBy(String FilterKey){
        Click(DestinationFilterLocator);
//        sendKeys(FilterKey, SearchInsideFilterLocator);
        Click(RiyadhLocator);
    }
    public List<String> getLocationTexts() {
        List<WebElement> locationElements = driver.findElements(LocationItemLocator);
        List<String> locationTexts = new ArrayList<>();
        for (WebElement element : locationElements) {
            locationTexts.add(element.getText());
        }

        // Return the list of texts
        return locationTexts;
    }

}

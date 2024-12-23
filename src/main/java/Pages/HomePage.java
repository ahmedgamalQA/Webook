package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By LoginButtonLocator = By.cssSelector("a[data-testid='header_nav_login_button']");
    private final By ProfilePicLocator = By.cssSelector("button[aria-haspopup='dialog']");
    private final By LoggedEmailLocator = By.xpath("//div[@class='text-lg font-bold']/p[2]");
    private final By SearchFieldLocator = By.cssSelector("input[data-testid='home_search_input']");
    private final By SearchButtonLocator = By.cssSelector("button[data-testid='home_search_submit_button']");

    public void ClickOnLoginButton() {
        Click(LoginButtonLocator);
    }

    public boolean isLoginButtonNotDisplayed() {
        try {
            // Locate the login button
            WebElement loginButton = driver.findElement(LoginButtonLocator);

            // Check if the login button is NOT visible
            return !loginButton.isDisplayed(); // Returns true if not visible
        } catch (NoSuchElementException e) {
            // If the button is not in the DOM, consider it as not visible
            return true;
        }
    }

    public String GetTextOfLoggedEmail() {
        Click(ProfilePicLocator);
        return getText(LoggedEmailLocator);
    }

    public void UserSearchBy(String KeySearch) {
        sendKeys(KeySearch, SearchFieldLocator);
        Click(SearchButtonLocator);
    }
}

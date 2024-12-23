package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By CreateAccountLocator = By.cssSelector("button[data-testid='auth_signup_button']");
    private final By FirstNameLocator = By.id("first_name");
    private final By LastNameLocator = By.id("last_name");
    private final By EmailRegisterLocator = By.id("email");
    private final By ConfirmEmailRegisterLocator = By.id("confirm_email");
    private final By PasswordRegisterLocator = By.name("password");
    private final By CountryCodeLocator = By.cssSelector("input[data-testid='auth_countrycode_selector']");
    private final By CCOptionLocator = By.xpath("//span[text()='Saudi Arabia']");
    private final By MobileNumberLocator = By.name("mobile");
    private final By AgreeTermsLocator = By.name("agreeTerms");
    private final By SubmitButtonLocator = By.cssSelector("button[data-testid='auth_signup_submit_button']");


    public void ClickOnCreateAccount() {
        Click(CreateAccountLocator);
    }

    public void FillRequiredFields(String FirstNameValue,String LastNameValue,String EmailRegisterValue,String PasswordRegisterValue, String MobileNumberValue) {
       sendKeys(FirstNameValue, FirstNameLocator);
       sendKeys(LastNameValue, LastNameLocator);
       sendKeys(EmailRegisterValue, EmailRegisterLocator);
       sendKeys(EmailRegisterValue,ConfirmEmailRegisterLocator);
       sendKeys(PasswordRegisterValue, PasswordRegisterLocator);
       Click(CountryCodeLocator);
       Click(CCOptionLocator);
       sendKeys(MobileNumberValue, MobileNumberLocator);
       Click(AgreeTermsLocator);
       Click(SubmitButtonLocator);
    }
}

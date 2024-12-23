package StepDefinitions;

import DataDriven.*;
import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static StepDefinitions.Hooks.driver;

public class Tests {
    SoftAssert soft = new SoftAssert();
    GenerateFakeData fake = new GenerateFakeData();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    SearchPage searchPage = new SearchPage(driver);
    private String EmailValue;
    private String PasswordValue;

    @Given("the user navigates to the homepage")
    public void theUserNavigatesToTheHomepage() {
    }

    @When("the user clicks the Sign Up button on the homepage")
    public void theUserClicksTheButtonOnTheHomepage() {
        homePage.ClickOnLoginButton();
        loginPage.ClickOnCreateAccount();
    }


    @And("the user fills in all required fields")
    public void theUserFillsInAllRequiredFields() {
        String firstNameValue = fake.fakeFirstName();
        String lastnameValue = fake.fakeLastName();
        EmailValue = fake.fakeEmail();
        PasswordValue = fake.fakePassword();
        String KsaMobileValue = fake.fakeMobileNumberKSA();


        loginPage.FillRequiredFields(firstNameValue, lastnameValue, EmailValue, PasswordValue, KsaMobileValue);
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        soft.assertTrue(homePage.isLoginButtonNotDisplayed(),
                "Login button should NOT be displayed after login.");

        // Assert all soft assertions
        soft.assertAll();
    }

    @And("the user's username and email should be correct")
    public void theUserSUsernameAndEmailShouldBeCorrect() {
        String expectedEmail = EmailValue;
        String ActualEmail = homePage.GetTextOfLoggedEmail();
        System.out.println("ActualEmail: " + ActualEmail);
        System.out.println("expectedEmail: " + expectedEmail);

        soft.assertTrue(expectedEmail.equals(ActualEmail));
        soft.assertAll();
    }

    @When("user search by {string} in search field")
    public void userSearchByInSearchField(String KeySearch) {
        homePage.UserSearchBy(KeySearch);
    }

    @Then("Assert the title of the result is contains: {string}")
    public void assertTheTitleOfTheResultIsContains(String KeySearch) {
        String ExpectedResult = KeySearch;
        String ActualResult = searchPage.GetTextFromResultsHeaders();
        System.out.println(ActualResult);

        soft.assertTrue(ActualResult.contains(ExpectedResult));
        soft.assertAll();
    }

    @And("verify the search results contains {string}")
    public void verifyTheSearchResultsContains(String KeySearch) {
        String ExpectedResult = KeySearch;
        String ActualResult = searchPage.GetTextOfItemName();
        System.out.println(ActualResult);

        soft.assertTrue(ExpectedResult.equals(ActualResult));
        soft.assertAll();
    }

    @And("Filter to display {string} location Only")
    public void filterToDisplayLocationOnly(String FilterKey) {
        searchPage.FilterBy(FilterKey);
    }

    @Then("Assert the search results contains {string}")
    public void assertTheSearchResultsContains(String FilterKey) throws InterruptedException {
        List<String> ActualResults = searchPage.getLocationTexts();

        for (String result : ActualResults) {
            // Print the result for debugging purposes
            System.out.println("Found result: " + result);
            soft.assertTrue(
                    result.contains(FilterKey),
                    "Search result '" + result + "' does not contain the expected filter key: '" + FilterKey + "'"
            );
        }
        Thread.sleep(3000);
        soft.assertAll();
    }
}

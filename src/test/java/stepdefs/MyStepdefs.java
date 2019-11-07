package stepdefs;

import Objects.FormObjects;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class MyStepdefs {

    FormObjects formObjects;
    WebDriver driver;

    @Before

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        formObjects = new FormObjects(driver);
    }
    @After
    public void driverClose(){
        driver.quit();
    }

    @Given("^user navigates to the app url$")
    public void userNavigatesToTheAppUrl () {
        driver.get("http://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @When("^user fills first name with name \"([^\"]*)\"$")
    public void userFillsFirstNameWithName (String firstName) throws Throwable {
        formObjects.setFirstName(firstName);
    }
    @And("^user fills last name with last name \"([^\"]*)\"$")
    public void userFillsLastNameWithLastName (String lastName) throws Throwable {
        formObjects.setLastName(lastName);
    }

    @And("^user fills gender$")
    public void userFillsGender () {
        formObjects.selectGender();
    }

    @And("^user fills date of birth \"([^\"]*)\"$")
    public void userFillsDateOfBirth (String DOB ) throws Throwable {
        formObjects.setDateOfBirth(DOB);
    }

    @And("^user fills address$")
    public void userFillsAddress () {
        formObjects.setAddress();
    }

    @And("^user fills email address \"([^\"]*)\"$")
    public void userFillsEmailAddress (String email) throws Throwable {
        formObjects.setEmail(email);
    }

    @And("^user fills password \"([^\"]*)\"$")
    public void userFillsPassword (String password) throws Throwable {
        formObjects.setPassword(password);
    }

    @And("^user fills company name$")
    public void userFillsCompanyName () {
        formObjects.setCompany("Forte");
    }

    @And("^user select Role - QA$")
    public void userSelectRoleQA () {
        formObjects.selectRole("QA");
    }

    @And("^User select job expectation: Good teamwork, High salary, Challenging$")
    public void userSelectJobExpectationGoodTeamworkHighSalaryChallenging () {
        formObjects.selectExpectaition("Good teamwork");
        formObjects.selectExpectaition("High salary");
        formObjects.selectExpectaition("Challenging");

    }

    @And("^User select random three options from ways of development$")
    public void userSelectRandomOptionsFrom (){
        formObjects.waysRandom();
    }

    @And("^user fill comment$")
    public void userFillComment () {
        formObjects.setCommentInput("Good luck!!!");
    }

    @And("^user click submit button$")
    public void userClickSubmitButton () {
        formObjects.clickSubmitButton();

    }

    @Then("^form is submitted$")
    public void formIsSubmitted () {
        WebElement submitMessage = driver.findElement(By.id("submit-msg"));
        String successMsg = "Successfully submitted!";
        Assert.assertTrue(submitMessage.isDisplayed());
        Assert.assertEquals(successMsg, "Successfully submitted!","The form is not successfully submitted");


    }
}

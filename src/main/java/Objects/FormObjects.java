package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;


public class FormObjects {
    WebDriver driver;

    public FormObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindAll(@FindBy(name="gender"))
    List<WebElement> genders;

    @FindBy(id = "dob")
    WebElement dateOfBirth;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "email")
    WebElement email;


    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "role")
    WebElement roles;

    @FindBy(id = "expectation")
    WebElement expectations;

    @FindAll(@FindBy(xpath = "//div/label/input[@type='checkbox']"))
    List<WebElement> ways;

    @FindBy(id = "comment")
    WebElement comment;

    @FindBy(id = "submit")
    WebElement submit;

    public void setFirstName(String yourFirstName) {
        firstName.sendKeys(yourFirstName);
    }
    public void setLastName(String yourLastName) {
        lastName.clear();
        lastName.sendKeys(yourLastName);
    }
    public void selectGender( ){
        Random random = new Random();
        int genderNumber = random.nextInt(genders.size());
        genders.get(genderNumber).click();
    }

    public void setDateOfBirth(String yourDateOfBirth) {
        dateOfBirth.sendKeys(yourDateOfBirth);
    }
    public void setAddress (){
        address.sendKeys("555 Gund Dr, Chicago, IL");
    }

    public void setEmail(String emailInput) {
        email.sendKeys(emailInput);
    }

    public void setPassword (String passwordInput){
        password.sendKeys(passwordInput);
    }

    public void setCompany (String companyInput){
        company.sendKeys(companyInput);
    }

    public void selectRole(String yourRole) {

        Select selectRole = new Select(roles);
        selectRole.selectByVisibleText(yourRole);
    }

    public void selectExpectaition(String expect) {
        // expectations.clear();
        Select selectExpect = new Select(expectations);
        selectExpect.selectByVisibleText(expect);
    }


    public void waysRandom() {
        ways.clear();

        Random random = new Random();
        List<WebElement> ways = driver.findElements(By.xpath("//div/label/input[@type='checkbox']"));
        int count = 0;
        do {
            int number = random.nextInt(ways.size());
            if (ways.get(number).isSelected())
                continue;
            else
                ways.get(number).click();
            count++;
        }
        while (count <= 2);
    }
    public void setCommentInput(String commentInput){
        comment.sendKeys(commentInput);
    }
    public void clickSubmitButton (){
        submit.click();
    }

}

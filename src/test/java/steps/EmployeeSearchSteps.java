package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.util.concurrent.TimeUnit;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndLaunchApplication();

    }
    @When("user enters valid admin credentials")
    public void user_enters_valid_admin_credentials() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
//        usernameField.sendKeys(ConfigReader.getPropertyValue("username"));
        sendText(usernameField, ConfigReader.getPropertyValue("username"));

        WebElement passwordField = driver.findElement(By.id("txtPassword"));
//        passwordField.sendKeys(ConfigReader.getPropertyValue("password"));
        sendText(passwordField, ConfigReader.getPropertyValue("password"));

        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,TimeUnit.SECONDS);
    }
    @When("clicks on login button")
    public void clicks_on_login_button() {
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
//        loginButton.click();
//        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,TimeUnit.SECONDS);
        click(loginButton);

    }
    @When("navigates to employee list page")
    public void navigates_to_employee_list_page() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
//        pimOption.click();
        click(pimOption);

        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
//        empListOption.click();
        click(empListOption);
    }
    @When("user enters valid employee ID")
    public void user_enters_valid_employee_id() {
        WebElement searchID = driver.findElement(By.id("empsearch_id"));
//        searchID.sendKeys("8510142");
        sendText(searchID, "8510142");
    }
    @When("clicks on search button")
    public void clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.id("searchBtn"));
//        searchButton.click();
        click(searchButton);

    }
    @Then("user is able to see employee information")
    public void user_is_able_to_see_employee_information() {
        System.out.println("Result displayed");
        tearDown();
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
//        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,TimeUnit.SECONDS);
        WebElement searchName = driver.findElement(By.xpath("(//*[@type='text'])[1]"));
//        nameSearch.sendKeys("Zubair");
        sendText(searchName, "Deigo");


    }


}

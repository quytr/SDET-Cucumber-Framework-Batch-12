package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        Assert.assertTrue(dash.welcomeMessage.isDisplayed());
//        tearDown();
    }

    @When("user enters valid ESS username and password")
    public void user_enters_valid_ess_username_and_password() {
//        LoginPage login = new LoginPage();
//        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        sendText(login.usernameBox, "tts12345");

//        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText(login.passwordBox, "Hum@nhrm123");
    }

    @Then("ESS user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        // leaving it for validation
//        tearDown();
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
//        LoginPage login = new LoginPage();
//        WebElement usernameField = driver.findElement(By.id("txtUsername"));
//        usernameField.sendKeys(ConfigReader.getPropertyValue("username"));
        sendText(login.usernameBox, "tts12345");

//        WebElement passwordField = driver.findElement(By.id("txtPassword"));
//        passwordField.sendKeys(ConfigReader.getPropertyValue("password"));
        sendText(login.passwordBox, "Hum@nhrm");
    }

    @Then("user sees error message on the screen")
    public void user_sees_error_message_on_the_screen() {
        // homework - verify the error message
        errorMsgText(login.errorMessage);
//        tearDown();

    }








}

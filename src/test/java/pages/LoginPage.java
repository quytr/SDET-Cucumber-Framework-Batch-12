package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    // object repository
    @FindBy(id="txtUsername")
    public WebElement usernameBox;

    @FindBy(id="txtPassword")
    public WebElement passwordBox;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

    @FindBy(xpath = "//span[@id='spanMessage']")
    public WebElement errorMessage;

    // constructor
    // using PageFactory to initialize the elements
    public LoginPage() {

        PageFactory.initElements(driver,this);
    }
}

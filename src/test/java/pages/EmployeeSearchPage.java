package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOption;

    @FindBy(id="(//*[@type='text'])[1]")
    public WebElement nameField;

    @FindBy(xpath="empsearch_id")
    public WebElement idField;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    public EmployeeSearchPage(){
        PageFactory.initElements(driver,this);
    }
}

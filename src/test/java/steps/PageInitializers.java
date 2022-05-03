package steps;

import pages.AddEmployeePage;
import pages.EmployeeDetailPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializers {

    public static LoginPage login;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeDetailPage employeeDetailPage;

    public static void initializePageObjects(){
        login = new LoginPage();
        employeeSearchPage = new EmployeeSearchPage();
        addEmployeePage = new AddEmployeePage();
        employeeDetailPage = new EmployeeDetailPage();
    }
}

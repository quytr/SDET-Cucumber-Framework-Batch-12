package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTUzMzQ5MTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY1NTM3ODExNiwidXNlcklkIjoiMzc4MCJ9.hNKTJyGgpqeYcsq7zSMaPejJa0IqiHnVpQtm2V7tg3M";
    static String employee_id;

    @Test
    public void aCreateEmployee() {
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"Chris\",\n" +
                        "  \"emp_lastname\": \"Evan\",\n" +
                        "  \"emp_middle_name\": \"MS\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1985-11-06\",\n" +
                        "  \"emp_status\": \"active\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");

        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(201);

        //Hamcrest matchers
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        //Employee only works for post
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Chris"));

        // using jsonPath(), to specify the key in the body so that it returns the value against it
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

    }

    @Test
    public void bGetCreatedEmployee() {

        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        //employee works for get
        String tempID = response.jsonPath().getString("employee.employee_id");
        System.out.println(tempID);
        Assert.assertEquals(tempID, employee_id);

    }

    @Test
    public void cUpdateEmployee() {

        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"King\",\n" +
                        "  \"emp_lastname\": \"Earth\",\n" +
                        "  \"emp_middle_name\": \"MS1\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1990-06-06\",\n" +
                        "  \"emp_status\": \"LOE\",\n" +
                        "  \"emp_job_title\": \"Manager\"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void dGetUpdatedEmployee() {

        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void eGetAllEmployees() {

        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token);

        Response response = request.when().get("/getAllEmployees.php");

        // it returns string of response
        String allEmployees = response.prettyPrint();

        //jsonPath() vs jsonPath
        //jsonPath is a class that contains method for converting the values into json object
        //jsonPath() is a method belongs to jsonPath class

        //creating object of jsonPath class
        JsonPath js = new JsonPath(allEmployees);

        //retrieving the total number of employees.
        //Employees object that all the employees store in it
        int count = js.getInt("Employees.size()");
        System.out.println(count);

        // to print only employee id of all the employees
        for (int i = 0; i < count; i++) {
            String empID = js.getString("Employees[" + i + "].employee_id");
            System.out.println(empID);
        }
    }
}

























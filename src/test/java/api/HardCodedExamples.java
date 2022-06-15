package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTUyNDg1NTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY1NTI5MTc1MywidXNlcklkIjoiMzc4MCJ9.EpKOZZTJFApNeHFfVVWZymfz3xZfGeQNuBIENTR_ffc";

    @Test
    public void createEmployee() {
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

        Response response= request.when().post("/createEmployee.php");
        response.prettyPrint();



    }
}

























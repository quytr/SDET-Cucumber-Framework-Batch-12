package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload() {
        String createEmployee = "{\n" +
                "  \"emp_firstname\": \"Chris\",\n" +
                "  \"emp_lastname\": \"Evan\",\n" +
                "  \"emp_middle_name\": \"MS\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1985-11-06\",\n" +
                "  \"emp_status\": \"Active\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}";

        return createEmployee;
    }

    // passing the body from json object
    public static String createEmployeePayloadViaJson() {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Chris");
        obj.put("emp_lastname", "Evan");
        obj.put("emp_middle_name", "MS");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1985-11-06");
        obj.put("emp_status", "Active");
        obj.put("emp_job_title", "QA");

        return obj.toString();

    }

    public static String createEmployeeDynamic(String firstName, String lastName, String middleName, String gender,
                                               String dob, String status, String jobTitle) {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstName);
        obj.put("emp_lastname", lastName);
        obj.put("emp_middle_name", middleName);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", status);
        obj.put("emp_job_title", jobTitle);

        return obj.toString();
    }



}


















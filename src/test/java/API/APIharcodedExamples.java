package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class APIharcodedExamples {
    //setting the base uri
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    //token
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTEzNDEyMTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5MTM4NDQxMywidXNlcklkIjoiNTc0NyJ9.C0sktDKmnQD0zyH9MVocWvbLF1kF-A-2RerwjHo_-8k";

    @Test
    public void createEmployee(){
//    prepare the request
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"Borea\",\n" +
                        "  \"emp_lastname\": \"Groza\",\n" +
                        "  \"emp_middle_name\": \"MS\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1951-07-28\",\n" +
                        "  \"emp_status\": \"Employed\",\n" +
                        "  \"emp_job_title\": \"Plach Plach,Tansuy Tansuy\"\n" +
                        "}");
//    send the request
        Response response = request.when().post("/createEmployee.php");

        response.prettyPrint();
//   extract the employeeID
        String employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
//assertions
//    the employee_status is employed

        String employee_status= response.jsonPath().getString("Employee.emp_status");
        Assert.assertEquals("Employed",employee_status );

    }
}
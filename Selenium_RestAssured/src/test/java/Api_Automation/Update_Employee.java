package Api_Automation;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class Update_Employee {
    Create_Employee employee = new Create_Employee();
    Integer EmployeeNum;
    Faker fake = new Faker();
    String First_Name = fake.name().firstName();
    String Last_Name = fake.name().lastName();
    String Middle_Name = fake.name().name();
    String Employee_Id;
    Response Create_Employee;

@Given("perform the api of update employee")
    public void Update_Employee(){
        employee.Create_New_Employee();
        EmployeeNum = employee.EmployeeNum;
        Employee_Id = employee.Employee_Id;
        String Body_Request ="{\"lastName\":\""+Last_Name+"\"," +
                "\"firstName\":\""+First_Name+"\"," +
                "\"middleName\":\""+Middle_Name+"\"," +
                "\"employeeId\":\""+Employee_Id+"\"," +
                "\"otherId\":\"5\"," +
                "\"drivingLicenseNo\":\"5845\"," +
                "\"drivingLicenseExpiredDate\":\"2025-08-31\"," +
                "\"gender\":\"1\"," +
                "\"maritalStatus\":\"Single\"," +
                "\"birthday\":\"1999-11-30\"," +
                "\"nationalityId\":55," +
                "\"sinNumber\":\"01452144\"}";

        Create_Employee = RestAssured.given()
                .baseUri("https://opensource-demo.orangehrmlive.com")
                .basePath("/web/index.php/api/v2/")
                .header("Content-Type","application/json")
                .header("Cookie","orangehrm=486544069e25866c7652fd7cd2a77ed5")
                .pathParam("empNumber",EmployeeNum)
                .body(Body_Request)
                .when()
                .post("pim/employees/{empNumber}/personal-details");
    }

    @Then("verify that employee updated successfuly")
    public void validate_Employee_Updated(){
        Create_Employee.prettyPrint();
        Create_Employee.then()
                .statusCode(HttpStatus.SC_OK);
    }}

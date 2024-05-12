package Api_Automation;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class Create_Employee {
    public Integer EmployeeNum;
    public String EmployeeName;
    Faker fake = new Faker();
    String First_Name = fake.name().firstName();
    String Last_Name = fake.name().lastName();
    String Middle_Name = fake.name().name();
    String Employee_Id = String.valueOf(fake.idNumber());
    Response Create_Employee;
    String Body_Request ="{\"firstName\":\""+First_Name+"\"," +
            "\"middleName\":\""+Middle_Name+"\"," +
            "\"lastName\":\""+Last_Name+"\"," +
            "\"empPicture\":null," +
            "\"employeeId\":\""+Employee_Id+"\"}";

@Given("perform the api of create new employee")
    public void Create_New_Employee(){
         Create_Employee = RestAssured.given()
                .baseUri("https://opensource-demo.orangehrmlive.com")
                .basePath("/web/index.php/api/v2/")
                .header("Content-Type","application/json")
                .header("Cookie","orangehrm=486544069e25866c7652fd7cd2a77ed5")
                .body(Body_Request)
                .when()
                .post("pim/employees");
         EmployeeNum = Create_Employee.then().extract().path("employeeId");
         EmployeeName = Create_Employee.then().extract().path("EmployeeName");
    }

@Then("verify that employee created successfully")
    public void validate_Employee_Created(){
        Create_Employee.prettyPrint();
        Create_Employee.then()
                .statusCode(HttpStatus.SC_CREATED);
    }
}

package Ui_Automation;

import Pages.Contact_Details;
import Pages.Employee_Info;
import Pages.Home_Page;
import Pages.Login_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ContactDetails_Test extends Test_Base{
    String user_name = "Admin";
    String password = "admin123";
    Login_Page login = new Login_Page(driver);
    Home_Page home = new Home_Page(driver);
    Employee_Info employeeInfo = new Employee_Info(driver);
    Contact_Details details = new Contact_Details(driver);

    public ContactDetails_Test() throws FileNotFoundException {
    }

    @Given("User can Login Successfully")
//    @Test(priority=1,alwaysRun=true)
    public void User_Can_Login (){
        login.Login(user_name,password);
    }

    @And("User can Search by employee data")
//    @Test(dependsOnMethods= {"User_Can_Login"})
    public void User_can_Add_Contact_Details (){
        home.Open_PIM();
        employeeInfo.Search_By_Employee();

    }

    @When("User Open the Selected Employee To Add Details")
    public void User_Can_Add_Contact_Details (){
        employeeInfo.Open_Selected_Employee();
        details.Fill_Employee_Data();
    }

    @Then("I verify the appearance of success message")
    public void Validate_Success_Message(){
        details.Validate_SuccessMessage();

    }


}

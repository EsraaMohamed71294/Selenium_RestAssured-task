package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Employee_Info extends Page_Base{
    public Employee_Info(WebDriver driver) {
        super();
    }

    @FindBy(xpath="//label[contains(text(),'Employee Name')]//..//..//input")
    WebElement Employee_Name ;

    @FindBy(xpath="//label[contains(text(),'Employee Id')]//..//..//input")
    WebElement Employee_Id ;

    @FindBy(xpath="//button[@type='submit']")
    WebElement Search ;

    @FindBy(xpath="//*[@class='oxd-table-card']//button[2]")
    WebElement Edit_Employee ;

    public void Search_By_Employee()
    {   Create_Employee();
        setTextElementText(Employee_Name,EmployeeName);
        setTextElementText(Employee_Id,EmployeeID);
        clickButton(Search);
    }

    public void Open_Selected_Employee()
    {
        clickButton(Edit_Employee);
    }
}

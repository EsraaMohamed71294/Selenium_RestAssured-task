package Pages;

import Api_Automation.Create_Employee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Page_Base {
    public String EmployeeID;
    public String EmployeeName;
    Create_Employee employee = new Create_Employee ();
    protected WebDriver driver ;
    public Select select ;
    public Action action ;

    public Page_Base()
    {
        PageFactory.initElements(driver, this);
    }

    protected static void clickButton(WebElement button)
    {
        button.click();
    }

    protected static void setTextElementText(WebElement textElement , String value)
    {
        textElement.sendKeys(value);
    }


    public void clearText(WebElement element)
    {
        element.clear();
    }

    public void Create_Employee () {
        employee.Create_New_Employee();
        EmployeeID = employee.EmployeeNum;
        EmployeeName = employee.EmployeeName;

    }

}

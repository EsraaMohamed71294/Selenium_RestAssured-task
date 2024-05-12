package Pages;

import com.fasterxml.jackson.annotation.JsonValue;
import dev.failsafe.internal.util.Assert;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Contact_Details extends Page_Base{

    public Contact_Details(WebDriver driver) throws FileNotFoundException {
        super();
    }
    String JSONFile = "src/test/Resources/TestData/Employee_Data.json";
    JSONObject data = (JSONObject) JsonValue(new FileReader(JSONFile));


    @FindBy(xpath="//*[@class='orangehrm-tabs']//*[contains(text(),'Contact Details')]")
    WebElement Contact_Details ;

    @FindBy(xpath="//label[contains(text(),'Street 1')]//..//..//input")
    WebElement Street1_Field ;

    @FindBy(xpath="//label[contains(text(),'Street 2')]//..//..//input")
    WebElement Street2_Field ;

    @FindBy(xpath="//label[contains(text(),'City')]//..//..//input")
    WebElement City_Field ;

    @FindBy(xpath="//label[contains(text(),'Country')]//..//..//input")
    WebElement Country_Field ;

    @FindBy(xpath="//label[contains(text(),'State/Province')]//..//..//input")
    WebElement State_Province_Field ;

    @FindBy(xpath="//label[contains(text(),'Zip/Postal Code')]//..//..//input")
    WebElement Zip_Postal_Field ;

    @FindBy(xpath="//label[contains(text(),'Mobile')]//..//..//input")
    WebElement Mobile_Field ;

    @FindBy(xpath="//label[contains(text(),'Work')]//..//..//input")
    WebElement Work_Field ;

    @FindBy(xpath="//label[contains(text(),'Home')]//..//..//input")
    WebElement Home_Field ;

    @FindBy(xpath="//*[@type='submit']")
    WebElement Submit_Button ;

  

    public void Fill_Employee_Data(){
        setTextElementText(Street1_Field,data['Street1']);
        setTextElementText(Street2_Field,data['Street2']);
        setTextElementText(City_Field,data['City']);
        setTextElementText(Country_Field,data['Country']);
        setTextElementText(State_Province_Field,data['State/Province']);
        setTextElementText(Zip_Postal_Field,data['Zip/Postal']);
        setTextElementText(Mobile_Field,data['Mobile']);
        setTextElementText(Work_Field,data['Work']);
        setTextElementText(Home_Field,data['Home']);
        clickButton(Submit_Button);
    }

    public void Validate_SuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oxd-toaster_1")));
        String expectedMessage = "Successfully Updated";
        String actualMessage = successMessage.getText();
        assert(actualMessage.contains(expectedMessage));
    }
}

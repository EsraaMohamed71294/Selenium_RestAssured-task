package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Page_Base {

    public Login_Page(WebDriver driver) {
        super();
    }

    @FindBy(xpath="//input[@name='username']")
    WebElement username ;

    @FindBy(xpath="//input[@type='password']")
    WebElement password ;

    @FindBy(xpath="//button[@type='submit']")
    WebElement login ;

    public void Login(String user , String pass)
    {
        setTextElementText(username, user);
        setTextElementText(password, pass);
        clickButton(login);
    }

}

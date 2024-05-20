package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends Page_Base {

    public Home_Page(WebDriver driver) {
        super();
    }

    @FindBy(xpath="(//a[contains(@href,'pim')])[1]")
    WebElement PIM ;

    public void Open_PIM()
    {
       PIM.click();
    }
}

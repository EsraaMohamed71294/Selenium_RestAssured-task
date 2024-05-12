package Ui_Automation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_Base {

    ChromeDriver driver;

//    @BeforeSuite
//    @Test
    @Given("User Navigate to the website")
    public void set_driver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hussein\\Downloads\\esraa tasks\\api_auto\\Api_Automation-Kickout\\src\\test\\Resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/contactDetails/");
    }

//    @AfterSuite
    @And("User Stop Driver")
    public void stopDriver(){
        driver.quit();
}
}

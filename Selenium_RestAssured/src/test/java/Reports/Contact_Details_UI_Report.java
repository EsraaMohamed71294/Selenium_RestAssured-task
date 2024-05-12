package Reports;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"Selenium_RestAssured/src/test/Resources/Features/Ui_Features"}
        ,glue = "Ui_Automation"
        ,plugin = {"pretty", "html:target/Reports/Ui_Automation_Reports"})

public class Ui_Automation_Reports extends AbstractTestNGCucumberTests {
}

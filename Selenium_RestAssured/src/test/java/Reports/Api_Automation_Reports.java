package Reports;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"Selenium_RestAssured/src/test/Resources/Features/API_Features"}
        ,glue = "Api_Automation"
        ,plugin = {"pretty", "html:target/Reports/Api_Automation_Reports.html"})

public class Api_Automation_Reports extends AbstractTestNGCucumberTests {
}




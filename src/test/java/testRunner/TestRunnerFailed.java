package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 


@CucumberOptions(tags = "",
        features = "@target/rerun.txt",
        glue = "com.example.definitions",
        plugin =  {
                "pretty",
                "html:target/cucumber-reports/cucumber-rerun1-report.html",
                "json:target/cucumber-reports/cucumber-rerun1-report.json",
        }
)
 
public class TestRunnerFailed extends AbstractTestNGCucumberTests {
}

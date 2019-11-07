
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"stepdefs"})

public class TestRun extends AbstractTestNGCucumberTests {
}

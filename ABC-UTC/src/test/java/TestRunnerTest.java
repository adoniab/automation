import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report.html"// Ensure the path matches
        },
        features = "src/test/resources/Features",
        glue = "stepDefinitions" // Adjust this to your step definitions package
)
public class TestRunnerTest {
}


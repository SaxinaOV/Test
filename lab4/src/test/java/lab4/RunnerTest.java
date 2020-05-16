package lab4;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/home/olga/Works/Testing/lab4",
        glue = "lab4"
)

public class RunnerTest {
}
package stepDef;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {"pretty"},
        plugin = { "pretty", "html:target/cucumber-reports" },
        strict = true,
        features = {"src/test/resources"}
        )
public class RunCucumberTest {
}

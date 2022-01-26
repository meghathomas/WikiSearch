package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/features",
        glue= {"stepDefinitions"},
        plugin={"pretty","json:target/jsonReports/cucumber-report.json","html:target/cucumber-html-report","junit:target/MyReports/report.xml"},
        monochrome=true,
        publish = true
)

public class TestRunner {

}

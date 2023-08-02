package cucumber.Option;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature", glue = ("stepdefination"), plugin = "json:target/test/jsonReports.json")

public class TestRunner {

}

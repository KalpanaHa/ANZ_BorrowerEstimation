package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src//test//java//FeatureFiles" }, glue = { "StepDef" },dryRun=false, plugin = {"pretty", "html:target/Destination.html"} )
public class TestRunner {

}

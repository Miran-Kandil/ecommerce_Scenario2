package testrun;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/add_to_cart.feature"},
		glue = {"stepdef", "hook"},
		plugin = {"pretty","html:target/HtmlReports.html"},
		monochrome = true,
		dryRun = false
		)

public class TestRunner {
	

}

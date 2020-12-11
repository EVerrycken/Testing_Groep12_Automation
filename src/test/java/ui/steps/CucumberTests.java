package ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features"},
        glue={"ui/steps"},
        plugin={"json:target/ui-test.json"}
)

public class CucumberTests {

}
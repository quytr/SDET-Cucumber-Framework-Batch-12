package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        // features we use to provide the path of all the feature files
        features = "@target/failed.txt",

        // glue is where we find implementations for Gherkin steps
        // we provide the path of package to get all the step definitions
        glue = "steps",

        // dryRun we use to get the step definitions of undefined steps
        // if we set it to true, it will quickly scan all Gherkin steps whether they are implemented or not
        // if we set it to true, it stops actual execution
        // to execute scripts in real time, we should set this value to false
        dryRun = false,

        // it means the console output for cucumber test is having irrelevant information
        // when we set it to true, it simply removes akk the irrelevant information
        monochrome = true,

        // html report will be generated under target folder
        plugin = {"pretty"}


)

public class FailedRunner {
}

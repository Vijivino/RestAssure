package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Feature/UserRequests.feature",glue="stepdefenition",monochrome=true,strict=true)

public class UserRequestTest {
 
}

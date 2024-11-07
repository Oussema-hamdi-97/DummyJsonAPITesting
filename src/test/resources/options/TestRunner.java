    package options;

    import io.cucumber.junit.Cucumber;
    import io.cucumber.junit.CucumberOptions;
    import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/test/resources/features",glue = "stepdefinitions",plugin = {
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-reports.html"},monochrome = true)
    //tags = "@invalidTestProduct"
    public class TestRunner {
    }

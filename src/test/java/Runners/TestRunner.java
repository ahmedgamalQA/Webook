package Runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/Features/WebookScenarios.feature"
        },
        glue = {
                "StepDefinitions"
        },
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "Listeners.ListenerImplementor"
        }
)
public class TestRunner {
}

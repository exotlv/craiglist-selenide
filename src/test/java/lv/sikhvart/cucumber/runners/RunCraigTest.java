package lv.sikhvart.cucumber.runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/cheese", "json:target/cucumber/cucumber-cheese.json"},
        features = {"src/test/resources/features"},
        tags = {"@all"},
        glue = {"lv.sikhvart.cucumber.stepdefs", "lv.sikhvart.cucumber.hooks"}
)
public class RunCraigTest {

}
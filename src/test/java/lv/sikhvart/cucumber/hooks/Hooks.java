package lv.sikhvart.cucumber.hooks;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;
import lv.sikhvart.cucumber.core.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public class Hooks {

    @Before
    public void setup(Scenario scenario) throws Exception {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.getDriver();
        WebDriverRunner.setWebDriver(driver);
        String sessionId = ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId().toString();
        log.info("Starting Scenario: \""+ scenario.getName() +"\" with Session ID: " + sessionId);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.timeout = 4000;//default is 4000
//        Configuration.baseUrl = "http://" + environmentConfig.uiBackendHost() +":" + environmentConfig.uiBackendPort();
        Configuration.driverManagerEnabled = true;
        Configuration.startMaximized = true;// does not work when providing own driver
        Configuration.reportsFolder = "target/selenide-reports/tests";//default is build/reports/tests
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        String sessionId = ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId().toString();
        log.info("Ending Scenario: \""+scenario.getName() +"\" with Session ID: " + sessionId);
        WebDriverRunner.closeWebDriver();
    }
}

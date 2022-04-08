import org.junit.jupiter.api.AfterAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.WebDriver;


public class TestBase {
    private static Logger logger = LoggerFactory.getLogger("TestBase.class");
    protected static WebDriver driver;
    private static AppProperties appProperties;
    private static BrowserEnvironment browserEnvironment;

    @BeforeAll
    static void BeforeAll() {
        appProperties = new AppProperties();
        browserEnvironment = new BrowserEnvironment();
        driver=browserEnvironment.getDriver();
        logger.info("<<<<<<<<<<<<<<<<<< Driver started successfully");
        logger.info("<<<<<<<<<<<<<<<<<< NOTE: Test is executed on environment: "+System.getProperty("env_name"));
        driver.get(System.getProperty("appUrl"));
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        logger.info("<<<<<<<<<<<<<<<<<<Driver closed properly");
    }
}
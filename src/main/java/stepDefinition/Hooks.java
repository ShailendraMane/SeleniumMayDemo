package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {

    Logger log= LogManager.getLogger();
   public static WebDriver driver;
    @Before(order = 0)
    public void launchDriver()
    {
        log.info("before0");
        log.info("Opening browser");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }

    @Before(order = 1)
    public void before1()
    {
        driver.manage().window().maximize();
        log.info("before 1");
    }

    @After(order = 1)
    public void aftet1()
    {
        log.info("after1");
    }
    @After(order = 0)
    public void closeBrowser()
    {
        log.info("after 0");
        driver.quit();

        log.info("Closing browser");
    }

}

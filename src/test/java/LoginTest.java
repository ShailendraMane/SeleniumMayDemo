import stepDefinition.ReadPropertiesData;
import com.example.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class LoginTest {

    public  static Logger log =LogManager.getLogger();
    public static void main(String[] args) throws IOException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        log.info("driver launched ");
        String url=ReadPropertiesData.getPropertyValue("Preprod","loginurl");
        driver.navigate().to(url.trim());
        driver.manage().window().maximize();
        Logger logger = LogManager.getLogger();
        LoginPage login =new LoginPage(driver);
        logger.info("Login page");
      //  login.login(ReadPropertiesData.getPropertyValue("Preprod","username"),ReadPropertiesData.getPropertyValue("Preprod","password"));
        logger.info("login success");
    }
}

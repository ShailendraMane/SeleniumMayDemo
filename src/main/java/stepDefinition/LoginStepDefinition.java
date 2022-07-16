package stepDefinition;

import com.example.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class LoginStepDefinition {

    Logger log= LogManager.getLogger();

   LoginPage login;
    WebDriver driver;
    public LoginStepDefinition()
    {
        this.driver= Hooks.driver;
        login =new LoginPage(driver);

    }

    @Given("open browser and enter the valid url {string}")
    public void open_browser_and_enter_the_valid_url(String url) {

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        log.info("driver launched ");
//        driver.get(url);
//        driver.manage().window().maximize();
      driver.get(url);

    }


    @Given("open browser and enter the valid urlvalue")
    public void open_browser_and_enter_the_valid_urlvalue() throws IOException {
//        WebDriverManager.chromedriver().setup();
//       driver = new ChromeDriver();
//        log.info("driver launched ");
//        driver.get(ReadPropertiesData.getPropertyValue("preprod","loginurl"));
//        driver.manage().window().maximize();
      //  login =new LoginPage(driver);
        driver.get(ReadPropertiesData.getPropertyValue("preprod","loginurl"));
    }
    @When("enter username {string} and password {string}")
    public void enter_username_and_password(String username, String password) {

        login.enterUserName(username);
        login.enterPassword(password);

    }
    @And("click on submit button")
    public void click_on_submit_button() throws InterruptedException {
        login.clickOnSubmit();
    }
    @Then("verify login successful {string}")
    public void verify_login_successful(String expectedValue) {

        login.validateLoginPage(expectedValue);
    }

    @When("enter valid username and valid password")
    public void enter_valid_username_and_valid_password(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<String> keys=dataTable.asList();
       String username1= keys.get(0);
       log.info("Username1"+username1);
       String password1=keys.get(1);
       log.info("Password1"+password1);

        login.enterUserName(username1);
        login.enterPassword(password1);


    }

}

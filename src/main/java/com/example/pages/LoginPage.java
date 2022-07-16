package com.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="email")
    WebElement username;

    @FindBy(id="pass")
    WebElement password;

    @FindBy(xpath="//button[@title='Login']")
    WebElement submit;
    Logger logger = LogManager.getLogger();
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String usernamevalue)
    {
        username.sendKeys(usernamevalue);
        logger.info("Username",usernamevalue);
    }

    public void enterPassword(String pass)
    {
        password.sendKeys(pass);
        logger.info("Password",pass);

    }

    public void clickOnSubmit() throws InterruptedException {
        Thread.sleep(1000);
        submit.click();
        logger.info("submit");
    }

    public void validateLoginPage(String expectedValue)
    {
        Assert.assertEquals(expectedValue,driver.getCurrentUrl().trim());
    }
//    public void login(String username1,String password1)
//    {
//       // WebElement el=driver.findElement(By.id("email"));
//        username.sendKeys(username1);
//        logger.info("Username",username1);
//
//        password.sendKeys(password1);
//
//       // driver.findElement(By.xpath("//button[@title='Login']")).click();
//        submit.click();
//    }

}

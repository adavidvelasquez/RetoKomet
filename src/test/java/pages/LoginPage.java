package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userName = By.xpath("//*[@tabindex='1']");
    By userPwd = By.cssSelector("#login > div > input[type=password]");

    By loginButton = By.xpath("//*[@tabindex='3']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setUserName(String textUserName) {
        driver.findElement(userName).sendKeys(textUserName);
    }

    public void setUserPwd(String textUserPwd) {
        driver.findElement(userPwd).sendKeys(textUserPwd);
    }

    public void loginToTestimio(String textName , String text_pwd){
        setUserName(textName);
        setUserPwd(text_pwd);
        driver.findElement(loginButton).click();
    }
}

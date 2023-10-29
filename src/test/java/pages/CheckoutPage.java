package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By customerName = By.xpath("//*[@type='text' and @maxlength='30']");
    By customerEmail = By.xpath("//*[@type='email']");
    By socialSec = By.xpath("(//*[@type='text' and @class='theme__inputElement___27dyY'])[1]");
    By phoneNum = By.xpath("//*[@type='tel']");
    By checkBox = By.xpath("//*[text()='I agree to the terms and conditions']");

    By payNowButton = By.xpath("//*[text()='Pay now']");

    public void setCustomerName(String txtCustomerName) {
        driver.findElement(customerName).sendKeys(txtCustomerName);
    }

    public void setCustomerEmail(String txtCustomerEmail) {
        driver.findElement(customerEmail).sendKeys(txtCustomerEmail);
    }

    public void setSocialSec(String txtSocialSec) {
        driver.findElement(socialSec).sendKeys(txtSocialSec);
    }

    public void setPhoneNum(String txtPhoneNum) {
        driver.findElement(phoneNum).sendKeys(txtPhoneNum);
    }

    public void payNowAct()  {
        driver.findElement(checkBox).click();
       //ait.until(ExpectedConditions.elementToBeClickable(payNowButton)).click();
    }
}

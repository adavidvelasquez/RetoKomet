package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpaceHomePage {

    WebDriver driver;
    WebDriverWait wait;

    By departingDate = By.xpath("(//input[@type='text'])[1]");
    By returningDate = By.xpath("(//input[@type='text'])[2]");
    By buttonOk = By.xpath("//button[text()='Ok']");

    By adultsNum = By.xpath("//input[@value='Adults (18+)']");
    By childrenNum = By.xpath("//input[@value='Children (0-7)']");
    By selectDestButton = By.xpath("//button[text()='Select Destination']");

    public SpaceHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setDepartingDate() {
        driver.findElement(departingDate).click();
    }

    public void setReturningDate() {
        driver.findElement(returningDate).click();
    }

    public void setAdultsNum(By adultsNum) {
        this.adultsNum = adultsNum;
    }


    public void SetDates() throws InterruptedException {
        setDepartingDate();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='29']"))).click();
        driver.findElement(buttonOk).click();
        Thread.sleep(2000);
        setReturningDate();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='6']"))).click();
        driver.findElement(buttonOk).click();
    }

    public void setAdultNum() throws InterruptedException {
        driver.findElement(adultsNum).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='4'])[1]"))).click();
        Thread.sleep(2000);
    }

    public void setChildrenNum() throws InterruptedException {
        driver.findElement(childrenNum).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='4'])[2]"))).click();
        driver.findElement(selectDestButton).click();
        Thread.sleep(2000);
    }
}

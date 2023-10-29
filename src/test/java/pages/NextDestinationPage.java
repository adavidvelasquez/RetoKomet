package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NextDestinationPage {

    WebDriver driver;
    WebDriverWait wait;


    public NextDestinationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    By launch = By.xpath("//input[@value='Launch']");
    By planetColor = By.xpath("//input[@value='Planet color']");
    By bookButton = By.xpath("//button[text()='Book']");

    public void setLaunch() {
        driver.findElement(launch).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Shenji']"))).click();

    }

    public void setPlanetColor() {
        driver.findElement(planetColor).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Red']"))).click();

    }

    public void setBookButton() throws InterruptedException {
       driver.findElement(bookButton).click();
        Thread.sleep(2000);
    }
}

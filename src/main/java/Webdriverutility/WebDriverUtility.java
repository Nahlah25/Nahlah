package Webdriverutility;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

    public void waitForPageToLoad(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void switchToFrame(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrame(WebDriver driver, String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrame(WebDriver driver, WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void switchToAlertAndAccept(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void switchToAlertAndDismiss(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String switchToAlertAndGetText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void switchToAlertAndSendKeys(WebDriver driver, String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void selectByIndex(WebElement element, int index) {
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }

    public void selectByValue(WebElement element, String value) {
        Select sel = new Select(element);
        sel.selectByValue(value);
    }

    public void selectByVisibleText(WebElement element, String text) {
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    public void mouseHoverOnWebElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    public void clickOnWebElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).click().perform();
    }

    public void doubleClickOnWebElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.doubleClick(element).perform();
    }

    public void rightClickOnWebElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.contextClick(element).perform();
    }

    public void passInput(WebDriver driver, WebElement element, String text) {
        Actions act = new Actions(driver);
        act.click(element).sendKeys(text).perform();
    }

    public void switchToWindow(WebDriver driver) {
        Set<String> allWindowIds = driver.getWindowHandles();
        for (String id : allWindowIds) {
            driver.switchTo().window(id);
        }
    }

    public void takeScreenshot(WebDriver driver, String filename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File temp = ts.getScreenshotAs(OutputType.FILE);
        File perm = new File("./errorShots/" + filename + ".png");
        org.openqa.selenium.io.FileHandler.copy(temp, perm);
    }

    public void scrollBy(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }
}

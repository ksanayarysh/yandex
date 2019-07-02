package Lesson8.models;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class MainPage extends BasePage{
    public MainPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public int bookCount() throws InterruptedException {
        int bookCount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("div.lego-book"))).size();
        while (true) {
            ((JavascriptExecutor) wd).executeScript("document.getElementsByClassName(\"c-default-button m-small\")[0].click();");
            sleep(5000);
            int newBookCount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.cssSelector("div.lego-book"))).size();
            if (newBookCount == bookCount) break;
            bookCount = newBookCount;
        }
        return bookCount;
    }
}

package Lesson8.models;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Lesson8.locators.Locator.all_books;

public class MainPage extends BasePage{
    public MainPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public List<WebElement> bookCount() {
        while (true) {
            ((JavascriptExecutor) wd).executeScript("document.getElementsByClassName('c-default-button m-small')[0].click();");
            WebElement spin = wd.findElement(By.cssSelector(".js-page-loader.page-loader"));
            if (!spin.isDisplayed()) break;
        }
        return wd.findElements(all_books);
    }
}

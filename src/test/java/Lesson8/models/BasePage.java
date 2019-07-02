package Lesson8.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver wd;
    protected WebDriverWait wait;

    public BasePage(WebDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }
}

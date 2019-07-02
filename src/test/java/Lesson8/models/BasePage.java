package Lesson8.models;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver wd;

    public BasePage(WebDriver wd) {
        this.wd = wd;
    }
}

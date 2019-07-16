package Lesson8.locators;

import org.openqa.selenium.By;

public class Locator {
    public static By all_books = By.cssSelector("div.lego-book");

    public static By book_name = By.cssSelector("div.l-book-description.position-top div.b-headers");
    public static By book_author = By.cssSelector("div.l-book-description.position-top span.author.active");
    public static By audio_price = By.cssSelector("div[ng-if=\"bookData.types.audiobook.sale\"] div.p-tab__price.ng-binding");
    public static By download_link = By.className("nkk-file-download__link");
}

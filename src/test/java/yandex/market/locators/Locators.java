package yandex.market.locators;

import org.openqa.selenium.By;

public class Locators {

    public static By phonesToCompare = By.xpath("//div[contains(@class, 'n-compare-content__line i-bem n-compare-content__line_js_inited')]/div");
    public static By allCharac = By.xpath("//span[contains(text(), \"все характеристики\")]");
    public static By os = By.xpath("//div[contains(text(), \"Операционная система\")]");
    public static By diffCharac = By.xpath("//span[contains(text(), \"различающиеся характеристики\")]");


    public static By allCategories = By.xpath("//span[contains(text(), \"Все категории\")]");
    public static By mobilePhones = By.xpath("//a[contains(text(), \"Мобильные телефоны\")]");
    public static By sortByPrice = By.xpath("//a[contains(text(), \"по цене\")]");

    public static By allPhones = By.cssSelector("div[class*=\"n-filter-applied-results\"] div[class*=\"n-snippet-cell2 \"]");
    public static By addToCompare = By.xpath("//span[contains(text(), \"Сравнить\")]/parent::div\"");
    public static By notification = By.cssSelector("div[class=\"popup-informer__pane popup-informer__pane_type_notify\"]");
    public static By openComparePage = By.xpath("//span[contains(text(), \"Сравнение\")]");

    public static By manufacturerBox = By.xpath("//legend[contains(text(), \"Производитель\")]/..");
    public static By manufacturers = By.cssSelector("div[class=LhMupC0dLR]");

}

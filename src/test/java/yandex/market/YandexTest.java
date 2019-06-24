package yandex.market;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yandex.market.models.CompPage;
import yandex.market.models.NavigatorPage;
import yandex.market.models.ProductsPage;

import static java.lang.Thread.sleep;


public class YandexTest extends BaseTest {

    String man1 = "Samsung";
    String man2 = "Xiaomi";
    private static final Logger logger = LoggerFactory.getLogger(YandexTest.class);

    @Test
    public void test() throws InterruptedException {
        ProductsPage page = new ProductsPage(driver, wait).init()
                .allCatsClick()
                .phoneCellsClick();

        new NavigatorPage(driver, wait).filterManufacturer(man1, man2).sortByPrice();

        logger.info("manufacturer filtered");

        sleep(2000);

        page.getPhoneChosen(man1);
        logger.info(man1 + " chosen");
        page.getPhoneChosen(man2);
        logger.info(man2 + " chosen");

        CompPage compPage = new CompPage(driver, wait);
        logger.info("comp page opened");
        compPage.checkPhoneAmount(2);
        logger.info("amount checked");
        compPage.checkOSifAllCharacteristics();
        logger.info("os");
        compPage.checkOSifDiffCharacteristics();
        logger.info("no os");

        logger.info("----end----");

    }
}

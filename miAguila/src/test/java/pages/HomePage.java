package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserManager;
import utils.Common;

public class HomePage {
    private final String hola = "//div[2]/div/div/div/div/div/span[1][contains(.,'Hola')]";
    private final String welcomeMessageUserLbl = hola + "/../span[contains(.,'%s')][1]";
    public HomePage() {
    }

    public WebElement getWelcomeMessageUser(String user) {
        return BrowserManager.findWebElementWait(By.xpath(String.format(welcomeMessageUserLbl, user))); }
}

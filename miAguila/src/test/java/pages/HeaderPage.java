package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserManager;

public class HeaderPage {
    private WebElement direccionLbl;
    private WebElement ingresarLnk;

    public HeaderPage() {
        direccionLbl = BrowserManager.findWebElementWait(By.xpath("//div[2]/div[1]/span/../button/../span"));
        ingresarLnk = BrowserManager.findWebElementWait(By.xpath("//div[2]/div/div/a/span[contains(.,'Ingresar')]"));
    }

    public WebElement getIngresar() {
        return ingresarLnk;
    }

    public WebElement getDireccion() {
        return direccionLbl;
    }
}

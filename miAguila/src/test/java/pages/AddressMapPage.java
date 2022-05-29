package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserManager;
import utils.Common;

public class AddressMapPage {
    private WebElement guardarBtn;

    public AddressMapPage() {
        guardarBtn = BrowserManager.findWebElementWait(By.xpath("//button[@aria-label='Guardar']/span[contains(.,'Guardar')]"));
    }

    public void guardarClickJS() {
        guardarBtn.submit();
        Common.clickJS(guardarBtn);
    }
}

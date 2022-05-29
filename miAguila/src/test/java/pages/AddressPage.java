package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.BrowserManager;


public class AddressPage {
    private WebElement ciudadTxt;
    private WebElement direccionPart1Txt;
    private WebElement direccionPart2Txt;
    private WebElement direccionPart3Txt;

    private WebElement buscarBtn;



    public AddressPage () {
        ciudadTxt = BrowserManager.findWebElementWait(By.cssSelector("input[placeholder='Seleccione una ciudad']"));
        direccionPart1Txt = BrowserManager.findWebElementWait(By.cssSelector("input[placeholder='23A Sur']"));
        direccionPart2Txt = BrowserManager.findWebElementWait(By.cssSelector("input[placeholder='# 00']"));
        direccionPart3Txt = BrowserManager.findWebElementWait(By.cssSelector("input[placeholder='-00']"));
        buscarBtn = BrowserManager.findWebElementWait(By.cssSelector("button[aria-label='BUSCAR']"));
    }

    public WebElement getDireccionPart1() { return direccionPart1Txt; }

    public WebElement getDireccionPart2() { return direccionPart2Txt; }

    public WebElement getDireccionPart3() { return direccionPart3Txt; }

    public WebElement getBuscar() { return buscarBtn; }

    public void setCiudad(String bogotá) {
        ciudadTxt.sendKeys(bogotá);
        ciudadTxt.sendKeys(Keys.DOWN);
        ciudadTxt.sendKeys(Keys.ENTER);
    }
}

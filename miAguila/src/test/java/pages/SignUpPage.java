package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserManager;
import utils.Common;

public class SignUpPage {
    private WebElement nombreTxt;
    private WebElement apellidoTxt;
    private WebElement nroDocumentoTxt;
    private WebElement emailTxt;
    private WebElement telefonoTxt;
    private WebElement contraseniaTxt;
    private WebElement repitaContraseniaTxt;
    private WebElement aceptoPoliticaChk;
    private WebElement crearCuentaBtn;

    public SignUpPage() {
        nombreTxt = BrowserManager.findWebElementWait(By.cssSelector("Input[placeholder='Escribe tu nombre']"));
        apellidoTxt = BrowserManager.findWebElementWait(By.cssSelector("Input[placeholder='Escribe tu primer apellido'] "));
        nroDocumentoTxt = BrowserManager.findWebElementWait(By.cssSelector("input[type='number']"));
        emailTxt = BrowserManager.findWebElementWait(By.cssSelector("input[type='email']"));
        telefonoTxt = BrowserManager.findWebElementWait(By.cssSelector("input[type='phone']"));
        contraseniaTxt = BrowserManager.findWebElementWait(By.cssSelector("input[type='password'][placeholder='Escribe tu contraseña']"));
        repitaContraseniaTxt = BrowserManager.findWebElementWait(By.cssSelector("input[type='password'][placeholder='Confirma tu contraseña']"));
        aceptoPoliticaChk = BrowserManager.findWebElementWait(By.cssSelector("input[type='checkbox']"));
        crearCuentaBtn = BrowserManager.findWebElementWait(By.xpath("//button[@aria-label='Crear Cuenta']/span[1]"));
    }

    public WebElement getNombre() {
        return nombreTxt;
    }

    public WebElement getApellido() {
        return apellidoTxt;
    }

    public WebElement getNroDocumento() {
        return nroDocumentoTxt;
    }

    public WebElement getEmail() {
        return emailTxt;
    }

    public WebElement getTelefono() {
        return telefonoTxt;
    }

    public WebElement getContrasenia() {
        return contraseniaTxt;
    }

    public WebElement getRepitaContrasenia() {
        return repitaContraseniaTxt;
    }

    public void aceptoPoliticaClickJS() {
        Common.clickJS(aceptoPoliticaChk);
    }

    public void crearCuentaClickJS() {
        Common.clickJS(crearCuentaBtn);
        BrowserManager.getDriver().switchTo().alert().accept();
    }
}

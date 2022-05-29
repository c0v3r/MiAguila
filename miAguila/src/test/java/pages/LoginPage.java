package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserManager;
import utils.Common;

public class LoginPage {
    private WebElement emailTxt;
    private WebElement contraseniaTxt;
    private WebElement ingresarBtn;

    public LoginPage() {
        emailTxt = BrowserManager.findWebElementWait(By.cssSelector("input[type='email']"));
        contraseniaTxt = BrowserManager.findWebElementWait(By.cssSelector("input[type='password']"));
        ingresarBtn = BrowserManager.findWebElementWait(By.cssSelector("button[aria-label='Ingresar']"));
    }

    public WebElement getEmail() { return emailTxt; }
    public WebElement getContrasenia() { return contraseniaTxt; }
    public void ingresarClickJS() { Common.clickJS(ingresarBtn); }
}

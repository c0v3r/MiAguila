package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class MiAguilaTest extends BaseTest {
    private SignUpPage registratePage;
    private AddressPage addressPage;
    private AddressMapPage addressMapPage;

    private HeaderPage headerPage;

    private LoginPage loginPage;
    private HomePage homePage;

    @Test()
    public void SignUpSuccess() {
        registratePage = new SignUpPage();
        registratePage.getNombre().sendKeys("a");
        registratePage.getApellido().sendKeys("b");
        registratePage.getNroDocumento().sendKeys("123456");
        registratePage.getEmail().sendKeys("a@1.co");
        registratePage.getTelefono().sendKeys("1234567890");
        registratePage.getContrasenia().sendKeys("Aa3456");
        registratePage.getRepitaContrasenia().sendKeys("Aa3456");
        registratePage.aceptoPoliticaClickJS();
        registratePage.crearCuentaClickJS();

        addressPage = new AddressPage();
        addressPage.setCiudad("Bogotá");
        addressPage.getDireccionPart1().sendKeys("Carrera 104");
        addressPage.getDireccionPart2().sendKeys("# 152a");
        addressPage.getDireccionPart3().sendKeys("- 55");
        addressPage.getBuscar().click();

        addressMapPage = new AddressMapPage();
        addressMapPage.guardarClickJS();

        headerPage = new HeaderPage();
        Assert.assertEquals(headerPage.getDireccion().getText(),
                "Calle Carrera 104 # 152a - 55", "La dirección no es correcta.");
    }

    @Test()
    public void LoginSuccess() {
        headerPage = new HeaderPage();
        headerPage.getIngresar().click();
        loginPage = new LoginPage();
        loginPage.getEmail().sendKeys("a@1.co");
        loginPage.getContrasenia().sendKeys("Aa3456");
        loginPage.ingresarClickJS();

        homePage = new HomePage();
        Assert.assertTrue(homePage.getWelcomeMessageUser("a").isDisplayed(),
                "El mensaje de bienvenida no se muestra.");
    }
}


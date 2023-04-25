package login;

import base.BaseTests;
import org.junit.FixMethodOrder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginTests extends BaseTests {

    @Test(priority = 1)

    public void testSuccessfulLogin() {

        String USERNAME = loginPage.getProperties("username");
        String PASSWORD =  loginPage.getProperties("password_user");
        loginPage.loguear(USERNAME);
        //colocar assertions (verificar usuarios)
        loginPage.implicitWait();
        loginPage.login(PASSWORD);
        var a = loginPage.verificarLogin();
        Assert.assertEquals(a,USERNAME, "El usuario esperado");
        System.out.println("Inicio de Sesión correcto del usuario:"+ a);
    }

    @Test(priority = 2)
    public void testTableroCrear() {


        String NAME_TABLERO = loginPage.getProperties("nameTablero");
        tableroPage.crearTablero(NAME_TABLERO);
        String tituloObtenido= driver.getTitle();
        System.out.println("Titulo Obtenido: "+ tituloObtenido);
       // Assert.assertEquals("a",tituloObtenido, "Al Validar el titulo");

    }

    @Test(priority = 3)
    public void testTLista() {

        String NAME_LISTA =  loginPage.getProperties("nameLista");
        listaPage.crearLista(NAME_LISTA);
    }

    @Test(priority = 4)
    public void testTarjetaCrear() {

        String NAME_TARJETA =  loginPage.getProperties("nameTarjeta");
        listaPage.crearTarjeta(NAME_TARJETA);
    }
}

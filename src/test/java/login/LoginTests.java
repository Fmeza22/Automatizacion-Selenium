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
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String USERNAME = properties.getProperty("username");
        String PASSWORD = properties.getProperty("password_user");

        loginPage.loguear(USERNAME);
        //colocar assertions (verificar usuarios)
        loginPage.implicitWait();
        loginPage.login(PASSWORD);
        String CODIGO_USUARIO = properties.getProperty("usuario_codigo");
        var url=driver.getCurrentUrl();
        Assert.assertEquals(true, url.contains(CODIGO_USUARIO));
        //System.out.println(url.contains(CODIGO_USUARIO));
    }

    @Test(priority = 2)
    public void testTableroCrear() {

        Properties properties = new Properties();

        try {
            properties.load(new FileReader("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String CODIGO_USUARIO = properties.getProperty("usuario_codigo");
      //  var url=driver.getCurrentUrl();
      //  Assert.assertEquals(true, nuevoResultado.contains(resultado));
        //System.out.println(url.contains(CODIGO_USUARIO));
        String NAME_TABLERO = properties.getProperty("nameTablero");
        tableroPage.crearTablero(NAME_TABLERO);
    }

    @Test(priority = 3)
    public void testTLista() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String NAME_LISTA = properties.getProperty("nameLista");
        listaPage.crearLista(NAME_LISTA);
    }

    @Test(priority = 4)
    public void testTarjetaCrear() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String NAME_TARJETA = properties.getProperty("nameTarjeta");
        listaPage.crearTarjeta(NAME_TARJETA);
    }
}

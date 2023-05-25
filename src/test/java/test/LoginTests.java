package test;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TableroPage;
import singleton.LocalDriver;
import singleton.Singleton;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTests extends LocalDriver {



    @Test
    @Parameters( {"Username", "PasswordUser", "URL"} )
    public void testSuccessfulLogin(String user, String password, String url) {

        loginPage.loguear(user, driver);
        loginPage.WaitVerificarPass(driver,url);
        loginPage.login(password, driver);
        loginPage.WaitVerificarU(driver);
        var usuarioLogueado = loginPage.verificarLogin(driver);
        Assert.assertEquals(usuarioLogueado,user, "Usuario esperado");
        System.out.println("Inicio de Sesión correcto del usuario:"+ usuarioLogueado);
    }

}

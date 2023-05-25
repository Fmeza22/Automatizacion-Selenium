package pages;

import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    //public WebDriver driver;
    private By usernameField = By.id("user");
    private By passwordField = By.id("password");
    private By btnContinuar = By.id("login");
    private By btnLogin = By.id("login-submit");
    private By verificarCorreo = By.className("Ej7WGzTnvdxL7I");
    private By verificarUsuario = By.className("DweEFaF5owOe02");

    /*public LoginPage(WebDriver driver){
        this.driver = driver;
    }*/


    public void  loguear(String usernameLogin,WebDriver dr){
        this.setUsername(usernameLogin,dr);
        dr.findElement(btnContinuar).click();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*WebDriverWait ewait = new WebDriverWait(driver,5);
        ewait.until(ExpectedConditions.visibilityOf(passwordField.findElement(driver)));*/
        //return new LoginPage(dr);
    }
    public void login(String passwordLogin, WebDriver dr){

        this.setPassword(passwordLogin, dr);
        dr.findElement(btnLogin).click();
        //return new LoginPage(dr);
    }

    public void WaitVerificarU(WebDriver dr){

        WebDriverWait ewait = new WebDriverWait(dr,20);
        ewait.until(ExpectedConditions.visibilityOf(verificarUsuario.findElement(dr)));
    }
    public void WaitVerificarPass(WebDriver dr, String url){
        dr.get(url);
        WebDriverWait ewait = new WebDriverWait(dr,10);
        ewait.until(ExpectedConditions.visibilityOf(passwordField.findElement(dr)));
    }

    public void setUsername(String username, WebDriver dr){
        dr.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password, WebDriver dr){

        dr.findElement(passwordField).sendKeys(password);
    }
    public String verificarLogin(WebDriver dr){

        dr.findElement(verificarUsuario).click();

    return dr.findElement(verificarCorreo).getText();

    }

}
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

    public WebDriver driver;
    private By usernameField = By.id("user");
    private By passwordField = By.id("password");
    private By btnContinuar = By.id("login");
    private By btnLogin = By.id("login-submit");
    private By verificarCorreo = By.className("Ej7WGzTnvdxL7I");
    private By verificarUsuario = By.className("DweEFaF5owOe02");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public LoginPage loguear(String usernameLogin,WebDriver driver){
        this.setUsername(usernameLogin);
        driver.findElement(btnContinuar).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordField)));

        return new LoginPage(driver);
    }
    public LoginPage login(String passwordLogin, WebDriver dr){

        this.setPassword(passwordLogin);
        dr.findElement(btnLogin).click();
        return new LoginPage(dr);
    }
    public void WaitPass(WebDriver dr, String url){

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       //WebDriverWait ewait = new WebDriverWait(dr,5);
       // ewait.until(ExpectedConditions.visibilityOf(passwordField.findElement(dr)));
    }
    public void WaitVerificarU(WebDriver dr){

        WebDriverWait ewait = new WebDriverWait(dr,5);
        ewait.until(ExpectedConditions.visibilityOf(verificarUsuario.findElement(dr)));
    }
    public void WaitVerificarC(WebDriver dr){

        WebDriverWait ewait = new WebDriverWait(dr,10);
        ewait.until(ExpectedConditions.visibilityOf(verificarCorreo.findElement(dr)));
    }


    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){

        driver.findElement(passwordField).sendKeys(password);
    }
    public String verificarLogin(WebDriver dr){
        dr.findElement(verificarUsuario).click();

     //   System.out.println(g);
    return dr.findElement(verificarCorreo).getText();

    }
    public void VisiblePassword(){
        driver.findElement(passwordField).click();

    }



}
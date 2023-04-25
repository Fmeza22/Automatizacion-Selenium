package pages;

import com.google.common.collect.FluentIterable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.id("user");
    private By passwordField = By.id("password");
    private By btnContinuar = By.id("login");
    private By btnLogin = By.id("login-submit");

    private By verificarCorreo = By.className("Ej7WGzTnvdxL7I");
    private By verificarUsuario = By.className("DweEFaF5owOe02");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public LoginPage loguear(String usernameLogin){
        this.setUsername(usernameLogin);
        driver.findElement(btnContinuar).click();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return new LoginPage(driver);
    }
    public LoginPage login(String passwordLogin){

        this.setPassword(passwordLogin);
        driver.findElement(btnLogin).click();

        return new LoginPage(driver);
    }
    public void implicitWait(){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.get(properties.getProperty("url_base"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){

        driver.findElement(passwordField).sendKeys(password);
    }
    public String verificarLogin(){
        driver.findElement(verificarUsuario).click();

     //   System.out.println(g);
    return driver.findElement(verificarCorreo).getText();
    }


    public String getProperties(String valorPropiedad){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       return properties.getProperty(valorPropiedad);
    }

}
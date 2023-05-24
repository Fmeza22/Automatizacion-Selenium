package singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import pages.ListaPage;
import pages.LoginPage;
import pages.TableroPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class LocalDriver {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static TableroPage tableroPage;
    public static ListaPage listaPage;

    public static WebDriver createInstance(String browserName){
        browserName = "Chrome";

        if (browserName.equalsIgnoreCase("Firefox")) {
           WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.setHeadless(false);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.get("https://trello.com/es/login");
      //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        tableroPage = new TableroPage(driver);
        listaPage = new ListaPage(driver);
        return driver;
    }
    @AfterMethod
    public void capturaPantallaTestFallido(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot camera = (TakesScreenshot)driver;
            var consecutivo = Math.floor(Math.random()*10);
            //System.out.println(consecutivo);
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot.toPath(), new File("resources/screenshots/" + result.getName() + "_" + consecutivo + ".png").toPath());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
   /*
    @AfterClass
    public void tearDown() {
        driver.quit();
    }*/


    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(false);
        return options;
    }
}

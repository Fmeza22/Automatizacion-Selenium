package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.ListaPage;
import pages.LoginPage;
import pages.TableroPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    public WebDriver driver;
    protected LoginPage loginPage;
    protected TableroPage tableroPage;
    protected ListaPage listaPage;



    //@BeforeClass
   // @Parameters( {"URL", "BrowserType"} )
    public void setUp(String url, String browserType) {

/*
            if (browserType.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();

                driver = new FirefoxDriver(getChromeOptions());

            } else if (browserType.equalsIgnoreCase("Chrome")) {
                //Como ahora uso el manager, la implementación que encuentro no se como aplicarla
                //  ChromeOptions options = new ChromeOptions();
                // options.addArguments("headless");

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getChromeOptions());

            }
            //driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            driver.get(url);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        tableroPage = new TableroPage(driver);
        listaPage = new ListaPage(driver);
        */

    }


    @AfterMethod
    public void capturaPantallaTestFallido(ITestResult result){

       /* if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            var consecutivo = Math.floor(Math.random()*10);
            //System.out.println(consecutivo);
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot.toPath(), new File("resources/screenshots/" + result.getName() + "_" + consecutivo + ".png").toPath());
            }catch(IOException e){
                e.printStackTrace();
            }
        }*/
    }
   /*
    @AfterClass
    public void tearDown() {
        driver.quit();
    }*/

}
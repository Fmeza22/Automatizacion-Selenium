package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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

    @BeforeClass
    public void setUp() {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url_base"));
       // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        tableroPage = new TableroPage(driver);
        listaPage = new ListaPage(driver);
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

    @AfterMethod
    public void capturaPantallaTestFallido(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus())
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
        }
    }


}
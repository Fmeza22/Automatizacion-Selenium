package test;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TableroPage;
import singleton.LocalDriver;
import singleton.Singleton;

import java.util.concurrent.TimeUnit;

public class TableroTests extends LocalDriver {

   // protected WebDriver driver;
    TableroPage tableroPage;

    @Test
    @Parameters( {"NameTablero"} )
    public void testTableroCrear(String tablero) {
        driver = Singleton.getDriver();
        tableroPage = new TableroPage(driver);
        System.out.println("Driver TableroPage:"+ driver);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //String NAME_TABLERO = loginPage.getProperties("nameTablero");
        tableroPage.crearTablero(tablero, driver);
        String tituloObtenido= driver.getTitle();
        System.out.println("Titulo Obtenido: "+ tituloObtenido);

    }

   }

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
        tableroPage = new TableroPage();
        tableroPage.WaitBtCrearTMenu(driver);
        tableroPage.crearTablero(tablero, driver);
        //tableroPage.WaitBtCrearT(driver);
        String tituloObtenido= driver.getTitle();
       Assert.assertEquals(tituloObtenido,"Tableros | Trello", "Titulo Correcto" );

    }

   }

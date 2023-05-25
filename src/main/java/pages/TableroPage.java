package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableroPage {
    //private WebDriver driver;
    private By botonCrearMenu = By.className("szBTSFrvPTLGHM");
    private By botonCrearTablero = By.className("yTThzZMDkelhke");
    private By botonFinalCrear = By.className("ijFumaLuInvBrL");
    private By tituloTablero = By.className("nch-textfield__input");
    private By guardarTarjeta = By.className("nch-button");
   /* public TableroPage(WebDriver driver){

        this.driver = driver;
    }*/


    public void crearTablero(String titTablero, WebDriver dr) {

        //Botón inicial en la barra de opciones
        dr.findElement(botonCrearMenu).click();
       // var resultado = dr.getCurrentUrl();
        //Botón crear tablero
        dr.findElement(botonCrearTablero).click();
        //Agregar titulo del tablero
        dr.findElement(tituloTablero).sendKeys(titTablero);
        //Crear tablero
        dr.findElement(botonFinalCrear).click();

    }
    public void WaitBtCrearTMenu(WebDriver dr){

        WebDriverWait ewait = new WebDriverWait(dr,15);
        ewait.until(ExpectedConditions.visibilityOf(botonCrearMenu.findElement(dr)));
    }
    public void WaitBtCrearT(WebDriver dr){

        WebDriverWait ewait = new WebDriverWait(dr,10);
        ewait.until(ExpectedConditions.visibilityOf(botonCrearTablero.findElement(dr)));
    }

}

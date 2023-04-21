package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TableroPage {
    private WebDriver driver;

    private By botonCrearMenu = By.className("szBTSFrvPTLGHM");
    private By botonCrearTablero = By.className("yTThzZMDkelhke");
    private By botonFinalCrear = By.className("ijFumaLuInvBrL");
    private By tituloTablero = By.className("nch-textfield__input");
    private By guardarTarjeta = By.className("nch-button");
    private By TituloLista = By.className("list-name-input");
    private By agregarLista = By.className("mod-list-add-button");
    private By agregarTarjeta = By.className("open-card-composer");
    private By tituloTarjeta = By.className("list-card-composer-textarea");
    private By nuevaTarjeta = By.className("js-add-card");
    public TableroPage(WebDriver driver){
        this.driver = driver;
    }


    public void crearTablero(String titTablero) {

        //Botón inicial en la barra de opciones
        driver.findElement(botonCrearMenu).click();
        var resultado = driver.getCurrentUrl();
        //Botón crear tablero
        driver.findElement(botonCrearTablero).click();
        //Agregar titulo del tablero
        driver.findElement(tituloTablero).sendKeys(titTablero);
        //Crear tablero
        driver.findElement(botonFinalCrear).click();

    }
}

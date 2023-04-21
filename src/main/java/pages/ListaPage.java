package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaPage {
    private WebDriver driver;


    private By TituloLista = By.className("list-name-input");
    private By agregarLista = By.className("mod-list-add-button");
    private By agregarTarjeta = By.className("open-card-composer");
    private By tituloTarjeta = By.className("list-card-composer-textarea");
    private By nuevaTarjeta = By.className("js-add-card");
    public ListaPage(WebDriver driver){
        this.driver = driver;
    }



    public void crearLista(String titLista) {
        //Escribir lista
        driver.findElement(TituloLista).sendKeys(titLista);
        //Crear lista
        driver.findElement(agregarLista).click();
    }
    public void crearTarjeta(String titTarjeta) {

        //Agregar Tarjeta
        driver.findElement(agregarTarjeta).click();
        //Escribir nombre tarjeta
        driver.findElement(tituloTarjeta).sendKeys(titTarjeta);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListaPage {
   // private WebDriver driver;




    private By TituloLista = By.className("list-name-input");
    private By agregarLista = By.className("mod-list-add-button");
    private By agregarTarjeta = By.className("open-card-composer");
    private By tituloTarjeta = By.className("list-card-composer-textarea");
    private By nuevaTarjeta = By.className("js-add-card");
    private By submitTarjeta = By.className("nch-button");
    private By verificarTarjeta = By.className("list-card-title");

    /*public ListaPage(WebDriver driver){
        this.driver = driver;
    }*/



    public void crearLista(String titLista,WebDriver dr) {
        //Escribir lista
        dr.findElement(TituloLista).sendKeys(titLista);
        //Crear lista
        dr.findElement(agregarLista).click();
    }
    public void crearTarjeta(String titTarjeta, WebDriver dr) {
        //Agregar Tarjeta
        dr.findElement(agregarTarjeta).click();
        //Escribir nombre tarjeta
        dr.findElement(tituloTarjeta).sendKeys(titTarjeta);
        dr.findElement(submitTarjeta).click();
    }
    public String validarTarjeta (WebDriver dr){
        String texto = dr.findElement(verificarTarjeta).getText();
        return texto;
    }

    public void WaitAgregarT(WebDriver dr){


        WebDriverWait ewait = new WebDriverWait(dr,5);
        ewait.until(ExpectedConditions.visibilityOf(agregarTarjeta.findElement(dr)));

        dr.findElement(submitTarjeta).click();
    }
    public void WaitSubmitT(WebDriver dr){

        WebDriverWait ewait = new WebDriverWait(dr,5);
        ewait.until(ExpectedConditions.visibilityOf(submitTarjeta.findElement(dr)));

    }


}

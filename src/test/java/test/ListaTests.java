package test;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ListaPage;
import pages.TableroPage;
import singleton.LocalDriver;
import singleton.Singleton;

public class ListaTests extends LocalDriver {

    //ListaPage listaPage;

    @Test
    @Parameters( {"NameLista"} )
    public void testTLista(String NAME_LISTA) {

        driver = Singleton.getDriver();
        listaPage = new ListaPage();
        listaPage.crearLista(NAME_LISTA, driver);
    }

    @Test
    @Parameters( {"NameTarjeta"} )
    public void testTarjetaCrear(String NAME_TARJETA) {

        driver = Singleton.getDriver();
        listaPage = new ListaPage();
        listaPage.WaitAgregarT(driver);
        listaPage.WaitSubmitT(driver);
        listaPage.crearTarjeta(NAME_TARJETA, driver);
        var tituloNuevaTarjeta = listaPage.validarTarjeta(driver);
        Assert.assertEquals(NAME_TARJETA,tituloNuevaTarjeta);
        System.out.println("Nueva Tarjeta:" + tituloNuevaTarjeta);
    }
}

package com.example.stepdefinitions.web;

import com.example.tasks.web.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;



import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DemoBlazeStepDef {

    private Scenario scenario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void setScenario (Scenario scenario){
        this.scenario = scenario;
    }

    @Given("^el (.*) inicia la aplicacion DemoBlaze$")
    public void elClienteIniciaLaAplicacionDemoBlaze(String actor) {
        // Implementación utilizando Screenplay
        OnStage.theActorCalled(actor).attemptsTo(
                NavigateTo.DemoBlazePage()
        );
        screenShot();
    }

    @When("agrega un producto al carrito")
    public void agregaUnProductoAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(

                AñadirCelular.AñadirProducto(),
                AñadirCarritoPrimerCelular.AñadirCarritoUno()

        );
        screenShot();

    }

    @And("agrega otro producto al carrito")
    public void agregaOtroProductoAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AñadirOtroCelular.AñadirOtroProducto()
        );
        screenShot();
    }

    @Then("visualizo el carrito")
    public void visualizoElCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            VisualizarCarrito.VerCarrito()
        );
        screenShot();

    }

    @And("realizo la orden")
    public void realizoLaOrden() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RealizarCompra.ComprarProductos()
        );
        screenShot();
    }

    @And("completo el formulario de pedido con los siguientes datos:")
    public void completarFormularioDePedido(DataTable dataTable) throws IOException {
        List<Map<String, String>> data = leerDatosDesdeJSON();
        for (Map<String, String> row : data) {
            String nombre = row.get("nombre");
            String pais = row.get("pais");
            String ciudad = row.get("ciudad");
            String tarjeta = row.get("tarjeta");
            String mes = row.get("mes");
            String anio = row.get("anio");

            OnStage.theActorInTheSpotlight().attemptsTo(
                    CompletarFormulario.conDatos(nombre, pais, ciudad, tarjeta, mes, anio)
            );
            screenShot();
        }
    }

    @And("confirmo el pedido")
    public void confirmoElPedido() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmarPedido.ConfirmarPedidoForm()
        );
        screenShot();

    }

    @Then("verifico la confirmación de la compra")
    public void verificoLaConfirmacionDeLaCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarCompra.VerificarCompraTitulo()
        );
        screenShot();

    }
    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) BrowseTheWeb.as(theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    private List<Map<String, String>> leerDatosDesdeJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("datos_compra.json")) {
            return objectMapper.readValue(inputStream, List.class);
        }
    }

}

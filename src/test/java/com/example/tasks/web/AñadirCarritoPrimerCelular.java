package com.example.tasks.web;

import com.example.userinterfaces.pages.DemoBlazeCompraPage;
import com.example.userinterfaces.pages.DemoBlazePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AñadirCarritoPrimerCelular implements Task {
    public static Performable AñadirCarritoUno() {
        return instrumented(AñadirCarritoPrimerCelular.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DemoBlazeCompraPage.BotonAñadirCarrito, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DemoBlazeCompraPage.BotonAñadirCarrito),
                // Performable anónimo para aceptar la alerta
                new Performable() {
                    @Override
                    public <T extends Actor> void performAs(T actor) {
                        WebDriver driver = net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight()
                                .usingAbilityTo(net.serenitybdd.screenplay.abilities.BrowseTheWeb.class)
                                .getDriver();
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                        alert.accept();
                    }
                },
                Click.on(DemoBlazePage.HOME_LINK)
        );
    }
}

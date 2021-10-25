package net.bitsamericas.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bitsamericas.config.BitsDriver;
import net.bitsamericas.pages.ContactPage;
import org.junit.Assert;

public class ContactSteps {

    private BitsDriver driver;
    private ContactPage page;

    @Before
    public void setup(){
        String browser = "chrome";
        driver = new BitsDriver(browser);
        page = new ContactPage(driver.getDriver());
    }

    @After
    public void dispose() {
        page.dispose();
    }

    @Given("que estoy en la página de contacto")
    public void que_estoy_en_la_página_de_contacto() {
        page.navigateToHomePage();
        page.navigateToContactPage();
    }

    @When("completo el campo de nombre con {string} Y lleno el campo de correo electrónico con {string}")
    public void completo_el_campo_de_nombre_con_Y_lleno_el_campo_de_correo_electrónico_con(String name, String email) {
        page.fillInformationData(name, email);
    }

    @When("completo el campo telefono con {string} y lleno el campo organizacion con {string}")
    public void completo_el_campo_telefono_con_y_lleno_el_campo_organizacion_con(String phone, String organization) {
        page.fillPhoneAndOrganizationInformation(phone, organization);
    }

    @When("acepto los terminos y condiciones")
    public void acepto_los_terminos_y_condiciones() {
        page.checkTermsOfService();
    }

    @When("verifico que no soy un robot")
    public void verifico_que_no_soy_un_robot() {
        //page.checkCaptcha();
    }

    @When("doy clic en el boton Enviar")
    public void doy_clic_en_el_boton_Enviar() {
        page.submitInformation();
    }

    @Then("recibo un mensaje de confirmacion con el texto {string}")
    public void recibo_un_mensaje_de_confirmacion_con_el_texto(String successMessage) {
        Assert.assertEquals(successMessage, page.getSuccessMessage());
    }


}

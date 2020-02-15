package CucumberTestHucs.liferay;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FormLifeRayTest {

    private FormLifeRay formLifeRay;

    @Before
    public void setup() {
        WebDriver driver = new ChromeDriver();
        this.formLifeRay = new FormLifeRay(driver);
    }

    @When("o formulario for aberto")
    public void o_formulario_for_aberto() {
        formLifeRay.abre();
    }

    @Then("apresentara o nome {string}")
    public void apresentara_o_nome(String string) {
        Assert.assertEquals(string, formLifeRay.obterTextoByTag("h4"));
        formLifeRay.fecha();
    }

}
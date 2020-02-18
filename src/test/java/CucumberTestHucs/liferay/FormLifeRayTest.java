package CucumberTestHucs.liferay;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FormLifeRayTest {

    private FormLifeRay formLifeRay;

    @Before
    public void setup() {
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        this.formLifeRay = new FormLifeRay(driver);
    }

    @After
    public void after() {
        formLifeRay.close();
    }

    @When("this form to get open")
    public void thisFormToGetOpen() {
        formLifeRay.acess();
    }

    @Then("shows this text {string}")
    public void showsTitle(String string) {
        Assert.assertEquals(string, formLifeRay.getTextByTag("h4"));
    }

    @Given("this form is open")
    public void thisFormIsOpen() {
        formLifeRay.acess();
    }

    @When("the form is submitted")
    public void formSubmited() {
        formLifeRay.clickSubmitButton();
    }

    @Then("will show this message {string}")
    public void showsErrorMessage(String string) {
        Assert.assertEquals(string,formLifeRay.getFeedbackFieldName());
    }

    @Then("will show success message {string}")
    public void showsSuccessMessage(String string) {
        Assert.assertEquals(string, formLifeRay.getTextByTag("h5"));
    }

    @Given("we fill all mandatory fields")
    public void we_fill_all_mandatory_fields() {
        formLifeRay.fillName("Tiago S. Hucs");
        formLifeRay.fillDate("12121981");
        formLifeRay.fillTextArea("Por que eu gosto de tecnologia");
    }

}
package CucumberTestHucs.liferay;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;


public class LiferayChallengeTest {

    private FormPageObject formPageObject;

    @Before
    public void setup() {
        this.formPageObject = new FormPageObject(new ChromeDriver());
    }

    @After
    public void after() {
        formPageObject.close();
    }

    @When("this form to get open")
    public void thisFormToGetOpen() {
        formPageObject.acess();
    }

    @Then("shows this text {string}")
    public void showsTitle(String string) {
        Assert.assertEquals(string, formPageObject.getTextByTag("h4"));
    }

    @Given("this form is open")
    public void thisFormIsOpen() {
        formPageObject.acess();
    }

    @When("the form is submitted")
    public void formSubmited() {
        formPageObject.clickSubmitButton();
    }

    @Then("will show this message {string}")
    public void showsErrorMessage(String string) {
        Assert.assertEquals(string, formPageObject.getFeedbackFieldName());
        Assert.assertEquals(string, formPageObject.getFeedbackFieldDate());
        Assert.assertEquals(string, formPageObject.getFeedbackFieldText());
    }

    @Given("we fill all mandatory fields")
    public void we_fill_all_mandatory_fields() {
        formPageObject.fillName("Tiago S. Hucs");
        formPageObject.fillDate("12121981");
        formPageObject.fillTextArea("Por que eu gosto de tecnologia");
    }

    @Then("will show success message {string}")
    public void showsSuccessMessage(String string) {
        Assert.assertEquals(string, formPageObject.getTextByTag("h5"));
    }



}
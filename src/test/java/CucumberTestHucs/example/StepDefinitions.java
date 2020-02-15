package CucumberTestHucs.example;

import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

@Ignore
public class StepDefinitions {
    private String today;
    private String actualAnswer;
    private static String URL_FORM = "https://forms.liferay.com/web/forms/shared/-/form/122548";

    //TODO: colocar em casses utilitarias
    static WebDriver driver;
    static WebDriverWait wait;

    //TODO: colocar em casses utilitarias
    public static void iniciaDriverChrome(){
        //WINDOWS
        //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //LINUX
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
    }

    //TODO: colocar em casses utilitarias
    public static void iniciaDriverFirefox(){
        //WINDOWS
        //System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        //LINUX
        System.setProperty("webdriver.gecko.driver","geckodriver");
        driver = new FirefoxDriver();

    }

    //TODO: colocar em casses utilitarias
    public void formAcess() {
        iniciaDriverChrome();
        driver.get(URL_FORM);
        driver.close();
    }

    @Given("today is Sunday")
    public void today_is_Sunday() {
        formAcess();
        today = "Sunday";
    }

    @Given("today is Friday")
    public void today_is_Friday() {
        today = "Friday";
    }

    @Given("today is {string}")
    public void todayIs(String arg0) {
        today = arg0;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }


}

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}
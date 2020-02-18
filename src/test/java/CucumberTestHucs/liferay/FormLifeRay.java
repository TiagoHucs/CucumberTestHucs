package CucumberTestHucs.liferay;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.stream.events.Attribute;
import java.lang.reflect.Type;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class FormLifeRay {

    static String FEEDBACK_FIELD_NAME = "//*[contains(text(),'Qual é o seu nome?')]/following-sibling::div";
    static String INPUT_FIELD_NAME = "//*[contains(text(),'Qual é o seu nome?')]/following-sibling::input";
    static String INPUT_FIELD_DATE = "//*[contains(text(),'Qual é a data do seu nascimento?')]/following-sibling::div/div/input";
    static String INPUT_FIELD_TEXT = "//*[contains(text(),'Porque você ingressou na área de testes?')]/following-sibling::textarea";


    private static String URL_FORM = "https://forms.liferay.com/web/forms/shared/-/form/122548";

    private WebDriver driver;
    private WebDriverWait wait;

    public FormLifeRay(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void acess() {
        driver.navigate().to(URL_FORM);
    }

    public void close() {
        driver.close();
    }

    public String getTextByTag(String tag) {
        return driver.findElement(By.tagName(tag)).getText();
    }

    public String getFeedbackFieldName() {
        return driver.findElement(By.xpath(FEEDBACK_FIELD_NAME)).getText();
    }

    public void clickSubmitButton() {
        driver.findElement(By.tagName("form")).submit();
    }

    public void fillName(String name) {
        WebElement element = driver.findElement(By.xpath(INPUT_FIELD_NAME));
        element.sendKeys(name);
        element.getAttribute("value");
    }

    public void fillDate(String date) {
       WebElement element = driver.findElement(By.xpath(INPUT_FIELD_DATE));
       element.sendKeys(Keys.HOME);
       element.sendKeys(date);
       element.getAttribute("value");
    }

    public void fillTextArea(String text) {
        WebElement element = driver.findElement(By.xpath(INPUT_FIELD_TEXT));
        element.sendKeys(text);
        element.getAttribute("value");
    }
   
  }

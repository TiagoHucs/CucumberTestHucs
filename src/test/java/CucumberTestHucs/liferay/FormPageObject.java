package CucumberTestHucs.liferay;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static CucumberTestHucs.TestUtil.sleep;
import static CucumberTestHucs.TestUtil.waitForLoad;

public class FormPageObject {

    static String INPUT_FIELD_NAME = "//*[contains(text(),'Qual é o seu nome?')]/following-sibling::input";
    static String FEEDBACK_FIELD_NAME = "//*[contains(text(),'Qual é o seu nome?')]/following-sibling::div";

    static String INPUT_FIELD_DATE = "//*[contains(text(),'Qual é a data do seu nascimento?')]/following-sibling::div/div/input";
    static String FEEDBACK_FIELD_DATE = "//*[contains(text(),'Qual é a data do seu nascimento?')]/following-sibling::div[2]/div";

    static String INPUT_FIELD_TEXT = "//*[contains(text(),'Porque você ingressou na área de testes?')]/following-sibling::textarea";
    static String FEEDBACK_FIELD_TEXT = "//*[contains(text(),'Porque você ingressou na área de testes?')]/following-sibling::div";

    private static String URL_FORM = "https://forms.liferay.com/web/forms/shared/-/form/122548";

    private WebDriver driver;

    public FormPageObject(WebDriver driver) {
        this.driver = driver;
        this.driver.manage()
                .timeouts()
                .pageLoadTimeout(10, TimeUnit.SECONDS)
                .implicitlyWait(10, TimeUnit.SECONDS);
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

    public String getFeedbackFieldDate() {
        return driver.findElement(By.xpath(FEEDBACK_FIELD_DATE)).getText();
    }

    public String getFeedbackFieldText() {
        return driver.findElement(By.xpath(FEEDBACK_FIELD_TEXT)).getText();
    }

    public void fillName(String name) {
        WebElement element = driver.findElement(By.xpath(INPUT_FIELD_NAME));
        element.sendKeys(name);
        sleep();
    }

    public void fillDate(String date) {
       WebElement element = driver.findElement(By.xpath(INPUT_FIELD_DATE));
       element.sendKeys(Keys.HOME);
       element.sendKeys(date);
       sleep();
    }

    public void fillTextArea(String text) {
        WebElement element = driver.findElement(By.xpath(INPUT_FIELD_TEXT));
        element.sendKeys(text);
        sleep();
    }

    public void clickSubmitButton() {
        driver.findElement(By.tagName("form")).submit();
        sleep();
        waitForLoad(driver);
    }

   
  }

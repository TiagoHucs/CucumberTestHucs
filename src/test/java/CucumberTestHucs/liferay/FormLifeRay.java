package CucumberTestHucs.liferay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FormLifeRay {

   static String FEEDBACK_FIELD_NAME = "//*[contains(text(),'Qual é o seu nome?')]/following-sibling::div";

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

    public void clickSubmitButton(){
        driver.findElement(By.cssSelector(".lfr-ddm-form-submit")).click();
    }

}

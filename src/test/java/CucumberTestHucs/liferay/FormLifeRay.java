package CucumberTestHucs.liferay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormLifeRay {

    private static String URL_FORM = "https://forms.liferay.com/web/forms/shared/-/form/122548";

    private WebDriver driver;

    public FormLifeRay(WebDriver driver) {
        this.driver = driver;
    }

    public void abre() {
        driver.navigate().to(URL_FORM);
    }

    public void fecha() {
        driver.close();
    }

    public String obterTextoById(String id) {
        return driver.findElement(By.id(id)).getText();
    }

    public String obterTextoByTag(String tag) {
        return driver.findElement(By.tagName(tag)).getText();
    }

}

package aletrs;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;
import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTest extends TestBase {

    @Test

    public void shouldChecksimpleAlertPopUp() {
        driver.get("http://51.75.61.161:9102/alerts.php");
        WebElement simpleAlertButton = driver.findElement(By.cssSelector("#simple-alert"));
        simpleAlertButton.click();
        driver.switchTo().alert().accept();

        WebElement simpleAlertLabel = driver.findElement(By.cssSelector("#simple-alert-label"));
        simpleAlertLabel.getText();
        assertThat(simpleAlertLabel.getText()).isEqualTo("OK button pressed");
    }

    @Test
    public void shouldCheckPromptAlertBox() {
        driver.get("http://51.75.61.161:9102/alerts.php");
        WebElement promptPopUpButton = driver.findElement(By.cssSelector("#prompt-alert"));
        promptPopUpButton.click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();

        WebElement promptLabel = driver.findElement(By.id("prompt-label"));

        String filledText = promptLabel.getText();
        String expectedText = "Hello Lord Vader! How are you today?";
        assertThat(filledText).isEqualTo(expectedText);

    }

    @Test

    public void shouldCheckConfirmAlertBox() {
        driver.get("http://51.75.61.161:9102/alerts.php");
        WebElement confirmPopUpButton = driver.findElement(By.cssSelector("#confirm-alert"));
        confirmPopUpButton.click();
        driver.switchTo().alert().accept();
        WebElement confirmLabel = driver.findElement(By.cssSelector("#confirm-label"));
        String confirmLabelText = confirmLabel.getText();
        assertThat(confirmLabelText).isEqualTo("You pressed OK!");


    }
@Test
    public void shouldCheckDismissAlertBox() {
        driver.get("http://51.75.61.161:9102/alerts.php");
        WebElement confirmPopUpButton = driver.findElement(By.cssSelector("#confirm-alert"));
        confirmPopUpButton.click();
        driver.switchTo().alert().dismiss();
        WebElement confirmLabel = driver.findElement(By.cssSelector("#confirm-label"));
        String confirmLabelText = confirmLabel.getText();
        assertThat(confirmLabelText).isEqualTo("You pressed Cancel!");
    }
}


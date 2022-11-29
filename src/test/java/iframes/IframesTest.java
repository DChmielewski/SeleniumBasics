package iframes;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

import java.util.List;
import java.util.Random;

public class IframesTest extends TestBase {

    @Test
    public void shouldSwitchAndFillIframes() {
        driver.get("http://automation-practice.emilos.pl/iframes.php");
        driver.switchTo().frame("iframe1");

        WebElement firstNameInput = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstNameInput.sendKeys("Tytus");

        WebElement surnameInput = driver.findElement(By.cssSelector("#inputSurname3"));
        surnameInput.sendKeys("Bomba");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");

        WebElement loginInput = driver.findElement(By.cssSelector("#inputLogin"));
        loginInput.sendKeys("SebastianBak");
        WebElement passwordInput = driver.findElement(By.cssSelector("#inputPassword"));

        passwordInput.sendKeys("alkohol1234");

        Select continents = new Select(driver.findElement(By.cssSelector("#inlineFormCustomSelectPref")));
        continents.selectByIndex((new Random().nextInt(6) + 1));

        List<WebElement> yesrsOfExp = driver.findElements(By.cssSelector("[name=gridRadios]"));
        getRandomElement(yesrsOfExp).click();

        driver.switchTo().defaultContent();
        WebElement basicToggle = driver.findElement(By.linkText("Basic"));
        basicToggle.click();
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }
}

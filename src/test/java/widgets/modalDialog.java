package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;

public class modalDialog extends TestBase {
    @Test
    public void createNewUser() {


        driver.get("http://51.75.61.161:9102/modal-dialog.php");
        WebElement createNewUserButton = driver.findElement(By.cssSelector("#create-user"));
        createNewUserButton.click();
        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.clear();
        name.sendKeys("Arkadiusz Milik");
        WebElement email = driver.findElement(By.cssSelector("#email"));

        email.clear();
        email.sendKeys("arekmilik@gmail.com");


        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.clear();
        password.sendKeys("arekmilik123");

        WebElement createButton = driver.findElement(By.cssSelector(".ui-dialog-buttonset"));
        createButton.click();

        List<WebElement> allRows = driver.findElements(By.cssSelector("tbody tr"));

        for (WebElement row : allRows) {
            String nameFromTable = row.findElements(By.cssSelector("td")).get(0).getText();
            String emailFromTable = row.findElements(By.cssSelector("td")).get(1).getText();
            String passwordFromTable = row.findElements(By.cssSelector("td")).get(2).getText();
            System.out.println(nameFromTable + " " + emailFromTable + " " + passwordFromTable);
        }
    }
}

package tables;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;

public class TablesTest extends TestBase {
    @Test

    public void printExpectedDataFromTable() {
        driver.get("http://51.75.61.161:9102/table.php");

        List<WebElement> allRows = driver.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : allRows) {
            String rank = row.findElements(By.cssSelector("th")).get(0).getText();
            String peak = row.findElements(By.cssSelector("td")).get(0).getText();
            String mountainRange = row.findElements(By.cssSelector("td")).get(1).getText();
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            String height = row.findElements(By.cssSelector("td")).get(3).getText();

            if ((Integer.parseInt(height) > 4000) && state.contains("Switzerland")) {
                System.out.println("Greater than 4000 in Switzerland is: " + rank + " " + peak + " " + mountainRange);
            }
        }
    }
}

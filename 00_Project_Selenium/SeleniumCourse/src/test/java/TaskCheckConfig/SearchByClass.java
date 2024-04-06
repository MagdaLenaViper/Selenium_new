package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchByClass {
        // class hide_xs
        // class is_required validate account_input form-control
        // id SubmitCreate
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl//en/");
        driver.findElement(By.className("hide_xs")).click();
        WebElement element = driver.findElement(By.className("is_required")); // by cssSelector
        element.clear();
        element.sendKeys("testujemy@gmail.com");
        WebElement sign = driver.findElement(By.id("SubmitCreate"));
        sign.click();
    }
}

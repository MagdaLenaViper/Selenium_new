package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeacrhByName {

    public static void main(String[] args) {
        // hotel_location
        // search_room_submit
        // email
        // action

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement element = driver.findElement(By.name("hotel_location"));
        element.sendKeys("Warsaw");
        element.submit();
        WebElement element1 = driver.findElement(By.name("email"));
        element1.sendKeys("test@test.pl");
    }
}

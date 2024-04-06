package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewSearchById {
        // hotel_location
        // search_room_submit
        // newsletter-input
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement element = driver.findElement(By.id("hotel_location"));
        element.clear();
        element.sendKeys("Warsaw");
        WebElement element1 = driver.findElement(By.id("newsletter-input"));
        element1.clear();
        element1.sendKeys("test@test.com");
    }
}

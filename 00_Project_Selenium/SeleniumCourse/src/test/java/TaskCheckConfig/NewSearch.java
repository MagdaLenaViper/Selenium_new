package TaskCheckConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewSearch {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://coderslab.pl");
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.quit();
    }
}
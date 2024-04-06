package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchByXpath {

    public static void main(String[] args) throws InterruptedException {
        // /html/body/div/form/div/input
        //
        //
        //
        //

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl//en/");
        driver.findElement(By.className("hide_xs")).click();
        WebElement element = driver.findElement(By.className("is_required")); // by cssSelector
        element.clear();
        element.sendKeys("testujemy1@gmail.com");
        WebElement sign = driver.findElement(By.id("SubmitCreate"));
        sign.click();
        Thread.sleep(3000);
        WebElement gender = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        gender.click();
        WebElement userName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        userName.sendKeys("Rafal");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastName.sendKeys("Czerwik");
        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys("RafalCzerwik");
        WebElement register = driver.findElement(By.xpath("//button[@id='submitAccount']"));
        register.click();
    }
}

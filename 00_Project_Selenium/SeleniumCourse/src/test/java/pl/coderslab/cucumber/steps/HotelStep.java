package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class HotelStep {

    private WebDriver driver;

    @Given("użytkownik znajduje się na stronie głównej hotelu")
    public void openMainPage() {

        this.driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

//    String email = "test@test" + new Random().nextInt(1000000) + ".com";

    @When("użytkownik tworzy nowe konto z {word} {word} i hasłem {word}")
    public void goToLoginPage(String name, String lastName, String password) {

        String email = "test@test" + new Random().nextInt(1000000) + ".com";
        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click();

        WebElement emailAddressInput = this.driver.findElement(By.className("is_required"));
        emailAddressInput.clear();
        emailAddressInput.sendKeys(email);

        this.driver.findElement(By.id("SubmitCreate")).click();

        WebElement customerNameInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[2]/input"));
        customerNameInput.sendKeys(name);
        WebElement customerLastNameInput = this.driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        customerLastNameInput.sendKeys(lastName);
        WebElement passwordInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[5]/input"));
        passwordInput.sendKeys(password);
        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        submitButton.click();
    }

}

package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.hotel.LoginPage;

import java.time.Duration;

public class AddAddressStep {

    private WebDriver driver;

    @Given("zalogowany użytkownik z emailem {word} i hasłem {word} znajduje się na dashboardzie")
    public void logInToAccount(String email, String password) {

        this.driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click();

//        LoginPage loginUser = new LoginPage(this.driver);
//        loginUser.loginAccountWith(email, password);

        WebElement emailInput = this.driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = this.driver.findElement(By.id("passwd"));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton1 = this.driver.findElement(By.id("SubmitLogin"));
        signInButton1.click();
    }

    @When("użytkownik dodaje pierwszy adres z nazwą ulicy {string} w mieście {word} {word} i numerem telefonu {word}")
    public void addAddress(String streetName, String city, String postalCode, String phoneNumber) {

        WebElement addFirstAddressButton = this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[1]/a/span"));
        addFirstAddressButton.click();

        WebElement streetAddressInput = this.driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        streetAddressInput.clear();
        streetAddressInput.sendKeys(streetName);

        WebElement cityInput = this.driver.findElement(By.xpath("//*[@id=\"city\"]"));
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement postalCodeInput = this.driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        WebElement phoneNumberInput = this.driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);

        WebElement saveAddressButton = this.driver.findElement(By.xpath("//*[@id=\"submitAddress\"]"));
        saveAddressButton.click();
    }

    @Then("adres został dodany do konta")
    public void deleteAddress() {

        WebElement delete = this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[11]/a[2]/span"));
        delete.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        this.driver.quit();
    }
}

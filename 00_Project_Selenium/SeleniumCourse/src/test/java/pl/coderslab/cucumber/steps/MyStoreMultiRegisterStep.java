package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.mystore.DashboardPage;
import pl.coderslab.mystore.LoginPage;
import pl.coderslab.mystore.MainPage;
import pl.coderslab.mystore.RegisterPage;

import java.util.Random;

public class MyStoreMultiRegisterStep {

    WebDriver driver;

    @Given("użytkownik znajduje się na stronie głównej sklepu")
    public void goToMainPage() {

        this.driver = new ChromeDriver();
        this.driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("użytkownik rejestruje nowe konto z {word} {word} i hasłem {word}")
    public void createAccount(String firstName, String lastName, String password) {

        String email = "test@test" + new Random().nextInt(1000000) + ".com";

        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.createAccount();

        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.registerAccountWith(firstName, lastName, password, email);

        mainPage.goToDashboard();

        DashboardPage addFirstAddress = new DashboardPage(this.driver);
        addFirstAddress.myAddress();

        String[] cities = {"Warszawa", "Kraków", "Gdańsk", "Gdynia", "Wrocław", "Katowice", "Poznań"};
        Random random = new Random();
        int randomIndex = random.nextInt(cities.length);
        String userCity = cities[randomIndex];

        String streetAddress = "Wyspiańskiego " + new Random().nextInt(100);
        String postalCode = "";

        for(int i = 0; i < 5; i ++) {
            int digit = new Random().nextInt(10);
            postalCode = postalCode + digit;
        }

        String phoneNumber ="";

        for(int i = 0; i < 9; i ++) {
            int digit = new Random().nextInt(10);
            phoneNumber = phoneNumber + digit;
        }

        WebElement addressInput = this.driver.findElement(By.xpath("//*[@id=\"field-address1\"]"));
        addressInput.clear();
        addressInput.sendKeys(streetAddress);

        WebElement cityInput = this.driver.findElement(By.xpath("//*[@id=\"field-city\"]"));
        cityInput.clear();
        cityInput.sendKeys(userCity);

        WebElement postalCodeInput = this.driver.findElement(By.xpath("//*[@id=\"field-postcode\"]"));
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        WebElement phoneNumberInput = this.driver.findElement(By.xpath("//*[@id=\"field-phone\"]"));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);

        WebElement addAddressButton = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        addAddressButton.click();
    }

    @Then("nowe konto użytkownika zostało utworzone")
    public void registeredAccountAndAddress() {
        this.driver.quit();
    }
}

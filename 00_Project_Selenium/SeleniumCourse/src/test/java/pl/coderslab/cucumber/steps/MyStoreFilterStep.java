package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreFilterStep {

    WebDriver driver;

    @Given("niezarejestrowany użytkownik znajduje się na stronie głównej sklepu")
    public void goToMainPage() {

        this.driver = new ChromeDriver();
        this.driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("niezarejestrowany użytkownik filtruje produkty w kategorii ubrania")
    public void filteredProducts() {

        WebElement categoryButton = this.driver.findElement(By.xpath("//*[@id=\"category-9\"]/a"));
        categoryButton.click();

        WebElement filterComposition = this.driver.findElement(By.xpath("/html/body/main/section/div/div[1]/div[2]/div[2]/section[1]/ul/li/label/span/input"));
        filterComposition.click();
    }

//    @Then("wyświetliły się filtrowane produkty")
//    public void receivedResults() {
//
//        this.driver.quit();
//    }
}

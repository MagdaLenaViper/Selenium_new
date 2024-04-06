package pl.coderslab.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerAccountWith(String userName, String lastName, String password, String email) {

        WebElement userNameInput = this.driver.findElement(By.id("field-firstname"));
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        WebElement userLastNameInput = this.driver.findElement(By.id("field-lastname"));
        userLastNameInput.clear();
        userLastNameInput.sendKeys(lastName);

        WebElement passwordInput = this.driver.findElement(By.id("field-password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement emailInput = this.driver.findElement(By.id("field-email"));
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement privacy = this.driver.findElement(By.name("customer_privacy"));
        privacy.click();

        WebElement terms = this.driver.findElement(By.name("psgdpr"));
        terms.click();

        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"customer-form\"]/footer/button"));
        submitButton.click();
    }
}

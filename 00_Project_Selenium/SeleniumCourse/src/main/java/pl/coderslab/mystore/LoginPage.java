package pl.coderslab.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createAccount() {

        WebElement create = this.driver.findElement(By.className("no-account"));
        create.click();
    }
}

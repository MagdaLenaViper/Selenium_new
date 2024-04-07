package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuckDuckGoStep {

    @Given("an open browser with duckduckgo.com")
    public void openBrowserWithDuckDuckGo() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com");
    }
}

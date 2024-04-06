package pl.coderslab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.mystore.DashboardPage;
import pl.coderslab.mystore.LoginPage;
import pl.coderslab.mystore.MainPage;
import pl.coderslab.mystore.RegisterPage;

import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Random;

public class MyStoreRegistrationTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        this.driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

//    @After
//    public void tearDown(){
//        this.driver.quit();
//    }

    @Test
    public void isPossibleToRegisterNewUser() {

//        byte[] array = new byte[7]; // length is bounded by 7
//        new Random().nextBytes(array);
//        String generatedString = new String(array, Charset.forName("UTF-8"));

//        int leftLimit = 97; // letter 'a'
//        int rightLimit = 122; // letter 'z'
//        int targetStringLength = 10;
//        Random random = new Random();
//        StringBuilder buffer = new StringBuilder(targetStringLength);
//        for (int i = 0; i < targetStringLength; i++) {
//            int randomLimitedInt = leftLimit + (int)
//                    (random.nextFloat() * (rightLimit - leftLimit + 1));
//            buffer.append((char) randomLimitedInt);
//        }
//        String generatedString = buffer.toString();


        String[] city = {"Kraków", "Warszawa", "Poznań", "Wrocław", "Łódź"};

        Random random = new Random();
        int randomIndex = random.nextInt(city.length);

        String userCity = city[randomIndex];

        String userName = "test";
        String lastName = "test";
        String email = "test@test" + new Random().nextInt(1000000) + ".com";
        String password = "12345!@" + new Random().nextInt(1000000);

        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.createAccount();

        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.registerAccountWith(userName, lastName, email, password);

        mainPage.goToDashboard();

        DashboardPage dashboardPage = new DashboardPage(this.driver);
        dashboardPage.myAddress();
    }
}

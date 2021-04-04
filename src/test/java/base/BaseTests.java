package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    WebDriver driver;

    public BaseTests(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String []args) {

//        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();  //invoked the browser

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();  //invoked the browser

        driver.get("http://demo.guru99.com/test/newtours/");//Open URL in browser
        driver.manage().window().maximize(); //it will maximize the window
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);//will wait for 5 seconds

        driver.findElement(By.name("userName")).sendKeys("mercury");//Enter username
        driver.findElement(By.name("password")).sendKeys("mercury");//Enter password
        driver.findElement(By.name("submit")).click(); //click on submit button and it will land on the next page

        //validation
        String exp_title = "Login: Mercury Tours";
        //String exp_title="Mercury Tours"; //This will fail the test case , just an example to understand
        String actual_title = driver.getTitle(); //returns the title of the page
        System.out.println(actual_title);      //print title in console


        if (exp_title.equals(actual_title) == true) {
            System.out.println("Test is passed");
        } else {
            System.out.println("Test is failed");
        }
        //driver.close();

    }

}
//userName  password


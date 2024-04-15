package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        WebDriver driver = null;

        try {
            System.out.println("Fire up chrome browser.");
            driver = new ChromeDriver();

            System.out.println("Driver info: " + driver);
            sleep(2);

            driver.get(url);

            WebElement element = driver.findElement(By.id("firstname"));
            System.out.println("Found element: " + element);
            element.sendKeys("shreya");

            WebElement elementln = driver.findElement(By.id("lastname"));
            System.out.println("Found element: " + element);
            elementln.sendKeys("bista");

            WebElement elementpn = driver.findElement(By.id("phoneNumber"));
            System.out.println("Found element: " + element);
            elementpn.sendKeys("+61 260000");

            WebElement email = driver.findElement(By.id("email"));
            System.out.println("Found element: " + element);
            email.sendKeys("shreya@mailinator.com");

            WebElement password = driver.findElement(By.id("password"));
            System.out.println("Found element: " + element);
            password.sendKeys("Test@123");

            WebElement confirmpassword = driver.findElement(By.id("confirmPassword"));
            System.out.println("Found element: " + element);
            confirmpassword.sendKeys("test@123");

            WebElement createaccount = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
            System.out.println("Found element: " + element);
            createaccount.click();

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("/Users/sushi/Downloads/task2_2C/screenshot.png"));

            sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void main(String[] args) {
        officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
    }
}
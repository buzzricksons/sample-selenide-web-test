package com.example.selenium_vs_selenide;

import com.example.AbstractTests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Test for Example Ajax Tests by selenium and selenide.
 *
 * @author HyungCheol Kim
 */
public class AjaxTests extends AbstractTests {
//    @Test
    public void seleniumAjaxTest1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./chromedriver_win.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:11080/top");
        driver.findElement(By.name("time")).sendKeys("3");
        driver.findElement(By.id("button1")).click();
        long timeout = 4000, polling = 100, start = System.currentTimeMillis();
        WebElement result = null;
        while (System.currentTimeMillis() - start < timeout) {
            try {
                if (result != null) {
                    break;
                }
                result = driver.findElement(By.id("result-time"));
            } catch (NoSuchElementException ignore) {
                TimeUnit.MILLISECONDS.sleep(polling);
            }
        }

        Assert.assertEquals("3 seconds later", result.getText());

        driver.quit();
    }

//    @Test
    public void seleniumAjaxTest2() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver_win.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:11080/top");
        driver.findElement(By.name("time")).sendKeys("3");
        driver.findElement(By.id("button1")).click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement result = driver.findElement(By.id("result-time"));

        Assert.assertEquals("3 seconds later", result.getText());

        driver.quit();
    }

    @Test
    public void selenideAjaxTest() {
        open("http://localhost:11080/top");
        $(By.name("time")).setValue("3");
        $("#button1").click();

        $("#result-time").shouldBe(text("3 seconds later"));
    }
}

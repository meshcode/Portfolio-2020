package org.example.Selenium_Webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.junit.Assert.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SeleniumBasics {

    public ChromeDriver webDriver;
    public WebDriverWait wait;
    public String confirmation_box;

    @Before
    public void Setup(){
        BasicConfigurator.configure();
        // ChromeDriver path setup
        WebDriverManager.chromedriver().setup();
        // Browser start
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();

        // Implicit wait
        //this.webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Explicit wait
        this.wait = new WebDriverWait(this.webDriver, 10);

        this.webDriver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        // Wylacz przegladarke
        this.webDriver.quit();
    }


    @Test
    public void testSignUp() throws InterruptedException {

        WebElement signInButton = webDriver.findElement(By.linkText("Sign in"));
        signInButton.click();

        TimeUnit.SECONDS.sleep(2);
        //wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("/html//input[@id='email_create']"), true));
        WebElement emailCreate = webDriver.findElement(By.xpath("/html//input[@id='email_create']"));

        emailCreate.click();
        //
        //MMK code for random characters in email.
        //The lower case letter characters: 'a', 'b', 'c' have sequential numeric values (from 97 to 122).
        int fromA = 97; // letter 'a'
        int toZ = 122; // letter 'z'
        int totalLetters = 3;
        Random random = new Random();
        String generatedString = random.ints(fromA, toZ + 1)
                .limit(totalLetters)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        emailCreate.sendKeys(generatedString + "@"+ generatedString +"." + generatedString);
        //
        //


        WebElement createAccount = webDriver.findElement(By.cssSelector("#create-account_form span"));
        createAccount.click();
        TimeUnit.SECONDS.sleep(5);


        WebElement Mr = webDriver.findElement(By.xpath("/html//form[@id='account-creation_form']/div[1]/div[1]/div[2]/label[@class='top']/div[@class='radio']//input[@name='id_gender']"));
        //wait.until(ExpectedConditions.elementSelectionStateToBe(Mr, true));
        Mr.click();

        WebElement firstName = webDriver.findElement(By.xpath("/html//input[@id='customer_firstname']"));
        firstName.sendKeys("Test");

        WebElement lastName = webDriver.findElement(By.xpath("/html//input[@id='customer_lastname']"));
        lastName.sendKeys("Testowski");

        WebElement passwd = webDriver.findElement(By.xpath("/html//input[@id='passwd']"));
        passwd.sendKeys("Test111");



        WebElement days = webDriver.findElement(By.name("days"));
        Select daysDropdown =  new Select(days);
        daysDropdown.selectByValue("5");

// Works slower than method below
//        Select monthsDropdown = new Select(webDriver.findElement(By.id("months")));
//        monthsDropdown.selectByVisibleText("April ");


        WebElement months = webDriver.findElement(By.xpath("/html//select[@id='months']"));
        months.sendKeys("apr");


        Select yearsDropdown = new Select(webDriver.findElement(By.id("years")));
        yearsDropdown.selectByIndex(27);


// My method

//        WebElement days = webDriver.findElement(By.xpath("/html//select[@id='days']"));
//        days.sendKeys("5");

//        WebElement months = webDriver.findElement(By.xpath("/html//select[@id='months']"));
//        months.sendKeys("apr");
//
//        WebElement years = webDriver.findElement(By.xpath("/html//select[@id='months']"));
//        years.sendKeys("1994");

        WebElement adress = webDriver.findElement(By.cssSelector("[name='address1']"));
        adress.sendKeys("Malinowa 77");

        WebElement city = webDriver.findElement(By.cssSelector("#city"));
        city.sendKeys("Denver");

        Select stateDropdown = new Select(webDriver.findElementByCssSelector("#id_state"));
        stateDropdown.selectByVisibleText("New York");

        WebElement postcode = webDriver.findElement(By.cssSelector("#postcode"));
        postcode.sendKeys("32145");

        Select countryDropdown = new Select(webDriver.findElementByCssSelector("#id_country"));
        countryDropdown.selectByVisibleText("United States");


        WebElement mobilePhone = webDriver.findElement(By.cssSelector("#phone_mobile"));
        mobilePhone.sendKeys("500 500 500");

        WebElement registerButton = webDriver.findElement(By.cssSelector("#submitAccount"));
        registerButton.click();

    }

    @Test
    public void testLogin() throws InterruptedException {

        WebElement signInButton = webDriver.findElement(By.linkText("Sign in"));
        signInButton.click();


        //WebElement emailInput = webDriver.findElement(By.cssSelector("#email"));
        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#email")));
        emailInput.sendKeys("test@testowisko.pl");

        WebElement passwdInput = webDriver.findElement(By.cssSelector("#passwd"));
        passwdInput.sendKeys("Test111");

        WebElement signIn = webDriver.findElement(By.xpath("//button[@id='SubmitLogin']/span"));
        signIn.click();

        Assert.assertEquals("My account - My Store", this.webDriver.getTitle());
        System.out.println("Site title correct");

        WebElement pageHeading = webDriver.findElement(By.className("page-heading"));
        Assert.assertEquals(pageHeading.getText(), "MY ACCOUNT");

        System.out.println("H1 value correct");
        System.out.println("Test 'login' finished.");
    }

    @Test
    public void AddToCart() throws InterruptedException {

        // Actions builded
        Actions actions = new Actions(webDriver);

        WebElement womanMenuHover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Women']")));
        actions.moveToElement(womanMenuHover).build().perform();

        WebElement tishirts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".first-in-line-xs.submenu-container a[title='T-shirts']")));
        actions.click(tishirts).build().perform();
        //tishirts.click();

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".right-block > .content_price > .price.product-price")));
        String tekst = price.getText();

        WebElement hoverTishirt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Faded Short Sleeve T-shirts'] > img[alt='Faded Short Sleeve T-shirts']")));
        actions.moveToElement(hoverTishirt).build().perform();


        WebElement addCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Add to cart'] > span")));
        actions.click(addCart).build().perform();

        // Switch to active element (chechout popup)
        webDriver.switchTo().activeElement();

        WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Proceed to checkout'] > span")));
        actions.click(checkout).build().perform();

        WebElement finalprice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td#total_product")));

        Assert.assertEquals(tekst, finalprice.getText());

        WebElement finalCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#center_column  a[title='Proceed to checkout'] > span")));
        actions.click(finalCheckout).build().perform();

        //WebElement signInButton = webDriver.findElement(By.linkText("Sign in"));
        //signInButton.click();

        WebElement emailInput = webDriver.findElement(By.cssSelector("#email"));
        emailInput.sendKeys("test@testowisko.pl");

        WebElement passwdInput = webDriver.findElement(By.cssSelector("#passwd"));
        passwdInput.sendKeys("Test111");

        WebElement signIn = webDriver.findElement(By.xpath("//button[@id='SubmitLogin']/span"));
        signIn.click();

        WebElement proceed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[action] > p:nth-child(2) span")));
        actions.click(proceed).build().perform();

        WebElement terms = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//input[@id='cgv']")));
        actions.click(terms).build().perform();

        WebElement proceed2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".standard-checkout span")));
        actions.click(proceed2).build().perform();

        WebElement payByWire = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Pay by bank wire'] > span")));
        actions.click(payByWire).build().perform();

        WebElement confirmPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#cart_navigation  span")));
        actions.click(confirmPayment).build().perform();


        WebElement confirmationBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#center_column > .box")));
        confirmation_box = confirmationBox.getText();

        confirmation_box = confirmation_box.substring(confirmation_box.indexOf("ce") + 3);
        confirmation_box = confirmation_box.substring(0, confirmation_box.indexOf("in") - 1);

        System.out.println("Order number is: " + confirmation_box);
        System.out.println("Test 'AddToCart' finished.");

        // Uncomment this block to check how this work if it catches error
//        confirmation_box = "TEST_ERROR";
//        System.out.println(confirmation_box + " has been assigned.");

    }

    @Test
    public void checkOrder() throws InterruptedException {

        AddToCart();

        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='View my customer account'] > span")));
        account.click();

        WebElement orderHistory = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Orders'] > span")));
        orderHistory.click();

        WebElement blockHistory = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#block-history")));
        String block = blockHistory.getText();

        try {
            Assert.assertTrue(block.contains(confirmation_box));
            System.out.println("There is order " + confirmation_box + " in the order list.");
        } catch (AssertionError e){
            System.out.println("There is no order like " + confirmation_box);
            throw new IllegalArgumentException("There is no order like " + confirmation_box);
        }

        System.out.println("Test 'checkOrder' finished correct.");

    }




}
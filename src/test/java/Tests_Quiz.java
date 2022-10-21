import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Tests_Quiz {
    WebDriverWait wait;
    WebDriver driver;
    JavascriptExecutor js;
    Variables v=new Variables();
    @Test
    public void testcase1() throws TimeoutException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        //login
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userName"))));
        WebElement userName= driver.findElement(By.id("userName")),
                pass= driver.findElement(By.id("password")),
                login= driver.findElement(By.id("login"));

        userName.sendKeys(v.username);
        pass.sendKeys(v.pass);
        js.executeScript("arguments[0].scrollIntoView(true);", login);
        login.click();

        //check logout button appeared
        sleep(5000);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userName-value"))));
        WebElement logout= driver.findElement(By.xpath("//button[text()='Log out']"));
        Assert.assertTrue(logout.isDisplayed());

        //go to bookstore
        WebElement bookstore=driver.findElement(By.xpath("//span[text()='Book Store']"));
        js.executeScript("arguments[0].scrollIntoView(true);", bookstore);
        bookstore.click();

        //check 8 books are returned in the table
        sleep(3000);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userName"))));
        List<WebElement> book_list=driver.findElements(By.xpath("//img[@alt='image']"));
        Assert.assertEquals(book_list.size(), 8);

        //Click on ‘Git Pocket Guide’
        WebElement git_pocket_book= driver.findElement(By.xpath("//a[text()='Git Pocket Guide']"));
        git_pocket_book.click();

        //Details page opened (Assert  title)
        sleep(3000);
        WebElement book_title= driver.findElement(By.xpath("//label[text()='Git Pocket Guide']"));
        Assert.assertEquals(book_title.getText(), "Git Pocket Guide");

        //Click on ‘Add to your collection’
        WebElement add_to_collection=driver.findElement(By.xpath("//button[text()='Add To Your Collection']"));
        js.executeScript("arguments[0].scrollIntoView(true);",add_to_collection);
        add_to_collection.click();

        //‘Book already present in the your collection!’ text appeared
        sleep(3000);
        String s=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(s, v.alert_text_1);
        //სხვადასხვა ტექსტს წერს ალერტისას:
        //Assert.assertEquals(s, v.getAlert_text_2);

        //Back To Book Store

        WebElement back_to_bookStore= driver.findElement(By.xpath("//button[text()='Back To Book Store']"));
        js.executeScript("arguments[0].scrollIntoView(true);",back_to_bookStore);
        back_to_bookStore.click();

        // 8 books are returned in the table
        sleep(3000);
        List<WebElement> book_list2=driver.findElements(By.xpath("//img[@alt='image']"));
        Assert.assertEquals(book_list2.size(), 8);

        //Log out
        WebElement logout2= driver.findElement(By.xpath("//button[text()='Log out']"));
        logout2.click();

        sleep(3000);
        WebElement logout_text= driver.findElement(By.xpath("//div[@style='margin-bottom: 50px;']"));
        Assert.assertEquals(logout_text.getText(), v.logout_text1);

    }

}

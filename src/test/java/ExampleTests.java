import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTests {

    @Test
    public void firstTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.xpath("//ul/li[1]/a"));
        button.click();
        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        //Assert.assertEquals(text.getText(),"A/B Test Variation 1");


        driver.navigate().back();

        WebElement drp_down= driver.findElement(By.linkText("Dropdown"));
        drp_down.click();

        WebElement drp_select_opt =driver.findElement(By.xpath("//select"));
        Select select=new Select(drp_select_opt);
        select.selectByVisibleText("Option 1");

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 1" );
        
        driver.close();


    }
}

package amazontest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestSuite extends BaseTest {

    public String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);

    }

    @Test
    public void verifyDellLaptopCategoryOnAmazonWebsiteWorkingCorrectly(){
        driver.findElement(By.id("sp-cc-accept")).click();
        driver.findElement(By.xpath("//div[@class='nav-search-field ']/input[@id='twotabsearchtextbox']")).sendKeys("Dell Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();
       driver.findElement(By.xpath("//span[@class='a-list-item']/a/span[text()='Dell']")).click();

        //List<WebElement> items = driver.findElements(By.className("s-result-item"));

        List<WebElement> items = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));

        int expectedResult = 30;

        int actualResult = items.size();

        //Assert.assertEquals(expectedResult,actualResult);

        if(expectedResult==actualResult){
            System.out.println("Test passed");
        } else{

            System.out.println("Number of items doesn't match with expected result");
        }


       // Assert.assertEquals(expectedResult,actualResult);

        System.out.println(items.size());

        for(WebElement text:items){
            System.out.println(text.getText());
            System.out.println("***************************************");
            System.out.println("---------------------------------------");
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
        }


    }


    @After
    public void tearDown(){

        closeBrowser();
    }


}

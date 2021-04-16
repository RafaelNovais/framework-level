package webServiceTesting.unit;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.util.*;
import org.openqa.selenium.JavascriptExecutor;



public class DefaultSuiteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
@SuppressWarnings("deprecation")
@Test
  public void testPrice() {
	
    driver.get("https://qa-automation-challenge.github.io/sandbox/");
    {
      WebElement dropdown = driver.findElement(By.id("type"));
      dropdown.findElement(By.xpath("//option[. = 'Special']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("support"));
      dropdown.findElement(By.xpath("//option[. = 'Full']")).click();
    }
    driver.findElement(By.id("duration")).sendKeys("6");
    driver.findElement(By.id("comments")).sendKeys("teste6");
    driver.findElement(By.id("calculate")).click();
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("price")));
      }
    assertThat(driver.findElement(By.id("price")).getText(), is("2249.10 $"));
  }
}

package webTests;

//Script criado pelo SeleniumIDE

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class seleniumIDE {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "drivers/chrome/96/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);  //Para esperar um pouco de tempo!

        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void consultarCursoMantis() {
        driver.get("https://iterasys.com.br/");
        driver.manage().window().setSize(new Dimension(1420, 793));
        driver.findElement(By.id("searchtext")).click();
        driver.findElement(By.id("searchtext")).sendKeys("mantis");
        driver.findElement(By.cssSelector(".fa-search")).click();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Cursos › \"mantis\""));
        driver.findElement(By.cssSelector("span.comprar")).click();
        //assertThat(driver.findElement(By.cssSelector("span.comprar")).getText(), is("MATRICULE-SE  "));
        assertThat(driver.findElement(By.cssSelector("span.item-title")).getText(), is("Mantis"));
    }
    @Test
    public void consultarCursoCTFL() {
        driver.get("https://iterasys.com.br/");
        driver.manage().window().setSize(new Dimension(1420, 793));
        driver.findElement(By.id("searchtext")).click();
        driver.findElement(By.id("searchtext")).sendKeys("ctfl");
        driver.findElement(By.cssSelector(".fa-search")).click();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Cursos › \"ctfl\""));
        driver.findElement(By.cssSelector("span.comprar")).click();
        //assertThat(driver.findElement(By.cssSelector("span.comprar")).getText(), is("MATRICULE-SE  "));
        assertThat(driver.findElement(By.cssSelector("span.item-title")).getText(), is("Preparatório CTFL"));
    }
}

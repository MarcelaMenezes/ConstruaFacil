
//1-Pacotes
package webTests;

//2-Biblotecas
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

//3-Classes
public class seleniumSimples {

    //3.1 - Atributos
    WebDriver driver;        //Declara o objeto do selenium Webdriver

    @BeforeTest
            public void iniciar(){
        //A - Inicio
        //Aponta para onde está o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/96/chromedriver");

        //Instanciando o objeto driver como um controlador do Chrome.
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);  //Para esperar um pouco de tempo!

    }

    @AfterTest
            public void finalizar(){

        driver.quit();
    }


    //3.2- Metodos e funções
    @Test
    public void consultarCurso(){

        //B - Realizar teste
        driver.get("https://iterasys.com.br/");                                   //Abrir site alvo
        driver.findElement(By.id("searchtext")).click();                         //clicar no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                         //Limpar o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("mantis"); //Escrever "mantis" no campo

        driver.findElement(By.id("btn_form_search")).click();                   // Clique na lupa
        assertEquals(driver.findElement(By.cssSelector("h3")).getText(),"Cursos › \"mantis\"");  //Validar o resulto da pesquisa com nome


        driver.findElement(By.cssSelector("span.comprar")).click();   // Clica em Matricular
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Mantis");   //Verifica o nome do curso
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 59,99"); //Verifica o valor do curso

        driver.findElement(By.id("concluir_pedido")).click();   //Clica em "concluir pedido"


    }

    @Test
    public void consultarCursoCTFL(){
        //A - Inicio
        //Aponta para onde está o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/96/chromedriver");

        //Instanciando o objeto driver como um controlador do Chrome.
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);  //Para esperar um pouco de tempo!

        //B - Realizar teste
        driver.get("https://iterasys.com.br/");                                   //Abrir site alvo
        driver.findElement(By.id("searchtext")).click();                         //clicar no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                         //Limpar o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("preparatorio"); //Escrever "preparatorio" no campo

        driver.findElement(By.id("btn_form_search")).click();                   // Clique na lupa
        assertEquals(driver.findElement(By.cssSelector("h3")).getText(),"Cursos › \"preparatorio\""); //Validar o resulto da pesquisa com nome
        assertEquals(driver.findElement(By.cssSelector("span.titulo")).getText(),"Preparatório CTFL");  // Validar se o curso pesquiso é o mesmo


        driver.findElement(By.cssSelector("span.comprar")).click();   // Clica em Matricular
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Preparatório CTFL");   //Verifica o nome do curso
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 199,00"); //Verifica o valor do curso

        driver.findElement(By.id("concluir_pedido")).click();   //Clica em "concluir pedido"

    }

}



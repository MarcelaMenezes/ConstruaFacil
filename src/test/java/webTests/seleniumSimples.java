
//1-Pacotes
package webTests;

//2-Biblotecas
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Evidencias;
import utils.Logs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

//Chamando a classe Evidencias que tem a maquina de tirar as fotos

//3-Classes
public class seleniumSimples {

    //3.1 - Atributos
    WebDriver driver;        //Declara o objeto do selenium Webdriver
    Evidencias evidencias;
    Logs logs;

    static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-dd-mm").format(Calendar.getInstance().getTime());

    @BeforeTest
            public void iniciar(){
        //A - Inicio
        //Aponta para onde está o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/96/chromedriver");

        //Instanciando o objeto driver como um controlador do Chrome.
        driver = new ChromeDriver();  // Instanciando
        evidencias = new Evidencias();   //Intanciando
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);  //Para esperar um pouco de tempo!
        logs = new Logs();


    }

    @AfterTest
            public void finalizar(){

        driver.quit();
    }


    //3.2- Metodos e funções
    @Test(priority = 1)
    public void consultarCurso() throws IOException {

        String casoDeteste = "consultar curso Mantis";
        logs.registrarCSV("2021-07-14 20-36-05", "Consultar Curso Mantis", "Iniciou o teste");

        //B - Realizar teste
        driver.get("https://iterasys.com.br/");                                   //Abrir site alvo

       //Tirar print
        evidencias.print(driver,dataHora,casoDeteste, "Passo 1 - Abriu o site");

        driver.findElement(By.id("searchtext")).click();                         //clicar no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                         //Limpar o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("mantis"); //Escrever "mantis" no campo

        evidencias.print(driver,dataHora, casoDeteste, "Passo 2 - Digitou mantis");

        driver.findElement(By.id("btn_form_search")).click();                   // Clique na lupa
        assertEquals(driver.findElement(By.cssSelector("h3")).getText(),"Cursos › \"mantis\"");  //Validar o resulto da pesquisa com nome

        evidencias.print(driver,dataHora, casoDeteste, "Passo 3 - Exibiu a lista de cursos com o nome mantis");

        driver.findElement(By.cssSelector("span.comprar")).click();   // Clica em Matricular
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Mantis");   //Verifica o nome do curso
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 59,99"); //Verifica o valor do curso

        evidencias.print(driver,dataHora,casoDeteste, "Passo 4 - Exibiu o carrinho de compras");

        driver.findElement(By.id("concluir_pedido")).click();   //Clica em "concluir pedido"



    }

    @Test
    public void consultarCursoCTFL() throws IOException {

        String casoDeteste = "consultar curso Preparotoro CTFL";

        //A - Inicio
        //Aponta para onde está o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/96/chromedriver");

        //Instanciando o objeto driver como um controlador do Chrome.
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);  //Para esperar um pouco de tempo!

        //B - Realizar teste
        driver.get("https://iterasys.com.br/");                                   //Abrir site alvo

        evidencias.print(driver,dataHora,casoDeteste, "Passo 1 - Abriu o siteda Iterasys");

        driver.findElement(By.id("searchtext")).click();                         //clicar no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                         //Limpar o campo de pesquisa

        evidencias.print(driver,dataHora, casoDeteste, "Passo 2 - Digitou preparatorio");
        driver.findElement(By.id("searchtext")).sendKeys("preparatorio"); //Escrever "preparatorio" no campo

        driver.findElement(By.id("btn_form_search")).click();                   // Clique na lupa
        assertEquals(driver.findElement(By.cssSelector("h3")).getText(),"Cursos › \"preparatorio\""); //Validar o resulto da pesquisa com nome

        evidencias.print(driver,dataHora, casoDeteste, "Passo 3 - Exibiu a lista de cursos com o nome Preparatório");
        assertEquals(driver.findElement(By.cssSelector("span.titulo")).getText(),"Preparatório CTFL");  // Validar se o curso pesquiso é o mesmo

        evidencias.print(driver,dataHora, casoDeteste, "Passo 4 - Clicou em Matricular do Preparatório CTFL");
        driver.findElement(By.cssSelector("span.comprar")).click();   // Clica em Matricular
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Preparatório CTFL");   //Verifica o nome do curso
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 199,00"); //Verifica o valor do curso

        evidencias.print(driver,dataHora,casoDeteste, "Passo 5 - Clicou em concluir pedido");
        driver.findElement(By.id("concluir_pedido")).click();   //Clica em "concluir pedido"

    }

}



package webTests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class comprarCursoCS {
    WebDriver driver;

    @Before
    public void inciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/96/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize(); //maximizar a janela

        System.out.println("0 - Antes dos teste");
    }

    @After
    public void finalizar(){
       // driver.quit();
        System.out.println("Z - Depois do teste finalizado");
    }

    @Dado("^que acesso o site da Iterasys$")
    public void queAcessoOSiteDaIterasys() {
        driver.get("https://iterasys.com.br");

        System.out.println("1 - Acessou o site Iterasys");
    }

    @Quando("^pesquisar por \"([^\"]*)\"$")
    public void pesquisarPor(String curso)  {
        driver.findElement(By.id("searchtext")).click();  //Opcional
        driver.findElement(By.id("searchtext")).clear();  //Opcional
        //driver.findElement(By.id("searchtext")).sendKeys(curso);  //Digita de uma só vez!!
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(curso));  // Ele digita letra por letra!


        System.out.println("2 - Digitou o nome do curso " + curso);

    }

    @E("^clico na lupa$")
    public void clicoNaLupa() {
        driver.findElement(By.id("btn_form_search")).click();
        System.out.println("3 - Clicou na lupa");
    }

    @Entao("^vejo a lista de resultados para o cuso \"([^\"]*)\"$")
    public void vejoAListaDeResultadosParaOCuso(String curso)  {
        assertEquals(driver.findElement(By.cssSelector("h3")).getText(),"Cursos › \""+ curso +"\"");
        System.out.println("4 - Exibiu a lista de resultados para o curso "+ curso);

    }

    @Quando("^clico em Matricule-se$")
    public void clicoEmMatriculeSe() {
        driver.findElement(By.cssSelector("span.comprar")).click();
        System.out.println("5 - Clicou em matricule-se");
    }

    @Entao("^confirmo o nome do curso como \"([^\"]*)\" e o preco de \"([^\"]*)\"$")
    public void confirmoONomeDoCursoComoEOPrecoDe(String curso, String preco) {
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), curso);
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), preco);
        System.out.println("6 - Confirmou o preco "+ preco + " do curso " + curso);

    }

    @E("^pressiono Enter$")
    public void pressionoEnter() {
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER); //Keys controla o teclado
        System.out.println("3a - Clicou na lupa");
    }

    @Quando("^clico na imagem do curso$")
    public void clicoNaImagemDoCurso() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Preparatório CTAL-TA')]")).click();
        System.out.println("clico em Preparatório CTAL-TA");
    }

    @Entao("^vejo a pagina com detalhes do curso$")
    public void vejoAPaginaComDetalhesDoCurso() {

        assertEquals(driver.getTitle(),"Preparatório CTAL-TA - Iterasys");
        System.out.println("Entao valido Preparatório CTAL-TA");
    }

    @E("^clico no botao OK do popupda LGPD$")
    public void clicoNoBotaoOKDoPopupdaLGPD() {
        driver.findElement(By.cssSelector("a.cc-btn.cc-dismiss")).click();
        System.out.println("clico no botao OK do popupda LGPD");
    }

    @E("^clico no x de fechar o aviso$")
    public void clicoNoXDeFecharOAviso() {
        driver.findElement(By.cssSelector("span.closePwa")).click();
        System.out.println("clico no x de fechar o aviso");
    }
}

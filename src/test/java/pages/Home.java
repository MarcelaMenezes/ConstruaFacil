package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    //Classe de Mapeamento possui 3 seções
    //1 - Mapeamento de Elementos (Atributos)
    //2 - Construtor entrer os Elementos e os passos
    //3 - Funções d Métodos Mapeados

    // 1- Mapeamento
    WebDriver driver;

    @FindBy(id = "searchtext")
    WebElement caixaDePesquisa; //Similar ao que fazia antes
    // "driver.findElement(By.id("searchtext"))"

    @FindBy(id = "btn_form_search")
    WebElement botaoProcurar; //Botao procurar

    //2 - Construtor


    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //3 - Funções e Métodos
    public void pesquisarPorCurso(String curso){
        caixaDePesquisa.click();  //clicar na caixa
        caixaDePesquisa.clear();  //limpar caixa
        caixaDePesquisa.sendKeys(curso);  //escrever na caixa

    }

    public void clicarNaLupa(){
        botaoProcurar.click();  //clicar no botão
    }
}

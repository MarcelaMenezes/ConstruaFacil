package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resultado {
    WebDriver driver;

    //Texto onde fica escrito o curso > "Nome do curso"
  // @FindBy(xpath = "//body/main[1]/div[1]/div[1]/div[1]/h3[1]")
    @FindBy(css = "h3")
   WebElement indicadorDeCurso;

   @FindBy(css = "span.comprar")
    WebElement btmMatriculese;

   //Criar o contutor .... apertar o botao direito do mouse / Generate/ Constructor
    public Resultado(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);  //chamar a classe PageFactory
    }
    public  String lerIndicadorDeCurso(){
        return indicadorDeCurso.getText();
    }
    public void clicarMatriculese(){
        btmMatriculese.click();
    }
    public By verificarElemento(){
        return By.cssSelector("h3");
    }

}

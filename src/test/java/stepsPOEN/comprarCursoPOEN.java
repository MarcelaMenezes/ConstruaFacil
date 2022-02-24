package stepsPOEN;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class comprarCursoPOEN {


    @Given("^que acesso o site da Iterasys POeN$")
    public void queAcessoOSiteDaIterasysPO() {
        System.out.println("Passo 1");
    }

    @When("^pesquisar por \"([^\"]*)\" POEN$")
    public void pesquisarPorPO(String arg0) {
        System.out.println("Passo 2");
    }

    @And("^clico na lupa POEN$")
    public void clicoNaLupaPO() {
        System.out.println("Passo 3");
    }

    @Then("^vejo a lista de resultados para o cuso \"([^\"]*)\" POEN$")
    public void vejoAListaDeResultadosParaOCusoPO(String arg0) {
        System.out.println("Passo 4");

    }

    @When("^clico em Matricule-se POEN$")
    public void clicoEmMatriculeSePO() {
        System.out.println("Passo 5");
    }

    @Then("^confirmo o nome do curso como \"([^\"]*)\" e o preco de \"([^\"]*)\" POEN$")
    public void confirmoONomeDoCursoComoEOPrecoDePO(String arg0, String arg1) {
        System.out.println("Passo 6");
    }
}

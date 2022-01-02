package webTests;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class comprarCursoCS {
    @Dado("^que acesso o site da Iterasys$")
    public void queAcessoOSiteDaIterasys() {
    }

    @Quando("^pesquisar por \"([^\"]*)\"$")
    public void pesquisarPor(String arg0)  {

    }

    @E("^clico na lupa$")
    public void clicoNaLupa() {
    }

    @Entao("^vejo a lista de resultados para o cuso \"([^\"]*)\"$")
    public void vejoAListaDeResultadosParaOCuso(String arg0)  {

    }

    @Quando("^clico em Matricule-se$")
    public void clicoEmMatriculeSe() {
    }

    @Entao("^confirmo o nome do curso como \"([^\"]*)\" e o preco de \"([^\"]*)\"$")
    public void confirmoONomeDoCursoComoEOPrecoDe(String arg0, String arg1) {

    }
}

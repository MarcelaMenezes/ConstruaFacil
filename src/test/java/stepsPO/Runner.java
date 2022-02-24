package stepsPO;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = {"src/test/resources/FeaturesPO"}, //Onde estão os cenários em Gherkin
        glue = {"stepsPO"},   //Onde estão as definições dos cenários
        dryRun = false,      //Exibição do Log
        monochrome = true,  //Detalhes do Log
        plugin = {
               "pretty",      //Formatação visual do Cucumber
                "html:target/reports/extentreports",  //Saida HTML do Relatório Simples
                "json:target/reports/extentreports.json"  //Saida do Json com dados
               // "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"



        }
)
    public class Runner extends AbstractTestNGCucumberTests{  //Equivale ao @RunWith do JUnit

        //configuração de modelo de relatório

    }

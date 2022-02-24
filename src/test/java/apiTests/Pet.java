package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class Pet {

    //Padrão Gerkin
    //Given Dado
    //When
    //Then

    //Função de apoio
    public String lerJson(String caminhoJson) throws IOException {

        return new String(Files.readAllBytes(Paths.get(caminhoJson)));

    }


    @Test
    public void incluirPet() throws IOException { //Create -  Post

        String jsonBody = lerJson("src/test/resources/data/pet.json");

        given()                                                 //Dado
                .contentType("application/json")                  //Tipo de conteudo
                //"text/xml" para web services sicronos - ex: Correios
                //"äpplication/json"  para web services assincronos - ex:iFood
                .log().all()                                     //Registrar tudo do envio
                .body(jsonBody)
        .when()                                                    //Quando
                .post("https://petstore.swagger.io/v2/pet")  //Comando + endpoint

        .then()
                .log().all()                                       //Registrar tudo na volta
                .statusCode(200)                                  //Valida codigo do estado nativo
                //.body("code", is (200))                        //Valida codigo do estado no Json
                .body("id", is(1002))                //Valida o id do animal
                .body("name",is("Pitbull"))          //valida nome do animal
                .body("category.name", is("dog"))    //valida a categoria do animal
                //.body("tags.name",not(contains("nao vermifungado"))) //valida se contem a palavra chave
                .body("tags.name", contains("animal vermifungado e com tos as vacinas em dia")) //valida se contem a palavra chave
        ;


    }

    @Test
    public void consultarPet(){ // Post - Consultar
        String petId = "1002";  //Id do animal

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId) //Get  == consultar

        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Pitbull"))
                .body("status", is("available"))
        ;
    }


}

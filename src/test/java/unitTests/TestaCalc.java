package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestaCalc {
    @Test
    public void testarsomarDoisNumeros(){

        //Prepara - Configurar - Given
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;

        //Executa - when (Quando)
        int resultadoAtual =  Calc.somarDoisNumeros(num1,num2);

        //Validar - then (Então)

        System.out.println("O resulatdo esperado é "+ resultadoEsperado + "\nO resultado atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado,resultadoAtual);
    }

    @Test
    public void testarmultiplicarDoisNumeros(){

        //Prepara - Configurar - Given
        int num1 = 5;
        int num2 = 5;
        int resultadoEsperado = 25;

        //Executa - when (Quando)
        int resultadoAtual = Calc.multiplicarDoisNumeros(num1,num2);

        //Validar - then (Então)

        System.out.println("O resulatdo esperado é "+ resultadoEsperado + "\nO resultado atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado,resultadoAtual);
    }
    @Test
    public void testardividirDoisNumeros(){

        //Prepara - Configurar - Given
        int num1 = 10;
        int num2 = 5;
        int resultadoEsperado = 2;

        //Executa - when (Quando)
        int resultadoAtual = Calc.dividirDoisNumeros(num1,num2);

        //Validar - then (Então)

        System.out.println("O resulatdo esperado é "+ resultadoEsperado + "\nO resultado atual foi " + resultadoAtual);
        assertEquals(resultadoEsperado,resultadoAtual);
    }


    @Test
    public void testardividirDoisNumerosErroZero(){
//        given
        int num1 = 10;
        int num2 = 0;
       int resultadoEsperado = 0;

        //when
        int resultadoAtual = Calc.dividirDoisNumeros(num1,num2);

        //then
        assertEquals(resultadoEsperado,resultadoAtual);

    }

}

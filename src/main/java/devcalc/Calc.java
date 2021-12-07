//1-Pacote (onde mora)
package devcalc;

//2- Bibliotecas

import java.util.Scanner;

//3 - Classe
public class Calc {
    //3.1 - Atributos

   static Scanner entrada = new Scanner(System.in);  //entrada input

    //3.2 - Metodos e Funções

    public static void main(String[] arg){
        //Exibe o nemu da calculadora
        System.out.println(">>> CALCULADORA <<<");
        System.out.println("(1) Soma");
        System.out.println("(2) Subtração)");
        System.out.println("(3) Multiplicação");
        System.out.println("(4) Divisão");
        System.out.println("Esclha o Calculo Desejado");

        //Recebe a opção desejada
        int opcao = entrada.nextInt();
        int num1 = 0;
        int num2 = 0;

        //Pergunta os valores a serem usados no calculo
        System.out.print("Digite o 1* numero: ");
        num1 = entrada.nextInt();
        System.out.print("Digite o 2* numero: ");
        num2 = entrada.nextInt();

        //Chama a função do calculo desejado
        switch (opcao){
            case 1:
                somarDoisNumeros(num1, num2);
                break;
            case 2:
                subtrairDoisNumeros(num1, num2);
                break;
            case 3:
                multiplicarDoisNumeros(num1, num2);
                break;
            case 4:
                dividirDoisNumeros(num1, num2);
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }

        System.out.println("Passou pelo método main");
        System.out.println("O Reultado é : "+ somarDoisNumeros(num1, num2));


    }
    public static int somarDoisNumeros(int num1, int num2){
        System.out.println("Passou pelo método somarDoisNumeros");
        return num1 + num2;
    }

    public static int subtrairDoisNumeros(int num1, int num2){
        System.out.println("Passou pelo método subtrairDoisNumeros");
        return num1 - num2;
    }
    public static int multiplicarDoisNumeros(int num1, int num2){
        System.out.println("Passou pelo método multiplicarDoisNumeros");
        return num1 * num2;
    }
    public static int dividirDoisNumeros(int num1, int num2){
        System.out.println("Passou pelo método dividirDoisNumeros");
        if(num1 == 0 || num2 == 0){
            System.out.println("Escolha outro numero!!");
            System.out.println("Passou pelo método dividirDoisNumerosErroZero");
            return 0;
        }

        return num1 / num2;
    }
}


import java.text.DecimalFormat;

import java.util.Scanner;

import java.io.*;

import java.lang.Thread;


public class TaxaDeJurosReal {

    public static void main (String [] args){


    Scanner scanner = new Scanner(System.in);


    System.out.println("Este programa calcula a taxa de juros real do seu investimento\nvocê deve digitar os números como porcentagem\nlembre-se também de digitar a inflação e o juros nominal na mesma medida de tempo.");


    try {
        Thread.sleep(5000);
    } catch (InterruptedException x){
        
    }
    


    System.out.print("Digite a taxa de juros nominal: ");

    Double juros = scanner.nextDouble();

    System.out.print("Digite a inflação do período: ");

    Double inflacao = scanner.nextDouble();

    scanner.close();


    Double N = (juros / 100) + 1;

    Double h = (inflacao / 100) + 1;

    Double R = (N / h) - 1;

    Double real = R * 100;


    System.out.println("A taxa de juros real é " + new DecimalFormat("#,##0.00").format(real) + "%");


}

}
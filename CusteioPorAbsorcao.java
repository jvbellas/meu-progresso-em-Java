
import java.util.Scanner;
import java.util.ArrayList;

public class CusteioPorAbsorcao {
    public static void main (String [] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("numero de produtos: ");
        int quantDeProdutos = scanner.nextInt();
        ArrayList <Double> consumoDosProdutos = new ArrayList<>();
        
        
        for (int i = 1; i <= quantDeProdutos; i++){
            System.out.print("consumo do produto " + i + " ");
            double consumo = scanner.nextDouble();
            consumoDosProdutos.add(consumo);
        }
        
        double consumoTotal = 0.0;
        
        for (int n = 0; n < consumoDosProdutos.size();n++){
            consumoTotal += consumoDosProdutos.get(n);
        }
        
        System.out.print("custo variavel total: ");
        double custoVariavel = scanner.nextDouble();
        
        double razao = custoVariavel / consumoTotal;
        
        ArrayList <Double> rateio = new ArrayList<>();
        
        for (int i = 0; i < consumoDosProdutos.size();i++){
            rateio.add(razao * consumoDosProdutos.get(i));
        }
        
        System.out.println("os valores rateados sao:");
        
        for(int i = 0; i < rateio.size();i++){
            int controle = i + 1;
            System.out.println("produto " + controle + " : " + rateio.get(i));
        }
    }
}
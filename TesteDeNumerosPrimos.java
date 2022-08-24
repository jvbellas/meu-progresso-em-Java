import java.util.ArrayList;

public class TesteDeNumerosPrimos{
    public static void main (String[] args){
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <=50; i++){
            numeros.add(i);
        }
        try{
            for(int n : numeros){
                int divisor = numeros.get(n) - 1;
                int teste;
                int acumulador = 0;
            
                do {
                    teste = numeros.get(n) % divisor;
                    acumulador += teste;
                    if (teste > 0) {
                        divisor--;
                    }
                    }while (teste > 0 && divisor > 1);
                if (divisor == 1){
                System.out.println("O número " + numeros.get(n) + " é primo");
                }
                else {
                    if (divisor > 1){
                    System.out.println("O número " + numeros.get(n) + " é um número composto");
                    }
                }
            }
        }catch(Exception e){
            System.out.println("a lista chegou ao fim");
        }
    }
}
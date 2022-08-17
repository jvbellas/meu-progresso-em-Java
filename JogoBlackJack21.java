
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JogoBlackJack21{
    public static void main (String[] args){
        ArrayList<Integer> cartas = new ArrayList<>();
        cartas.addAll(Arrays.asList(1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10));
        
        ArrayList<Integer> jogador = new ArrayList<>();
        ArrayList<Integer> maquina = new ArrayList<>();
        
        Random aleatorio = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int saldoJogador = 0;
        int i = 0;
        String entrada;
        
        int saldoMaquina = 0;
        int distancia21 = 21;
        double cartasParaEstourar = 0.0;
        double probabilidade = 0.0;
        int somaDasCartas = 0;
        
        for(int n : cartas){
            somaDasCartas += cartas.get(n);
        }
        
        do{
            int indexJogador = aleatorio.nextInt(cartas.size());
            jogador.add(cartas.get(indexJogador));
            cartas.remove(indexJogador);
            int indexMaquina = aleatorio.nextInt(cartas.size());
            maquina.add(cartas.get(indexMaquina));
            cartas.remove(indexMaquina);
            System.out.println("a sua carta foi " + cartas.get(indexJogador));
            System.out.println("a carta da maquina foi " + cartas.get(indexMaquina));
            
            somaDasCartas -= indexMaquina;
            saldoMaquina += maquina.get(i);
            distancia21 -= saldoMaquina;
            cartasParaEstourar = saldoMaquina - distancia21;
            probabilidade = (double) cartasParaEstourar / somaDasCartas;
            
            if (saldoMaquina > 21) {
                System.out.println("a banca quebrou, voce ganhou");
                break;
            }
            
            saldoJogador += jogador.get(i);
            
            if (saldoJogador > 21){
                System.out.println("voce perdeu");
                break;
            }
            i++;
            System.out.print("mais uma carta ou para?\n");
            entrada = scanner.nextLine();
            
        }while (entrada.equals("1") && probabilidade < 0.22);
        
        System.out.println("alguem decidiu parar");
        System.out.println((saldoJogador > saldoMaquina) ? "voce ganhou" : "voce perdeu");

        scanner.close();
    }
}

//pensar em alguma forma de um jogador parar e outro continuar
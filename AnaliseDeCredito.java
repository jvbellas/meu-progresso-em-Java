
/*
criar classe Pessoas com atributos salario, grau de endividamento e idade
criar metodo que cria pessoas com atributos aleatorios
analisar estatisticamente o risco de cada pessoa com base em alguma regra
risco baixo, médio ou alto
gerar estatística da média de idade das pessoas
*/

import java.util.Random;

class Pessoas {
    private int idade;
    private int salario;
    private int endividamento;
    
    public void setIdade(){
        Random aleatorio = new Random();
        this.idade = aleatorio.nextInt(100) + 1;
    }
    
    public void setSalario(){
        Random aleatorio = new Random();
        this.salario = aleatorio.nextInt(10000) + 1;
    }
    
    public void setEndividamento(){
        Random aleatorio = new Random();
        this.endividamento = aleatorio.nextInt(100) + 1;
    }  
    
    public int getIdade(){
        return idade;        
    }
    
    public int getSalario(){
        return salario;
    }
    
    public int getEndividamento(){
        return endividamento;
    }
    
    public int getPessoaInfo(){
        System.out.println("a idade é " + idade + "\no salário é " + salario + "\no endividamento é " + endividamento);
        return 1;
    }
    
}

public class AnaliseDeCredito {
    public static void main (String [] args) {

        Pessoas pessoa = new Pessoas();
        pessoa.setIdade();
        pessoa.setSalario();
        pessoa.setEndividamento();
        
        pessoa.getPessoaInfo();
        
        boolean maioridade = (pessoa.getIdade() >= 18) ? true : false;
        
        boolean salarioMinimo = (pessoa.getSalario() >= 1500 ? true : false);
        
        if ( maioridade == false || salarioMinimo == false) {
            System.out.println("Não possui pré-requisitos");
        }
        
        String faixaEtaria = "a";
        
        if(pessoa.getIdade() >= 18 && pessoa.getIdade() <30) {
            faixaEtaria = "jovem";
        }else if (pessoa.getIdade() >= 30 && pessoa.getIdade() < 60){
            faixaEtaria = "adulto";
        }else if (pessoa.getIdade() >= 60){
            faixaEtaria = "idoso";
        }
        
        String faixaSalarial = "a";
        
        if(pessoa.getSalario() >= 1500 && pessoa.getSalario() < 3000){
            faixaSalarial = "baixa";
        } else if (pessoa.getSalario() >= 3000 && pessoa.getSalario() < 5000){
            faixaSalarial = "media";
        } else if (pessoa.getSalario() >= 5000){
            faixaSalarial = "alta";
        }
        
        String grauDeEndividamento = "a";
        
        if (pessoa.getEndividamento() <= 40){
            grauDeEndividamento = "baixo";
        } else if(pessoa.getEndividamento() > 40 && pessoa.getEndividamento() <= 60){
            grauDeEndividamento = "medio";
        } else if(pessoa.getEndividamento() > 60){
            grauDeEndividamento = "alto";
        }
        
        String risco = "a";
        
        if(faixaSalarial.equals("media") && grauDeEndividamento.equals("baixo")){
            risco = "baixo";
        } else if (faixaSalarial.equals("alta") && grauDeEndividamento.equals("baixo")){
            risco = "baixo";
        } else if (faixaSalarial.equals("alta") && grauDeEndividamento.equals("medio")){
            risco = "medio";
        } else {
            risco = "alto";
        }
        
        System.out.println("o cliente é " + faixaEtaria + " e possui risco de crédito " + risco);
        
    }
}
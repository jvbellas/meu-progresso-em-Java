
// A MINHA BUSCA ESTÁ CASE SENSITIVE, COMO DEIXÁ-LA INSENSITIVE?

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class DensidadeDePalavrasGUI extends JFrame{
    
    public JLabel lblTexto;
    public JTextField jtfTexto;
    public JLabel lblPalavraChave;
    public JTextField jtfPalavraChave;
    public JButton btnOk;
    
    public DensidadeDePalavrasGUI(){
        
        lblTexto = new JLabel("Cole aqui o texto a ser analisado");
        jtfTexto = new JTextField();
        lblPalavraChave = new JLabel("Digite aqui a palavra chave");
        jtfPalavraChave = new JTextField();
        
        JPanel pGrid = new JPanel(new GridLayout(12,12));
                
        pGrid.add(lblTexto);
        pGrid.add(jtfTexto);
        pGrid.add(lblPalavraChave);
        pGrid.add(jtfPalavraChave);
        
        
        btnOk = new JButton("Ok");
        
        btnOk.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                String texto = jtfTexto.getText();
                String palavra = jtfPalavraChave.getText();
                
                String textoLimpo = texto.replaceAll("[^abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789]", " ");
                
                String[] textoOtimizadoArray = textoLimpo.split("\\s+");
                ArrayList<String> textoOtimizado = new ArrayList<>(Arrays.asList(textoOtimizadoArray));
                
        
                int contador = 0;
                int n = 0;
        
                do{
                    if (palavra.equalsIgnoreCase(textoOtimizado.get(n))){
                        contador += 1;
                    }
                    n++;
                } while(n < textoOtimizado.size());
                
                double densidade = (double) contador / textoOtimizado.size();

                JOptionPane.showMessageDialog(null,"a palavra " + palavra + " aparece no texto " + contador + " vezes e a densidade da palavra é de: " + new DecimalFormat("#,##0.00").format(densidade));
             
            }
        });
        
        JPanel pBotoes = new JPanel(new GridLayout(0,1));
        pBotoes.add(btnOk);
        
        this.setLayout(new BorderLayout());
        this.getContentPane().add(pGrid,BorderLayout.NORTH);
        this.getContentPane().add(pBotoes,BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Densidade de palavras");
        this.setSize(500,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

public static void main (String[] args){
    JFrame.setDefaultLookAndFeelDecorated(true);
    new DensidadeDePalavrasGUI();

    }
}
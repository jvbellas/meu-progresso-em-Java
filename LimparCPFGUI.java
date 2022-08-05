import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class LimparCPFGUI extends JFrame {
    public JLabel lblDocumento;
    public JTextField jtfDocumento;
    
    public JButton btnBotaoOk;
    
    public LimparCPFGUI() {
        
        //painel com os dados
        lblDocumento = new JLabel("Documento: ");
        jtfDocumento = new JTextField();
        
        JPanel pGrid = new JPanel(new GridLayout(3,2));
        pGrid.add(lblDocumento);
        pGrid.add(jtfDocumento);
        
        //painel com os comandos
        btnBotaoOk = new JButton("OK");
        btnBotaoOk.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String documento = jtfDocumento.getText();
                String cpfLimpo = documento.replaceAll("[^0123456789]","");
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection ss = new StringSelection(cpfLimpo);
                clipboard.setContents(ss, ss);            }
        });
        
        JPanel pBotoes = new JPanel(new GridLayout(0,2));
        pBotoes.add(btnBotaoOk);
        //painel do JFrame
        this.setLayout(new BorderLayout());
        this.getContentPane().add(pGrid,BorderLayout.NORTH);
        this.getContentPane().add(pBotoes,BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Cadastro");
        this.setSize(400,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
        
    public static void main (String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new LimparCPFGUI();
    }
}
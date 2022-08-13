import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BancoDeNomes{
    public static void main (String[] args) {
                
        Connection connection = null;
            try {
                String driverName = "com.mysql.cj.jdbc.Driver";
                Class.forName(driverName);
                
                String serverName = "localhost:";
                String mydatabase = "bancodenomes";
                String url = "jdbc:mysql://"+serverName+"/"+mydatabase;
                String username = "root";
                String password = "senha";
                connection = DriverManager.getConnection(url, username, password);
            }catch(ClassNotFoundException e){
                
            }catch (SQLException e){
            }
            
            if (connection != null){
                System.out.println("conectado");
            }
            else {
                System.out.println("falha na conexao");
            }
            try{
                Statement stmt = connection.createStatement();
                Scanner scnr = new Scanner(System.in);
                System.out.print("digite um nome qualquer: ");
                String nome = scnr.next();
                String sql = "INSERT INTO nomes (nome) VALUES ('" + nome + "');";
                stmt.executeUpdate(sql);
                //criar um select para mostrar os nomes
                String consulta = "SELECT * FROM nomes;";
                ResultSet rs = stmt.executeQuery(consulta);
                
                ArrayList lista = new ArrayList();
                
                while (rs.next()){
                    lista.add(rs.next());
                }
                
                System.out.println("a lista contém " + lista.size() + " nomes");
                
                String consulta2 = "SELECT nome FROM nomes WHERE nome = '" + nome + "'";
                ResultSet rs2 = stmt.executeQuery(consulta2);
                
                ArrayList lista2 = new ArrayList();
                
                while (rs2.next()){
                    lista2.add(rs2.next());
                }
                                
                if (lista2.size() > 1){
                    System.out.println("o nome que você inseriu já foi digitado antes");
                } else {
                    System.out.println("o nome que você inseriu ainda não havia sido digitado");
                }
                
                
                if (lista2.size() > 1){
                    String delete = "DELETE from nomes WHERE nome = '" + nome + "'";
                    int x = stmt.executeUpdate(delete);
                    if (x > 0){
                        System.out.println("registro duplicado excluído com sucesso");
                    } else {
                        System.out.println("um erro ocorreu ao excluir o registro duplicado");
                    }
                }
                
                
            }catch (SQLException e){
                
            }
    }
}

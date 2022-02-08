/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ConnectionFactory {
    
   private static final String DRIVER  = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://pmatualizado.mysql.uhserver.com/pmatualizado";
    private static final String USER = "menteatentadsv";
    private static final String PASSWORD = "Muller1@";
    
    public static Connection getConnection(){
         try {
            Class.forName(DRIVER);    
            return DriverManager.getConnection(URL,USER,PASSWORD);                                
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na Conexão, Banco não encontrado: ",ex);
        }
    }
     public static Connection getConnection(JFrame jframe){
         try {
            Class.forName(DRIVER);    
            return DriverManager.getConnection(URL,USER,PASSWORD);                                
        } catch (ClassNotFoundException | SQLException ex) {
             JOptionPane.showMessageDialog(jframe, "Erro na Conexãom. Não foi possível se conectar ao servidor Banco de Dados\nVerifique sua Conexão e tente novamente!");
              throw new RuntimeException("Erro na Conexão, Banco não encontrado: ",ex);
        }
    }
    
    public static void closeConnection( Connection con){
        try {
            if(con!= null){
           
                con.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
     public static void closeConnection( Connection con, PreparedStatement stmt){
           
         closeConnection(con); 
         try {
             if(stmt != null){
                 stmt.close();
             }
         } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
     
     public static void closeConnection( Connection con, PreparedStatement stmt, ResultSet rs){
           
         closeConnection(con,stmt); 
         try {
             if(rs != null){
                 rs.close();
             }
         } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}

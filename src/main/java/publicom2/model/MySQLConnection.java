/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package publicom2.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l.blee
 */
public class MySQLConnection {
    
    private static final String url = "jdbc:mysql://localhost:3306/mlr_publicom";
    private static final String user = "root";
    private static final String pass = "";
    
    private static Connection con = null;
    
    public static Connection getConnexion(){
        
        if(con == null){
            try {
                Class.forName("com.mysql.cj.jbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex){
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
    
}

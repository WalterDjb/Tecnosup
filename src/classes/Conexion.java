/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.*;

/**
 *
 * @author Walter Benítez
 */
public class Conexion {
    
    public static Connection connect(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/db_tecno", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexión " + e);
        }
        return null;
    }
}

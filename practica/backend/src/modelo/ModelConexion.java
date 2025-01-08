/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abel Gomez
 */
public class ModelConexion {

    String url = "jdbc:postgresql://localhost/crudPersona";
    String usuario = "postgres";
    String clave = "narexd";

   // Base de datos en railway
//    String url = "jdbc:postgresql://autorack.proxy.rlwy.net:41568/railway";
//    String usuario = "postgres";
//    String clave = "UnBUgihVweamrrpNvEwZcuBEPQqBuJmS";

    // Agrega el resto de tu implementación aquí



    Connection conn = null;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public ModelConexion() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelConexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException ex) {
            Logger.getLogger(ModelConexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet consulta(String sql) {

        try {
            Statement at = conn.createStatement();
            return at.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean accion(String sql) {
        //INSERT-UPDATE-DELETE

        boolean correcto;

        try {
            Statement at = conn.createStatement();
            at.execute(sql);
            at.close();//Cierro la conexion
            correcto = true;

        } catch (Exception e) {
            Logger.getLogger(ModelConexion.class.getName()).log(Level.SEVERE, null, e);
            correcto = false;
        }
        return correcto;
    }

}

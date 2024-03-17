package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    /*Variables para la conexion de base de datos*/
    /*indicador de conexion para la base de datos*/
    public static Connection conexion;
    /*ubicacion para la conexion de base de datos*/
    public static final String driver = "com.mysql.jdbc.Driver";
    /*usuario root para la conexion de base de datos*/
    public static final String user = "root";
    /*contraseña para la conexion de base de datos*/
    public static final String pass = "";
    /*link para la conexion de base de datos*/
    public static final String url = "jdbc:mysql://localhost:3306/db_calzado";
    
    
    /*Este metodo nos permite enceder la base de datos*/
    public Conexion(){
        conexion = null;
        try {
            Class.forName(driver);
            try {
                this.conexion = (Connection) DriverManager.getConnection(url, user, pass);
                if (conexion != null) {
                    System.out.println("Conexion Correcta");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Este metodo nos permite apagar la base de datos*/
    public void desconectar(){
        this.conexion = null;
    }

    public static Connection getConexion() {
        return conexion;
    }
    
    public PreparedStatement prepareStatement(String string){
        throw new UnsupportedOperationException("No soporta la operacion");
    }
}

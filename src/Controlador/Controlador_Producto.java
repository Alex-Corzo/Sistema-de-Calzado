package Controlador;

import Conexion.Conexion;
import static Controlador.Controlador_Cliente.conexion;
import static Controlador.Controlador_Cliente.sentencia_Preparada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador_Producto {
    public static Conexion conexion = new Conexion();
    public static PreparedStatement sentencia_Preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    
    public int guardarProducto(String nombre,String precio,String marca,String talla,String color,String tipo){
        int resultado = 0;
        Connection cn = null;
        String sentenciaGuardar = "INSERT INTO producto(nombre,precio,marca,talla,color,tipo) VALUES(?,?,?,?,?,?)";
        cn = conexion.getConexion();
        try {
            sentencia_Preparada = cn.prepareStatement(sentenciaGuardar);
            sentencia_Preparada.setString(1, nombre);
            sentencia_Preparada.setString(2,precio);
            sentencia_Preparada.setString(3, marca);
            sentencia_Preparada.setString(4, talla);
            sentencia_Preparada.setString(5, color);
            sentencia_Preparada.setString(6, tipo);
            resultado = sentencia_Preparada.executeUpdate();
            sentencia_Preparada.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }
}

package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_Cliente {
    public static Conexion conexion = new Conexion();
    public static PreparedStatement sentencia_Preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    
    public int guardarCliente(String nombre,String apellido_paterno,String apellido_materno,String correo_electronico){
        int resultado = 0;
        Connection cn = null;
        String sentenciaGuardar = "INSERT INTO clientes(nombre,apellido_paterno,apellido_materno,correo_electronico) VALUES(?,?,?,?)";
        cn = conexion.getConexion();
        try {
            sentencia_Preparada = cn.prepareStatement(sentenciaGuardar);
            sentencia_Preparada.setString(1, nombre);
            sentencia_Preparada.setString(2,apellido_paterno);
            sentencia_Preparada.setString(3, apellido_materno);
            sentencia_Preparada.setString(4, correo_electronico);
            resultado = sentencia_Preparada.executeUpdate();
            sentencia_Preparada.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }
}

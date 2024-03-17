package Controlador;

import Conexion.Conexion;
import static Controlador.Controlador_Cliente.conexion;
import static Controlador.Controlador_Cliente.sentencia_Preparada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Controlador_Usuario {
    public static Conexion conexion = new Conexion();
    public static PreparedStatement sentencia_Preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    
    public int guardarUsuario(String nombre,String apellido_paterno,String apellido_materno,String correo_electronico,String contraseña){
        int resultado = 0;
        Connection cn = null;
        String sentenciaGuardar = "INSERT INTO usuario(nombre,apellido_paterno,apellido_materno,correo_electronico,contraseña) VALUES(?,?,?,?,?)";
        cn = conexion.getConexion();
        try {
            sentencia_Preparada = cn.prepareStatement(sentenciaGuardar);
            sentencia_Preparada.setString(1, nombre);
            sentencia_Preparada.setString(2,apellido_paterno);
            sentencia_Preparada.setString(3, apellido_materno);
            sentencia_Preparada.setString(4, correo_electronico);
            sentencia_Preparada.setString(5, contraseña);
            resultado = sentencia_Preparada.executeUpdate();
            sentencia_Preparada.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }
    
    public static String BuscarUsuarioRegistrado(String correo,String contraseña){
            String busqueda_usuario=null;
             Connection Conexion=null;
        try{
            Connection cn=conexion.getConexion(); 
            String sentencia_buscar_usuario=("SELECT nombre,apellido_paterno,apellido_materno,correo_electronico,contraseña FROM usuario WHERE correo_electronico = '" + correo + "' && contraseña = '" + contraseña+ "'");
            PreparedStatement setencia_Preparada=cn.prepareStatement(sentencia_buscar_usuario);
            resultado=setencia_Preparada.executeQuery();
            if(resultado.next()){
                busqueda_usuario="Usuario encontrado";
            }else{
                busqueda_usuario="Usuario no encontrado";
            }
        }catch(Exception e){
                 System.out.println(e);
            }
        return busqueda_usuario;
    }
}

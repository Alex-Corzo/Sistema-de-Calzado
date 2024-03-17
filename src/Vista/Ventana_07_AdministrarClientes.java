package Vista;

import Conexion.Conexion;
import Controlador.Producto;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventana_07_AdministrarClientes extends javax.swing.JFrame {
    private int numeroFilas = 0;
    Conexion modeloProducto = new Conexion();
    Connection conexion = modeloProducto.getConexion();
    private ArrayList<Producto> productos;
    private DefaultTableModel modelo;
    public Ventana_07_AdministrarClientes() {
        initComponents();
        this.cargar();
    }
    public void cargar() {
        String[] informacionPedido = {"id","nombre", "apellido_paterno", "apellido_materno", "correo_electronico"};
        String[] registros = new String[50];
        String sql = "SELECT *FROM clientes";
        modelo = new DefaultTableModel(null, informacionPedido);
        Conexion conexion = new Conexion();
        Connection conexion1 = conexion.getConexion();
        try {
            Statement st = (Statement) conexion1.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellido_paterno");
                registros[3] = rs.getString("apellido_materno");
                registros[4] = rs.getString("correo_electronico");
                modelo.addRow(registros);
                numeroFilas ++;
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    
    public void eliminarRegistro(){
        try{
            int fila = tabla.getSelectedRow();
            String sql = "delete from clientes where id=" + tabla.getValueAt(fila, 0);
            Statement st = conexion.createStatement();
            int n = st.executeUpdate(sql);
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "cliente eliminado Satisfactoriamente");
            }
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente"+e);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, 370));

        jLabel1.setText("Administrar Clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 90, 50));

        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 90, 50));

        jButton4.setText("REGRESAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 110, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eliminarRegistro();
        this.cargar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            modificarRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(Ventana_07_AdministrarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cargar();
    }//GEN-LAST:event_jButton3ActionPerformed
    public void modificarRegistro() throws SQLException{
        for (int i = 0; i < this.numeroFilas; i++) {
            modificar(i);
        }
    }
    public void modificar (int fila){
        String id = this.tabla.getValueAt(fila, 0).toString();
        String nombre = this.tabla.getValueAt(fila, 1).toString();
        String apellido_paterno = this.tabla.getValueAt(fila, 2).toString();
        String apellido_materno = this.tabla.getValueAt(fila, 3).toString();
        String correo_electronico = this.tabla.getValueAt(fila, 4).toString();
        try {
            PreparedStatement ps = conexion.prepareStatement("update clientes set nombre='"+nombre+"', apellido_paterno='"+apellido_paterno+"',apellido_materno='"+apellido_materno+"',correo_electronico='"+correo_electronico+"' where id = '" + id +"'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han modificado los datos");
        } catch (SQLException ex) {
            Logger.getLogger(Ventana_05_BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

package Vista;
import Conexion.Conexion;
import Controlador.Controlador_Producto;
import Controlador.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Ventana_04_Verificar extends javax.swing.JFrame {
    Conexion modeloProducto = new Conexion();
    Connection conexion = modeloProducto.getConexion();
    private LinkedList productos;
    private DefaultTableModel modelo;
    private int contenedor = 0;
    public Ventana_04_Verificar(LinkedList<Producto> productos) {
        initComponents();
        this.productos = productos;
        this.cargar();
        this.cargarTotal();
    }
    
    public void cargar(){
        String [][][][] datos = {};
        String columna[] = {"nombre","precio","marca","talla","color","tipo"};
        modelo = new DefaultTableModel(datos, columna);
        tabla.setModel(modelo);

     }
    
    public void cargarTotal(){
        Producto producto;
        for (int i = 0; i < productos.size(); i++) {
            producto = (Producto) productos.get(i);
            modelo.insertRow(contenedor,new Object[]{});
            modelo.setValueAt(producto.getNombre(), contenedor, 0);
            modelo.setValueAt(producto.getPrecio(), contenedor, 1);
            modelo.setValueAt(producto.getMarca(), contenedor, 2);
            modelo.setValueAt(producto.getTalla(), contenedor, 3);
            modelo.setValueAt(producto.getColor(), contenedor, 4);
            modelo.setValueAt(producto.getTipo(), contenedor, 5);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 500, 360));

        jLabel1.setText("Verificar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jButton1.setText("Enviar Producto");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 140, 40));

        jButton2.setText("Cancelar Producto");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 140, 40));

        jButton3.setText("REGRESAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.cancelar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.agregarProducto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void cancelar(){
        int respuesta = JOptionPane.showConfirmDialog(this, "¿QUIERES CANCELAR TU PRODUCTO?");
        if (respuesta == JOptionPane.YES_OPTION) {
            try{
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    modelo.removeRow(fila);
                    limpiar();
                    productos.remove(fila);
                    JOptionPane.showMessageDialog(null, "SE ELIMINO EL PRODUCTO");
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA");
                    productos.remove(fila);
                    limpiar();
                    dispose();
                    
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public void limpiar(){
        int eliminar = tabla.getRowCount();
        for (int i = eliminar-1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        JOptionPane.showMessageDialog(this, "SE GUARDARON LOS CAMBIOS");
    }
    
    public void agregarProducto(){
                for (int i = 0; i < tabla.getRowCount(); i++) {
            try {
                PreparedStatement pst = conexion.prepareStatement("INSERT INTO producto(nombre,precio,marca,talla,color,tipo) VALUES(?,?,?,?,?,?)");
                pst.setString(1,tabla.getValueAt(i, 0).toString());
                pst.setString(2,tabla.getValueAt(i, 1).toString());
                pst.setString(3,tabla.getValueAt(i, 2).toString());
                pst.setString(4, tabla.getValueAt(i, 3).toString());
                pst.setString(5, tabla.getValueAt(i, 4).toString());
                pst.setString(6, tabla.getValueAt(i, 5).toString());
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Ventana_04_Verificar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Se esta enviando el pedido");
        Ventana_05_BaseDeDatos basedatos = new Ventana_05_BaseDeDatos();
        basedatos.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

package Vista;
import Controlador.Controlador_Usuario;
import javax.swing.JOptionPane;
public class Ventana_02_Registrar extends javax.swing.JFrame {
    private Character caracter;
    private Controlador_Usuario usuario = new Controlador_Usuario();
    public Ventana_02_Registrar() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apellido_paterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        apellido_materno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        correo_electronico = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 450));

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel1.setText("REGISTRAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 180, 40));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        nombre.setBackground(new java.awt.Color(204, 204, 204));
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 220, -1));

        jLabel3.setText("Apellido Paterno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        apellido_paterno.setBackground(new java.awt.Color(204, 204, 204));
        apellido_paterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(apellido_paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 220, -1));

        jLabel4.setText("Apellido Materno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        apellido_materno.setBackground(new java.awt.Color(204, 204, 204));
        apellido_materno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(apellido_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 220, -1));

        jLabel5.setText("Correo Electronico");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        correo_electronico.setBackground(new java.awt.Color(204, 204, 204));
        correo_electronico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(correo_electronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 220, -1));

        contraseña.setBackground(new java.awt.Color(204, 204, 204));
        contraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 220, -1));

        jLabel6.setText("Contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, -1));

        jButton1.setText("REGISTRAR");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 170, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void guardar() {
        if ("".equals(correo_electronico.getText()) == false) {
            if (noEsAlphanumerico(nombre.getText()) == false) {
                if (noEsAlphanumerico(apellido_paterno.getText()) == false) {
                    if (noEsAlphanumerico(apellido_materno.getText()) == false) {
                        if ("".equals(contraseña.getText()) == false) {
                            this.usuario.guardarUsuario(nombre.getText(), apellido_paterno.getText(), apellido_materno.getText(), correo_electronico.getText(), contraseña.getText());
                            JOptionPane.showMessageDialog(rootPane, "Se ha guardado el usuario");
                            Ventana_01_IniciarSesion iniciarSesion = new Ventana_01_IniciarSesion();
                            iniciarSesion.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Escriba una contraseña");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Escriba una apellido Materno");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Escriba un apellido Paterno");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Escriba un nombre");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Escriba un correo Electronico");
        }
    }
    public boolean noEsAlphanumerico(String texto){
        boolean bandera = false;
        for (int i = 0; i < texto.length(); i++) {
            if (!caracter.isLetterOrDigit(texto.charAt(i))) {
                bandera = true;
                break;
            }
        }
        if (bandera == true ) {
            return true;
        }
        else
        {
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido_materno;
    private javax.swing.JTextField apellido_paterno;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JTextField correo_electronico;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}

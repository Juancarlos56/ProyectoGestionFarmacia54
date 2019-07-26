/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorEmpleados;
import Controlador.ControladorValidaciones;
import Modelo.Empleado;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class VentanaLogin extends javax.swing.JFrame {

    private ControladorValidaciones validaciones;
    private ControladorEmpleados empleados;
    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() throws IOException {
        validaciones = new ControladorValidaciones();
        empleados = new ControladorEmpleados();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        iniciarSeccion = new javax.swing.JButton();
        inicioAdmi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/farmacia.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 240));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sign up");

        loginID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        loginID.setForeground(new java.awt.Color(51, 51, 51));
        loginID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        loginID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Usuario");

        password.setForeground(new java.awt.Color(51, 51, 51));
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Password ");

        iniciarSeccion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        iniciarSeccion.setForeground(new java.awt.Color(255, 255, 255));
        iniciarSeccion.setText("Sign up");
        iniciarSeccion.setBorder(null);
        iniciarSeccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        iniciarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSeccionActionPerformed(evt);
            }
        });

        inicioAdmi.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        inicioAdmi.setForeground(new java.awt.Color(0, 102, 204));
        inicioAdmi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inicioAdmi.setText("¿Desea ingresar como Administrador? Click aqui.");
        inicioAdmi.setBorder(null);
        inicioAdmi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inicioAdmi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioAdmiMouseClicked(evt);
            }
        });
        inicioAdmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioAdmiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(loginID, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(iniciarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inicioAdmi, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(loginID, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(iniciarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inicioAdmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(772, 624));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSeccionActionPerformed
        String username = loginID.getText().trim();
        String passwords = String.copyValueOf(password.getPassword()).trim();
        Boolean cedulaValida = validaciones.validarDocumento(passwords);
        
        if (cedulaValida) {
            Empleado empleado = empleados.buscarEmpleadoLogin(username, passwords);
            //No es diferente
            if (empleado == null) {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña ingresados no son correctos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                loginID.setText("");
                password.setText("");

            }else{
                VentanaEmpleado ve = new VentanaEmpleado(empleado);
                ve.setVisible(true);
                dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cedula Incorrecta", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_iniciarSeccionActionPerformed

    private void loginIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginIDActionPerformed
        String evento = evt.getActionCommand();
        System.out.println("evento joderrrrr "+evento);
        
    }//GEN-LAST:event_loginIDActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
        String evento = evt.getActionCommand();
        System.out.println("evento joderrrrr "+evento);
    }//GEN-LAST:event_passwordActionPerformed

    private void inicioAdmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioAdmiActionPerformed
        // TODO add your handling code here:
        String evento = evt.getActionCommand();
        System.out.println("evento joderrrrr "+evento);
    }//GEN-LAST:event_inicioAdmiActionPerformed

    private void inicioAdmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioAdmiMouseClicked
        VentanaAdministradorLogin val = new VentanaAdministradorLogin();
        val.setVisible(true);
        dispose();
    }//GEN-LAST:event_inicioAdmiMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciarSeccion;
    private javax.swing.JTextField inicioAdmi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField loginID;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}

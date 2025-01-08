/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Abel Gomez
 */
public class VistaPersonas extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaPersonas
     */
    public VistaPersonas() {
        initComponents();
    }

    public JDialog getDlgPersona() {
        return DlgPersona;
    }

    public void setDlgPersona(JDialog DlgPersona) {
        this.DlgPersona = DlgPersona;
    }

    public JTable getJtbpersonas() {
        return jtbpersonas;
    }

    public void setJtbpersonas(JTable jtbpersonas) {
        this.jtbpersonas = jtbpersonas;
    }

 

    public JTextField getTxtBusqueda() {
        return TxtBusqueda;
    }

    public void setTxtBusqueda(JTextField TxtBusqueda) {
        this.TxtBusqueda = TxtBusqueda;
    }

    public JButton getBtcrear() {
        return btcrear;
    }

    public void setBtcrear(JButton btcrear) {
        this.btcrear = btcrear;
    }

    public JButton getBteditar() {
        return bteditar;
    }

    public void setBteditar(JButton bteditar) {
        this.bteditar = bteditar;
    }

    public JButton getBteliminar() {
        return bteliminar;
    }

    public void setBteliminar(JButton bteliminar) {
        this.bteliminar = bteliminar;
    }

    public JButton getBtmostrardatos() {
        return btmostrardatos;
    }

    public void setBtmostrardatos(JButton btmostrardatos) {
        this.btmostrardatos = btmostrardatos;
    }

    public JButton getBtnaceptar() {
        return btnaceptar;
    }

    public void setBtnaceptar(JButton btnaceptar) {
        this.btnaceptar = btnaceptar;
    }

    public JButton getBtncancelar() {
        return btncancelar;
    }

    public void setBtncancelar(JButton btncancelar) {
        this.btncancelar = btncancelar;
    }

    public JButton getBtnseleccionar_imagen() {
        return btnseleccionar_imagen;
    }

    public void setBtnseleccionar_imagen(JButton btnseleccionar_imagen) {
        this.btnseleccionar_imagen = btnseleccionar_imagen;
    }

    public JDateChooser getDtchsrfechanacimiento() {
        return dtchsrfechanacimiento;
    }

    public void setDtchsrfechanacimiento(JDateChooser dtchsrfechanacimiento) {
        this.dtchsrfechanacimiento = dtchsrfechanacimiento;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLbfoto() {
        return lbfoto;
    }

    public void setLbfoto(JLabel lbfoto) {
        this.lbfoto = lbfoto;
    }

    public JRadioButton getRdbtnfemenino() {
        return rdbtnfemenino;
    }

    public void setRdbtnfemenino(JRadioButton rdbtnfemenino) {
        this.rdbtnfemenino = rdbtnfemenino;
    }

    public JRadioButton getRdbtnmasculino() {
        return rdbtnmasculino;
    }

    public void setRdbtnmasculino(JRadioButton rdbtnmasculino) {
        this.rdbtnmasculino = rdbtnmasculino;
    }

    public JTextField getTxtapellidos() {
        return txtapellidos;
    }

    public void setTxtapellidos(JTextField txtapellidos) {
        this.txtapellidos = txtapellidos;
    }

    public JTextField getTxtcupo() {
        return txtcupo;
    }

    public void setTxtcupo(JTextField txtcupo) {
        this.txtcupo = txtcupo;
    }

    public JTextField getTxtidpersona() {
        return txtidpersona;
    }

    public void setTxtidpersona(JTextField txtidpersona) {
        this.txtidpersona = txtidpersona;
    }

    public JTextField getTxtnombres() {
        return txtnombres;
    }

    public void setTxtnombres(JTextField txtnombres) {
        this.txtnombres = txtnombres;
    }

    public JTextField getTxtsueldo() {
        return txtsueldo;
    }

    public void setTxtsueldo(JTextField txtsueldo) {
        this.txtsueldo = txtsueldo;
    }

    public JTextField getTxttelefono() {
        return txttelefono;
    }

    public void setTxttelefono(JTextField txttelefono) {
        this.txttelefono = txttelefono;
    }

    public JButton getBtImprimir() {
        return btImprimir;
    }

    public void setBtImprimir(JButton btImprimir) {
        this.btImprimir = btImprimir;
    }

   

    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DlgPersona = new javax.swing.JDialog();
        lbfoto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtidpersona = new javax.swing.JTextField();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnseleccionar_imagen = new javax.swing.JButton();
        dtchsrfechanacimiento = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rdbtnmasculino = new javax.swing.JRadioButton();
        rdbtnfemenino = new javax.swing.JRadioButton();
        txtnombres = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        txtcupo = new javax.swing.JTextField();
        btngrupo = new javax.swing.ButtonGroup();
        btcrear = new javax.swing.JButton();
        bteditar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        btmostrardatos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TxtBusqueda = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbpersonas = new javax.swing.JTable();

        DlgPersona.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        DlgPersona.getContentPane().add(lbfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 160, 190));

        jLabel2.setText("IDPersona :");
        DlgPersona.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, -1));

        jLabel3.setText("Nombres :");
        DlgPersona.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel4.setText("Apellidos :");
        DlgPersona.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel5.setText("Fecha Nacimientos :");
        DlgPersona.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));

        jLabel6.setText("Telefono :");
        DlgPersona.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel7.setText("Sexo :");
        DlgPersona.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txtidpersona.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DlgPersona.getContentPane().add(txtidpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 130, -1));

        btnaceptar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok_30px.png"))); // NOI18N
        btnaceptar.setText("Aceptar");
        btnaceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DlgPersona.getContentPane().add(btnaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 170, 40));

        btncancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel_30px.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        DlgPersona.getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 170, -1));

        btnseleccionar_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/image_30px.png"))); // NOI18N
        btnseleccionar_imagen.setText("Seleccionar Imagen");
        DlgPersona.getContentPane().add(btnseleccionar_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 230, -1));

        dtchsrfechanacimiento.setDateFormatString("yyyy/MM/dd");
        DlgPersona.getContentPane().add(dtchsrfechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 180, -1));

        jLabel8.setText("Sueldo :");
        DlgPersona.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel9.setText("Cupo : ");
        DlgPersona.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        btngrupo.add(rdbtnmasculino);
        rdbtnmasculino.setText("Masculino");
        DlgPersona.getContentPane().add(rdbtnmasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        btngrupo.add(rdbtnfemenino);
        rdbtnfemenino.setText("Femenino");
        DlgPersona.getContentPane().add(rdbtnfemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));
        DlgPersona.getContentPane().add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 180, -1));
        DlgPersona.getContentPane().add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, -1));
        DlgPersona.getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 170, -1));
        DlgPersona.getContentPane().add(txtsueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 190, -1));
        DlgPersona.getContentPane().add(txtcupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 110, -1));

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1328, 668));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btcrear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btcrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_user_male_40px.png"))); // NOI18N
        btcrear.setText("Crear");
        getContentPane().add(btcrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));

        bteditar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bteditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update_left_rotation_40px.png"))); // NOI18N
        bteditar.setText("Editar");
        getContentPane().add(bteditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, -1, -1));

        bteliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bteliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_bin_40px.png"))); // NOI18N
        bteliminar.setText("Eliminar");
        getContentPane().add(bteliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        btmostrardatos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btmostrardatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/restart_40px.png"))); // NOI18N
        btmostrardatos.setText("Actualizar Tabla");
        btmostrardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmostrardatosActionPerformed(evt);
            }
        });
        getContentPane().add(btmostrardatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 540, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_40px.png"))); // NOI18N
        jLabel1.setText("Buscar : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 40));

        TxtBusqueda.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(TxtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 300, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel10.setText("Crud Personas");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, 50));

        btImprimir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print_40px.png"))); // NOI18N
        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 90, -1, -1));

        jtbpersonas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtbpersonas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jtbpersonas.setForeground(new java.awt.Color(0, 0, 0));
        jtbpersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDPersona", "Nombres", "Apellidos", "Fecha Nacimiento", "telefono", "sexo", "Sueldo", "Cupo", "Foto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbpersonas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 1190, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btmostrardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmostrardatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btmostrardatosActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DlgPersona;
    private javax.swing.JTextField TxtBusqueda;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btcrear;
    private javax.swing.JButton bteditar;
    private javax.swing.JButton bteliminar;
    private javax.swing.JButton btmostrardatos;
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btncancelar;
    private javax.swing.ButtonGroup btngrupo;
    private javax.swing.JButton btnseleccionar_imagen;
    private com.toedter.calendar.JDateChooser dtchsrfechanacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbpersonas;
    private javax.swing.JLabel lbfoto;
    private javax.swing.JRadioButton rdbtnfemenino;
    private javax.swing.JRadioButton rdbtnmasculino;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcupo;
    private javax.swing.JTextField txtidpersona;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtsueldo;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}

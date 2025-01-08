/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.ModelConexion;
import modelo.ModelPersona;
import modelo.Persona;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vistas.VistaPersonas;
//import model.ModelConexion;
//import model.ModelPersona;
//import model.Persona;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;
//import view.ViewPersona;

/**
 *
 * @author Abel Gomez
 */
public class ControllerPersona {

    private ModelPersona modelo;
    private VistaPersonas vista;
    private JFileChooser jfc;
    int longitudBytes;

    public ControllerPersona(ModelPersona modelo, VistaPersonas vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);

    }

    public void inciacontrol() throws IOException {
        cargardatos();
        vista.getBtmostrardatos().addActionListener(l -> {

            cargardatos();

        });
        // vista.getBtnbuscar().addActionListener(l -> buscarpersonas(vista.getTxtBusqueda().getText()));
        vista.getBtcrear().addActionListener(l -> abrirDialogo(1));
        vista.getBteditar().addActionListener(l -> abrirDialogo(2));
        vista.getBtnaceptar().addActionListener(l -> crearEditarPersona());
        vista.getBtncancelar().addActionListener(l -> botoncalcelar());
        vista.getBteliminar().addActionListener(l -> eliminarPersona());
        vista.getBtnseleccionar_imagen().addActionListener(l -> examinaFoto());
        vista.getBtImprimir().addActionListener(l -> imprimirReporte());
        vista.getTxtBusqueda().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                buscar();
            }

        });

    }/////

    private void examinaFoto() {

        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg, png & jpeg", "jpeg", "png", "jpg");

        jfc = new JFileChooser();
        jfc.setFileFilter(filter);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vista);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLbfoto().getWidth(),
                        vista.getLbfoto().getHeight(),
                        Image.SCALE_DEFAULT);

                Icon icono = new ImageIcon(imagen);
                vista.getLbfoto().setIcon(icono);
                vista.getLbfoto().updateUI();
                // return true;
            } catch (IOException ex) {
                Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
                // return false;
            }

        } else {
            // return false;

        }

    }

    public void imprimirReporte() {

        ModelConexion conn = new ModelConexion();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vistas/reportes/reportedeber.jasper"));
            //    JasperReport jrs = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/reportegraficos.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", "Reporte Condicionales ");
            parametros.put("cupop", 0);

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conn.getConn());

            JasperViewer view = new JasperViewer(jp, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void abrirDialogo(int ope) {
        String titulo;
        if (ope == 1) {
            limpiardatos();
            titulo = "Crear Persona";
            vista.getTxtidpersona().setEnabled(false);
            vista.getDlgPersona().setName("C");
            vista.getDlgPersona().setVisible(true);
            vista.getDlgPersona().setTitle(titulo);
            String idMax =  modelo.generarNuevoIdPersona();
            vista.getTxtidpersona().setText(idMax);


        } else {

            titulo = "Editar Persona";
            vista.getTxtidpersona().setEnabled(false);
            vista.getDlgPersona().setName("E");
            seleccionarfila();
            //vista.getDlgPersona().setVisible(false);
            vista.getDlgPersona().setTitle(titulo);
//                vista.getDlgPersona().setSize(750, 600);
//                vista.getDlgPersona().setLocationRelativeTo(vista);
            // vista.getDlgPersona().setVisible(true);

        }
        //   vista.getDlgPersona().setTitle(titulo);
        vista.getDlgPersona().setSize(750, 600);
        vista.getDlgPersona().setLocationRelativeTo(vista);
    }

    public void seleccionarfila() {

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechatxt = null;
        try {

            int fila = vista.getJtbpersonas().getSelectedRow();

            if (fila >= 0) {

                vista.getTxtidpersona().setText(vista.getJtbpersonas().getValueAt(fila, 0).toString());
                vista.getTxtnombres().setText(vista.getJtbpersonas().getValueAt(fila, 1).toString());
                vista.getTxtapellidos().setText(vista.getJtbpersonas().getValueAt(fila, 2).toString());
                fechatxt = formatofecha.parse(vista.getJtbpersonas().getValueAt(fila, 3).toString());
                vista.getDtchsrfechanacimiento().setDate(fechatxt);
                if (vista.getJtbpersonas().getValueAt(fila, 5).toString().contentEquals("Masculino")) {
                    vista.getRdbtnmasculino().setSelected(true);
                } else {
                    vista.getRdbtnfemenino().setSelected(true);
                }
                vista.getTxttelefono().setText(vista.getJtbpersonas().getValueAt(fila, 4).toString());
                vista.getTxtsueldo().setText(vista.getJtbpersonas().getValueAt(fila, 6).toString());
                vista.getTxtcupo().setText(vista.getJtbpersonas().getValueAt(fila, 7).toString());
                ModelPersona persona = new ModelPersona();
                vista.getLbfoto().setIcon(persona.foto(vista.getJtbpersonas().getValueAt(fila, 0).toString()));
                vista.getDlgPersona().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
                vista.getDlgPersona().setVisible(false);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

//
    private void crearEditarPersona() {

        if (vista.getDlgPersona().getName().contentEquals("C")) {
            //     if (validar() == true) {
            String idpersona = vista.getTxtidpersona().getText();
            String nombre = vista.getTxtnombres().getText();
            String apellidos = vista.getTxtapellidos().getText();
            String telefono = vista.getTxttelefono().getText();
            Double sueldo = Double.parseDouble(vista.getTxtsueldo().getText());
            int cupo = Integer.parseInt(vista.getTxtcupo().getText());
            Date date = vista.getDtchsrfechanacimiento().getDate();
            long d = date.getTime();
            java.sql.Date fecha = new java.sql.Date(d);

            ModelPersona persona = new ModelPersona();
            persona.setIdPersona(idpersona);
            persona.setNombre(nombre);
            persona.setApellido(apellidos);
            persona.setFechanacimiento(fecha);
            persona.setTelefono(telefono);
            if (vista.getRdbtnmasculino().isSelected()) {

                persona.setSexo("Masculino");
            } else {
                if (vista.getRdbtnfemenino().isSelected()) {
                    persona.setSexo("Femenino");
                }
            }

            persona.setSueldo(sueldo);
            persona.setCupo(cupo);

//            try {
//
//                FileInputStream img
//                        = new FileInputStream(jfc.getSelectedFile());
//                int largo = (int) jfc.getSelectedFile().length();
//
////                        persona.setImageFile(null);
//                //   persona.setLength(0);
//                persona.setImageFile(img);
//                persona.setLength(largo);
//
//            } catch (IOException ex) {
//                Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
//            }
//guardar icono adminte png jpg gif
            if (vista.getLbfoto().getIcon() == null) {
                persona.setFoto2(null);

            } else {
                try {

                    byte[] icono = new byte[(int) jfc.getSelectedFile().getAbsoluteFile().length()];

                    InputStream input = new FileInputStream(jfc.getSelectedFile().getAbsoluteFile());
                    input.read(icono);
                    persona.setFoto2(icono);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (persona.setPersonaFoto()) {

                JOptionPane.showMessageDialog(vista, "Persona registrada exitosamente");
                vista.setVisible(true);
                vista.getDlgPersona().setVisible(false);
                limpiardatos();
                cargardatos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error , datos No guardados");
                //   JOptionPane.showConfirmDialog(vista, "Error , datos No guardados");
            }

            //          }//validar
//            else {
//
//                JOptionPane.showMessageDialog(vista, "Error datos , Datos ingresados Incorrectos");
//            }
        } else {
            int respuesta = JOptionPane.showConfirmDialog(vista, "Seguro Desea Actualizar este Registro?");

            if (respuesta == JOptionPane.YES_OPTION) {
                if (vista.getDlgPersona().getName().contentEquals("E")) {

                    //if (validar() == true) {
                    String idpersona = vista.getTxtidpersona().getText();
                    String nombre = vista.getTxtnombres().getText();
                    String apellidos = vista.getTxtapellidos().getText();
                    String telefono = vista.getTxttelefono().getText();
                    Double sueldo = Double.parseDouble(vista.getTxtsueldo().getText());
                    int cupo = Integer.parseInt(vista.getTxtcupo().getText());
                    Date date = vista.getDtchsrfechanacimiento().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);

                    ModelPersona persona = new ModelPersona();
                    persona.setIdPersona(idpersona);
                    persona.setNombre(nombre);
                    persona.setApellido(apellidos);
                    persona.setFechanacimiento(fecha);
                    persona.setTelefono(telefono);
                    if (vista.getRdbtnmasculino().isSelected()) {

                        persona.setSexo("Masculino");
                    } else {
                        if (vista.getRdbtnfemenino().isSelected()) {
                            persona.setSexo("Femenino");
                        }
                    }

                    persona.setSueldo(sueldo);
                    persona.setCupo(cupo);

//                    try {
//                        FileInputStream img
//                                = new FileInputStream(jfc.getSelectedFile());
//                        int largo = (int) jfc.getSelectedFile().length();
//                        persona.setImageFile(img);
//                        persona.setLength(largo);
//
//                    } catch (IOException ex) {
//                        Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                  guardar icono adminte png jpg gif
//                    try {
//
//                        byte[] icono = new byte[(int) jfc.getSelectedFile().getAbsoluteFile().length()];
//
//                        InputStream input = new FileInputStream(jfc.getSelectedFile().getAbsoluteFile());
//                        input.read(icono);
//                        persona.setFoto2(icono);
//
//                    } catch (FileNotFoundException ex) {
//                        Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (IOException ex) {
//                        Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    try {
//                        Icon icons = vista.getLbfoto().getIcon();
//                        BufferedImage bi = new BufferedImage(icons.getIconWidth(), icons.getIconHeight(), BufferedImage.TYPE_INT_RGB);
//                        Graphics g = bi.createGraphics();
//                        icons.paintIcon(null, g, 0, 0);
//                        g.setColor(Color.WHITE);
//                        // g.drawString(passpo.getText(), 10, 20);
//                        g.dispose();
//
//                        ByteArrayOutputStream os = new ByteArrayOutputStream();
//                        ImageIO.write(bi, "jpg", os);
//                        InputStream fis = new ByteArrayInputStream(os.toByteArray());
//                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                        byte[] buf = new byte[1024];
//                        for (int readNum; (readNum = fis.read(buf)) != -1;) {
//                            bos.write(buf, 0, readNum);
//                            System.out.println("read " + readNum + " bytes,");
//                        }
//                        byte[] bytes = bos.toByteArray();
//                        // photo = bytes;
//
//                        persona.setFoto2(bytes);
//                    } catch (IOException ex) {
//                        JOptionPane.showMessageDialog(vista, ex);
//                    }
                    if (vista.getLbfoto().getIcon() == null) {
                        persona.setFoto2(null);

                    } else {
                        try {
                            Icon icons = vista.getLbfoto().getIcon();
                            BufferedImage bi = new BufferedImage(icons.getIconWidth(), icons.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                            Graphics g = bi.createGraphics();
                            icons.paintIcon(null, g, 0, 0);
                            g.setColor(Color.WHITE);
                            // g.drawString(passpo.getText(), 10, 20);
                            g.dispose();

                            ByteArrayOutputStream os = new ByteArrayOutputStream();
                            ImageIO.write(bi, "jpg", os);
                            InputStream fis = new ByteArrayInputStream(os.toByteArray());
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            byte[] buf = new byte[1024];
                            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                                bos.write(buf, 0, readNum);
                                //  System.out.println("read " + readNum + " bytes,");
                            }
                            byte[] bytes = bos.toByteArray();
                            // photo = bytes;

                            persona.setFoto2(bytes);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(vista, ex);
                        }

                    }

                    if (persona.updatepersona()) {

                        JOptionPane.showMessageDialog(vista, "Persona Actualizada");
                        limpiardatos();

                        cargardatos();

                        vista.getDlgPersona().setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(vista, "Error , datos No Actualizados");
                        //   JOptionPane.showConfirmDialog(vista, "Error , datos No guardados");
                    }
//                    } //validar
//                    else {
//                        JOptionPane.showMessageDialog(vista, "Revise los datos, datos No Actualizados");
//
//                    }

                }

            }
        }

    }

    public void botoncalcelar() {

        vista.getDlgPersona().setVisible(false);
        limpiardatos();

    }

    public void buscar() {

        String filtro = vista.getTxtBusqueda().getText() + "%";
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista.getJtbpersonas().getModel();
        estructuratabla.setNumRows(0);
        List<Persona> listap = modelo.buscarPersona(filtro);

        Holder<Integer> i = new Holder<>(0);
        listap.stream().forEach(pe -> {
            estructuratabla.addRow(new Object[9]);

            vista.getJtbpersonas().setValueAt(pe.getIdPersona(), i.value, 0);
            vista.getJtbpersonas().setValueAt(pe.getNombre(), i.value, 1);
            vista.getJtbpersonas().setValueAt(pe.getApellido(), i.value, 2);
            vista.getJtbpersonas().setValueAt(pe.getFechanacimiento(), i.value, 3);
            vista.getJtbpersonas().setValueAt(pe.getTelefono(), i.value, 4);
            vista.getJtbpersonas().setValueAt(pe.getSexo(), i.value, 5);
            vista.getJtbpersonas().setValueAt(pe.getSueldo(), i.value, 6);
            vista.getJtbpersonas().setValueAt(pe.getCupo(), i.value, 7);

            //Llenar imagen
            byte[] bi = pe.getFoto2();

            if (bi != null) {

                try {

                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imi = new ImageIcon(image.getScaledInstance(50, 75, Image.SCALE_SMOOTH));
//                foto = foto.getScaledInstance(50, 75, Image.SCALE_SMOOTH);
//                ImageIcon icono = new ImageIcon(foto);
                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                    dtcr.setIcon(imi);
                    vista.getJtbpersonas().setValueAt(new JLabel(imi), i.value, 8);
                } catch (IOException ex) {

                    //borrar si no hay solucion para la perdida de metadatso
                    Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                vista.getJtbpersonas().setValueAt("Sin Foto", i.value, 8);

            }

            i.value++;

        });

    }

    private void cargardatos() {
        vista.getTxtBusqueda().setText("");
        vista.getJtbpersonas().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getJtbpersonas().setRowHeight(100);
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) vista.getJtbpersonas().getModel();

        estructuraTabla.setNumRows(0);

        List<Persona> listap = modelo.getPersonas();

        Holder<Integer> i = new Holder<>(0);
        listap.stream().forEach(pe -> {
            estructuraTabla.addRow(new Object[9]);

            vista.getJtbpersonas().setValueAt(pe.getIdPersona(), i.value, 0);
            vista.getJtbpersonas().setValueAt(pe.getNombre(), i.value, 1);
            vista.getJtbpersonas().setValueAt(pe.getApellido(), i.value, 2);
            vista.getJtbpersonas().setValueAt(pe.getFechanacimiento(), i.value, 3);
            vista.getJtbpersonas().setValueAt(pe.getTelefono(), i.value, 4);
            vista.getJtbpersonas().setValueAt(pe.getSexo(), i.value, 5);
            vista.getJtbpersonas().setValueAt(pe.getSueldo(), i.value, 6);
            vista.getJtbpersonas().setValueAt(pe.getCupo(), i.value, 7);

            //Llenar imagen
            byte[] bi = pe.getFoto2();

            if (bi != null) {

                try {

                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imi = new ImageIcon(image.getScaledInstance(50, 75, Image.SCALE_SMOOTH));
//                foto = foto.getScaledInstance(50, 75, Image.SCALE_SMOOTH);
//                ImageIcon icono = new ImageIcon(foto);
                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                    dtcr.setIcon(imi);
                    vista.getJtbpersonas().setValueAt(new JLabel(imi), i.value, 8);
                } catch (IOException ex) {

                    //borrar si no hay solucion para la perdida de metadatso
                    Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                vista.getJtbpersonas().setValueAt("Sin Foto", i.value, 8);

            }

            i.value++;

        });

    }

    public void eliminarPersona() {

        String idpersona = "";
        try {
            int fila = vista.getJtbpersonas().getSelectedRow();

            if (fila >= 0) {
                int respuesta = JOptionPane.showConfirmDialog(vista, "Seguro Desea Eliminar este Registro?");
                if (respuesta == JOptionPane.YES_OPTION) {

                    idpersona = vista.getJtbpersonas().getValueAt(fila, 0).toString();

                    ModelPersona persona = new ModelPersona();
                    persona.setIdPersona(idpersona);

                    if (persona.removepersona()) {

                        JOptionPane.showMessageDialog(vista, "Dato Eliminado");
                        limpiardatos();
                        cargardatos();
                        vista.getDlgPersona().setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(vista, "Error , dato no eliminado");

                    }
                } else {

                }
            } else {

                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public void limpiardatos() {
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechatxt = null;

        vista.getTxtidpersona().setText("");
        vista.getTxtnombres().setText("");
        vista.getTxtapellidos().setText("");
        // fechatxt = formatofecha.parse("0000");
        vista.getDtchsrfechanacimiento().setDate(fechatxt);
        vista.getTxttelefono().setText("");
        vista.getTxtsueldo().setText("");
        vista.getTxtcupo().setText("");
        vista.getLbfoto().setIcon(null);

    }

//    public boolean validar() {
//
//        boolean validado = true;
//
//        if (!vista.getTxtsueldo().getText().matches("[0-9.]*")) {
//
//            validado = false;
//        }
//        if (!vista.getTxtcupo().getText().matches("[0-9]*")) {
//
//            validado = false;
//        }
//        if (!vista.getTxttelefono().getText().matches("[0-9]*")) {
//
//            validado = false;
//        }
//        if (!vista.getTxtnombres().getText().matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$")) {
//
//            validado = false;
//        }
//        if (!vista.getTxtapellidos().getText().matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$")) {
//            validado = false;
//        }
//
//        return validado;
//
//    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

//import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Abel Gomez
 */
public class ModelPersona extends Persona {

    ModelConexion mpgc = new ModelConexion();

    public ModelPersona() {
    }

    public ModelPersona(String idPersona, String nombre, String apellido, Date fechanacimiento, String telefono, String sexo, Double sueldo, int cupo, FileInputStream imageFile, int length, byte[] foto2) {
        super(idPersona, nombre, apellido, fechanacimiento, telefono, sexo, sueldo, cupo, imageFile, length, foto2);
    }
    
        // Método para obtener el valor máximo de idPersona
public String generarNuevoIdPersona() {
    String sql = "SELECT MAX(CAST(SUBSTRING(idpersona, 2, LENGTH(idpersona)) AS INTEGER)) AS max_id FROM persona";
    int maxId = 0;

    try (ResultSet rs = mpgc.consulta(sql)) {
        if (rs.next() && rs.getObject("max_id") != null) {
            maxId = rs.getInt("max_id");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ModelPersona.class.getName()).log(Level.SEVERE, "Error obteniendo el máximo ID de persona", ex);
    }

    // Incrementar el ID máximo obtenido
    int nuevoIdNumerico = maxId + 1;

    // Retornar el nuevo ID con formato 'P' seguido de 3 dígitos (e.g., 'P001')
    return "P" + String.format("%03d", nuevoIdNumerico);
}



    public List<Persona> getPersonas() {

        List<Persona> listaPersonas = new ArrayList<Persona>();

        String sql = "select * from persona";
        ResultSet rs = mpgc.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {

                Persona persona = new Persona();
                persona.setIdPersona(rs.getString(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                persona.setFechanacimiento(rs.getDate(4));
                persona.setTelefono(rs.getString(5));
                persona.setSexo(rs.getString(6));
                persona.setSueldo(rs.getDouble(7));
                persona.setCupo(rs.getInt(8));
                //si tiene foto
                bytea = rs.getBytes(9);

                if (bytea != null) {
                    persona.setFoto2(bytea);
                }

                listaPersonas.add(persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPersonas;
    }

    public boolean setPersonaFoto() {
        String sql = "INSERT INTO persona (idpersona,nombres,apellidos,fechanacimiento,telefono,sexo,sueldo,cupo,foto) ";
        sql += "VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = mpgc.conn.prepareStatement(sql);
            ps.setString(1, getIdPersona());
            ps.setString(2, getNombre());
            ps.setString(3, getApellido());
            ps.setDate(4, new java.sql.Date(((Date) getFechanacimiento()).getTime()));
            ps.setString(5, getTelefono());
            ps.setString(6, getSexo());
            ps.setDouble(7, getSueldo());
            ps.setInt(8, getCupo());
            ps.setBytes(9, getFoto2());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ImageIcon foto(String id) {

        ImageIcon newicon = null;
        String sql = "select foto from \"persona\" where idpersona ='" + id + "';";
        ImageIcon foto;
        InputStream is;

        Statement st;
        try {

            ResultSet rs = mpgc.consulta(sql);

            while (rs.next()) {
                is = rs.getBinaryStream(1);

                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);

                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(167, 201, java.awt.Image.SCALE_SMOOTH);

                newicon = new ImageIcon(newimg);

            }
        } catch (Exception ex) {
            // JOptionPane.showMessageDialog(null, "no se puede");
            // ex.printStackTrace();
            newicon = null;

        }

        return newicon;

    }

    public boolean updatepersona() {

        String sql = "UPDATE persona SET idpersona =? , nombres= ?,"
                + " apellidos =?"
                + ", fechanacimiento =?"
                + ", telefono =?"
                + ", sexo =?"
                + ", sueldo=?"
                + ", cupo = ?"
                + ", foto = ?"
                + " WHERE idpersona = '" + getIdPersona() + "';";

        try {
            PreparedStatement ps = mpgc.conn.prepareStatement(sql);
            ps.setString(1, getIdPersona());
            ps.setString(2, getNombre());
            ps.setString(3, getApellido());
            ps.setDate(4, (java.sql.Date) getFechanacimiento());
            ps.setString(5, getTelefono());
            ps.setString(6, getSexo());
            ps.setDouble(7, getSueldo());
            ps.setInt(8, getCupo());
            ps.setBytes(9, getFoto2());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean removepersona() {

        String sql = "DELETE FROM  persona WHERE  idpersona='" + getIdPersona() + "';";

        return mpgc.accion(sql);
    }

    public List<Persona> buscarPersona(String filtro) {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        byte[] bytea;

        //  String sqlID = "select idpersona,nombres,apellidos,fechanacimiento,telefono,sexo,sueldo,cupo  from  persona  where idpersona LIKE '" + filtro + "';";
        String sql = "select idpersona,nombres,apellidos,fechanacimiento,telefono,sexo,sueldo,cupo,foto  "
                + "from  persona  "
                + " where UPPER(idpersona) LIKE UPPER ('" + filtro + "') or "
                + " UPPER(nombres) LIKE UPPER ('" + filtro + "') or"
                + " UPPER(apellidos) LIKE UPPER ('" + filtro + "') or"
                + " UPPER(sexo) LIKE UPPER ('" + filtro + "');";
        ResultSet rs = mpgc.consulta(sql);

        try {
            while (rs.next()) {
                Persona persona = new Persona();

                persona.setIdPersona(rs.getString(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                persona.setFechanacimiento(rs.getDate(4));
                persona.setTelefono(rs.getString(5));
                persona.setSexo(rs.getString(6));
                persona.setSueldo(rs.getDouble(7));
                persona.setCupo(rs.getInt(8));
                //si tiene foto
                bytea = rs.getBytes(9);

                if (bytea != null) {
                    persona.setFoto2(bytea);
                }

                listaPersonas.add(persona);
            }
        } catch (Exception e) {
            Logger.getLogger(ModelConexion.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModelPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPersonas;
    }

    private Image getImage(byte[] bytes) throws IOException {

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader imageReader = (ImageReader) it.next();
        Object source = bais;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        imageReader.setInput(iis, true);
        ImageReadParam param = imageReader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);

        return imageReader.read(0, param);

    }

}


package modelo;

import java.awt.Image;
import java.io.FileInputStream;
import java.util.Date;
import javax.swing.Icon;

/**
 *
 * @author Patricio
 */
public class Persona {
    private String idPersona;
    private String nombre;
    private String apellido;
    private Date fechanacimiento;
    private String telefono;
    private String sexo;
    private Double sueldo;
    private int cupo;
    //private Icon foto;
    //guardar foto
    private FileInputStream imageFile;
    private int length;
    private byte[] foto2;

    public Persona() {
    }

    public Persona(String idPersona, String nombre, String apellido, Date fechanacimiento, String telefono, String sexo, Double sueldo, int cupo, FileInputStream imageFile, int length, byte[] foto2) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.telefono = telefono;
        this.sexo = sexo;
        this.sueldo = sueldo;
        this.cupo = cupo;
        this.imageFile = imageFile;
        this.length = length;
        this.foto2 = foto2;
    }
    
    
    

   
   

    
    
    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }


    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }


    public FileInputStream getImageFile() {
        return imageFile;
    }

    public void setImageFile(FileInputStream imageFile) {
        this.imageFile = imageFile;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getFoto2() {
        return foto2;
    }

    public void setFoto2(byte[] foto2) {
        this.foto2 = foto2;
    }

  
   
}

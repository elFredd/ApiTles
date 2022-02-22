package modelo.DTO;

import modelo.db.Repartidor;
import modelo.db.Tienda;
import modelo.db.Usuario;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * @created 08/12/2021 - 09:26 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class UsuarioDTO {
    private int idUsuario;
    private String tipoUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private int status;
    private String telefono;
    private Timestamp fechaRegistro;
    private Integer validarCorreo;
    private Integer validarTelefono;
    private Integer puntos;

    public UsuarioDTO(Usuario usuario) {
        this.idUsuario=usuario.getIdUsuario();
        this.tipoUsuario=usuario.getTipoUsuario();
        this.nombre=usuario.getNombre();
        this.apellido=usuario.getApellido();
        this.correo=usuario.getCorreo();
        this.password=usuario.getPassword();
        this.status=usuario.getStatus();
        this.telefono=usuario.getTelefono();
        this.fechaRegistro=usuario.getFechaRegistro();
        this.validarCorreo=usuario.getValidarCorreo();
        this.validarTelefono=usuario.getValidarTelefono();
        this.puntos=usuario.getPuntos();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getValidarCorreo() {
        return validarCorreo;
    }

    public void setValidarCorreo(Integer validarCorreo) {
        this.validarCorreo = validarCorreo;
    }

    public Integer getValidarTelefono() {
        return validarTelefono;
    }

    public void setValidarTelefono(Integer validarTelefono) {
        this.validarTelefono = validarTelefono;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}

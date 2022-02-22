package modelo.db;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private int idUsuario;
    private String tipoUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private int status;
    private String telefono;
    private Collection<Repartidor> repartidorsByIdUsuario;
    private Collection<Tienda> tiendasByIdUsuario;
    private Timestamp fechaRegistro;
    private Integer validarCorreo;
    private Integer validarTelefono;
    private Integer puntos;
    private Collection<Direccion> direccionsByIdUsuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "tipo_usuario", nullable = false, length = 50)
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 40)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido", nullable = false, length = 40)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "correo", nullable = false, length = 40)
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "telefono", nullable = false, length = 30)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario && status == usuario.status && Objects.equals(tipoUsuario, usuario.tipoUsuario) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido) && Objects.equals(correo, usuario.correo) && Objects.equals(password, usuario.password) && Objects.equals(telefono, usuario.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, tipoUsuario, nombre, apellido, correo, password, status, telefono);
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<Repartidor> getRepartidorsByIdUsuario() {
        return repartidorsByIdUsuario;
    }

    public void setRepartidorsByIdUsuario(Collection<Repartidor> repartidorsByIdUsuario) {
        this.repartidorsByIdUsuario = repartidorsByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<Tienda> getTiendasByIdUsuario() {
        return tiendasByIdUsuario;
    }

    public void setTiendasByIdUsuario(Collection<Tienda> tiendasByIdUsuario) {
        this.tiendasByIdUsuario = tiendasByIdUsuario;
    }

    @Basic
    @Column(name = "fecha_registro", nullable = true)
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Basic
    @Column(name = "validar_correo", nullable = true)
    public Integer getValidarCorreo() {
        return validarCorreo;
    }

    public void setValidarCorreo(Integer validarCorreo) {
        this.validarCorreo = validarCorreo;
    }

    @Basic
    @Column(name = "validar_telefono", nullable = true)
    public Integer getValidarTelefono() {
        return validarTelefono;
    }

    public void setValidarTelefono(Integer validarTelefono) {
        this.validarTelefono = validarTelefono;
    }

    @Basic
    @Column(name = "puntos", nullable = true)
    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<Direccion> getDireccionsByIdUsuario() {
        return direccionsByIdUsuario;
    }

    public void setDireccionsByIdUsuario(Collection<Direccion> direccionsByIdUsuario) {
        this.direccionsByIdUsuario = direccionsByIdUsuario;
    }
}

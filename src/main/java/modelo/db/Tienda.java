package modelo.db;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tienda")
public class Tienda implements Serializable {
    private int idTienda;
    private String nombre;
    private String imagen;
    private int status;
    private Collection<Producto> productosByIdTienda;
    private Usuario usuarioByIdUsuario;
    private Ciudad ciudadByIdCiudad;
    private String ine;
    private String fotoPerfil;
    private Integer statusIne;
    private Integer statusFoto;
    private Integer statusAcuerdoLegal;
    private Integer activaJornada;
    private String nombreCompleto;
    private Integer statusNombreCompleto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda", nullable = false)
    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "imagen", nullable = false, length = 100)
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tienda tienda = (Tienda) o;
        return idTienda == tienda.idTienda && status == tienda.status && Objects.equals(nombre, tienda.nombre) && Objects.equals(imagen, tienda.imagen );
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTienda, nombre, imagen, status);
    }

    @OneToMany(mappedBy = "tiendaByIdTienda")
    public Collection<Producto> getProductosByIdTienda() {
        return productosByIdTienda;
    }

    public void setProductosByIdTienda(Collection<Producto> productosByIdTienda) {
        this.productosByIdTienda = productosByIdTienda;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad", nullable = false)
    public Ciudad getCiudadByIdCiudad() {
        return ciudadByIdCiudad;
    }

    public void setCiudadByIdCiudad(Ciudad ciudadByIdCiudad) {
        this.ciudadByIdCiudad = ciudadByIdCiudad;
    }

    @Basic
    @Column(name = "ine", nullable = true, length = 100)
    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    @Basic
    @Column(name = "foto_perfil", nullable = true, length = 100)
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Basic
    @Column(name = "status_ine", nullable = true)
    public Integer getStatusIne() {
        return statusIne;
    }

    public void setStatusIne(Integer statusIne) {
        this.statusIne = statusIne;
    }

    @Basic
    @Column(name = "status_foto", nullable = true)
    public Integer getStatusFoto() {
        return statusFoto;
    }

    public void setStatusFoto(Integer statusFoto) {
        this.statusFoto = statusFoto;
    }

    @Basic
    @Column(name = "status_acuerdo_legal", nullable = true)
    public Integer getStatusAcuerdoLegal() {
        return statusAcuerdoLegal;
    }

    public void setStatusAcuerdoLegal(Integer statusAcuerdoLegal) {
        this.statusAcuerdoLegal = statusAcuerdoLegal;
    }

    @Basic
    @Column(name = "activa_jornada", nullable = true)
    public Integer getActivaJornada() {
        return activaJornada;
    }

    public void setActivaJornada(Integer activaJornada) {
        this.activaJornada = activaJornada;
    }

    @Basic
    @Column(name = "nombre_completo", nullable = true, length = 150)
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Basic
    @Column(name = "status_nombre_completo", nullable = true)
    public Integer getStatusNombreCompleto() {
        return statusNombreCompleto;
    }

    public void setStatusNombreCompleto(Integer statusNombreCompleto) {
        this.statusNombreCompleto = statusNombreCompleto;
    }
}

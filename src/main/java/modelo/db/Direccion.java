package modelo.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * @created 13/12/2021 - 09:14 p. m.
 * @project ApiTles
 * @autor alfre
 */
@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {
    private int idDireccion;
    private String calle;
    private String colonia;
    private String numeroExterior;
    private String codigoPostal;
    private String lalitud;
    private String longitud;
    private Ciudad ciudadByIdUsuario;
    private Usuario usuarioByIdUsuario;
    private Collection<Tienda> tiendasByIdDireccion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion", nullable = false)
    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Basic
    @Column(name = "calle", nullable = true, length = 150)
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Basic
    @Column(name = "colonia", nullable = true, length = 150)
    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Basic
    @Column(name = "numero_exterior", nullable = true, length = 10)
    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    @Basic
    @Column(name = "codigo_postal", nullable = true, length = 10)
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Basic
    @Column(name = "lalitud", nullable = true, length = 50)
    public String getLalitud() {
        return lalitud;
    }

    public void setLalitud(String lalitud) {
        this.lalitud = lalitud;
    }

    @Basic
    @Column(name = "longitud", nullable = true, length = 50)
    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion = (Direccion) o;
        return idDireccion == direccion.idDireccion && Objects.equals(calle, direccion.calle) && Objects.equals(colonia, direccion.colonia) && Objects.equals(numeroExterior, direccion.numeroExterior) && Objects.equals(codigoPostal, direccion.codigoPostal) && Objects.equals(lalitud, direccion.lalitud) && Objects.equals(longitud, direccion.longitud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDireccion, calle, colonia, numeroExterior, codigoPostal, lalitud, longitud);
    }

    @ManyToOne
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    public Ciudad getCiudadByIdUsuario() {
        return ciudadByIdUsuario;
    }

    public void setCiudadByIdUsuario(Ciudad ciudadByIdUsuario) {
        this.ciudadByIdUsuario = ciudadByIdUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    @OneToMany(mappedBy = "direccionByIdDireccion")
    public Collection<Tienda> getTiendasByIdDireccion() {
        return tiendasByIdDireccion;
    }

    public void setTiendasByIdDireccion(Collection<Tienda> tiendasByIdDireccion) {
        this.tiendasByIdDireccion = tiendasByIdDireccion;
    }
}

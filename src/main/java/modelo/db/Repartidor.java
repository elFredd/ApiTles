package modelo.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "repartidor")
public class Repartidor implements Serializable {
    private int idRepartidor;
    private String tipoVehiculo;
    private String tarjetaCirculacion;
    private String lisencia;
    private String foto;
    private int status;
    private String ine;
    private int acuerdoLegal;
    private int statusTarjetaCirculacion;
    private int statusLicencia;
    private int statusFoto;
    private int statusIne;
    private Usuario usuarioByIdUsuario;
    private Ciudad ciudadByIdCiudad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repartidor", nullable = false)
    public int getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    @Basic
    @Column(name = "tipo_vehiculo", nullable = false, length = 30)
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Basic
    @Column(name = "tarjeta_circulacion", nullable = false, length = 100)
    public String getTarjetaCirculacion() {
        return tarjetaCirculacion;
    }

    public void setTarjetaCirculacion(String tarjetaCirculacion) {
        this.tarjetaCirculacion = tarjetaCirculacion;
    }

    @Basic
    @Column(name = "lisencia", nullable = false, length = 100)
    public String getLisencia() {
        return lisencia;
    }

    public void setLisencia(String lisencia) {
        this.lisencia = lisencia;
    }

    @Basic
    @Column(name = "foto", nullable = false, length = 100)
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
    @Column(name = "ine", nullable = false, length = 100)
    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    @Basic
    @Column(name = "acuerdo_legal", nullable = false)
    public int getAcuerdoLegal() {
        return acuerdoLegal;
    }

    public void setAcuerdoLegal(int acuerdoLegal) {
        this.acuerdoLegal = acuerdoLegal;
    }

    @Basic
    @Column(name = "status_tarjeta_circulacion", nullable = false)
    public int getStatusTarjetaCirculacion() {
        return statusTarjetaCirculacion;
    }

    public void setStatusTarjetaCirculacion(int statusTarjetaCirculacion) {
        this.statusTarjetaCirculacion = statusTarjetaCirculacion;
    }

    @Basic
    @Column(name = "status_licencia", nullable = false)
    public int getStatusLicencia() {
        return statusLicencia;
    }

    public void setStatusLicencia(int statusLicencia) {
        this.statusLicencia = statusLicencia;
    }

    @Basic
    @Column(name = "status_foto", nullable = false)
    public int getStatusFoto() {
        return statusFoto;
    }

    public void setStatusFoto(int statusFoto) {
        this.statusFoto = statusFoto;
    }

    @Basic
    @Column(name = "status_ine", nullable = false)
    public int getStatusIne() {
        return statusIne;
    }

    public void setStatusIne(int statusIne) {
        this.statusIne = statusIne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repartidor that = (Repartidor) o;
        return idRepartidor == that.idRepartidor && status == that.status && acuerdoLegal == that.acuerdoLegal && statusTarjetaCirculacion == that.statusTarjetaCirculacion && statusLicencia == that.statusLicencia && statusFoto == that.statusFoto && statusIne == that.statusIne && Objects.equals(tipoVehiculo, that.tipoVehiculo) && Objects.equals(tarjetaCirculacion, that.tarjetaCirculacion) && Objects.equals(lisencia, that.lisencia) && Objects.equals(foto, that.foto) && Objects.equals(ine, that.ine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRepartidor, tipoVehiculo, tarjetaCirculacion, lisencia, foto, status, ine, acuerdoLegal, statusTarjetaCirculacion, statusLicencia, statusFoto, statusIne);
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
}

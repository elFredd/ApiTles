package modelo.DTO;

import modelo.db.Ciudad;
import modelo.db.Repartidor;
import modelo.db.Usuario;

/**
 * @created 08/12/2021 - 09:30 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class RepartidorDTO {
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
    private UsuarioDTO usuarioByIdUsuario;
    private CiudadDTO ciudadByIdCiudad;

    public RepartidorDTO(Repartidor repartidor) {
        this.idRepartidor = repartidor.getIdRepartidor();
        this.tipoVehiculo = repartidor.getTipoVehiculo();
        this.tarjetaCirculacion = repartidor.getTarjetaCirculacion();
        this.lisencia = repartidor.getLisencia();
        this.foto = repartidor.getFoto();
        this.status = repartidor.getStatus();
        this.ine = repartidor.getIne();
        this.acuerdoLegal = repartidor.getAcuerdoLegal();
        this.statusTarjetaCirculacion = repartidor.getStatusTarjetaCirculacion();
        this.statusLicencia = repartidor.getStatusLicencia();
        this.statusFoto = repartidor.getStatusFoto();
        this.statusIne = repartidor.getStatusIne();
        this.usuarioByIdUsuario = new UsuarioDTO(repartidor.getUsuarioByIdUsuario());
        this.ciudadByIdCiudad = new CiudadDTO(repartidor.getCiudadByIdCiudad());
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTarjetaCirculacion() {
        return tarjetaCirculacion;
    }

    public void setTarjetaCirculacion(String tarjetaCirculacion) {
        this.tarjetaCirculacion = tarjetaCirculacion;
    }

    public String getLisencia() {
        return lisencia;
    }

    public void setLisencia(String lisencia) {
        this.lisencia = lisencia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public int getAcuerdoLegal() {
        return acuerdoLegal;
    }

    public void setAcuerdoLegal(int acuerdoLegal) {
        this.acuerdoLegal = acuerdoLegal;
    }

    public int getStatusTarjetaCirculacion() {
        return statusTarjetaCirculacion;
    }

    public void setStatusTarjetaCirculacion(int statusTarjetaCirculacion) {
        this.statusTarjetaCirculacion = statusTarjetaCirculacion;
    }

    public int getStatusLicencia() {
        return statusLicencia;
    }

    public void setStatusLicencia(int statusLicencia) {
        this.statusLicencia = statusLicencia;
    }

    public int getStatusFoto() {
        return statusFoto;
    }

    public void setStatusFoto(int statusFoto) {
        this.statusFoto = statusFoto;
    }

    public int getStatusIne() {
        return statusIne;
    }

    public void setStatusIne(int statusIne) {
        this.statusIne = statusIne;
    }

    public UsuarioDTO getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(UsuarioDTO usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    public CiudadDTO getCiudadByIdCiudad() {
        return ciudadByIdCiudad;
    }

    public void setCiudadByIdCiudad(CiudadDTO ciudadByIdCiudad) {
        this.ciudadByIdCiudad = ciudadByIdCiudad;
    }
}

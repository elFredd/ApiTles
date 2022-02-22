package modelo.DTO;

import modelo.db.Ciudad;
import modelo.db.Direccion;
import modelo.db.Usuario;

/**
 * @created 13/12/2021 - 09:15 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class DireccionDTO {
    private int idDireccion;
    private String calle;
    private String colonia;
    private String numeroExterior;
    private String codigoPostal;
    private String lalitud;
    private String longitud;
    private CiudadDTO ciudadByIdUsuario;
    private UsuarioDTO usuarioByIdUsuario;

    public DireccionDTO(Direccion direccion) {
        this.idDireccion = direccion.getIdDireccion();
        this.calle = direccion.getCalle();
        this.colonia = direccion.getColonia();
        this.numeroExterior = direccion.getNumeroExterior();
        this.codigoPostal = direccion.getCodigoPostal();
        this.lalitud = direccion.getLalitud();
        this.longitud = direccion.getLongitud();
        this.ciudadByIdUsuario = new CiudadDTO(direccion.getCiudadByIdUsuario());
        this.usuarioByIdUsuario = new UsuarioDTO(direccion.getUsuarioByIdUsuario());
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLalitud() {
        return lalitud;
    }

    public void setLalitud(String lalitud) {
        this.lalitud = lalitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public CiudadDTO getCiudadByIdUsuario() {
        return ciudadByIdUsuario;
    }

    public void setCiudadByIdUsuario(CiudadDTO ciudadByIdUsuario) {
        this.ciudadByIdUsuario = ciudadByIdUsuario;
    }

    public UsuarioDTO getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(UsuarioDTO usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }
}

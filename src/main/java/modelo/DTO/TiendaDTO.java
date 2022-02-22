package modelo.DTO;

import modelo.db.Ciudad;
import modelo.db.Producto;
import modelo.db.Tienda;
import modelo.db.Usuario;

import java.util.Collection;

/**
 * @created 08/12/2021 - 09:26 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class TiendaDTO {
    private int idTienda;
    private String nombre;
    private String imagen;
    private int status;
    private UsuarioDTO usuarioByIdUsuario;
    private String ine;
    private String fotoPerfil;
    private Integer statusIne;
    private Integer statusFoto;
    private Integer statusAcuerdoLegal;
    private Integer activaJornada;
    private String nombreCompleto;
    private Integer statusNombreCompleto;
    private String tipoTienda;

    public TiendaDTO(Tienda tienda) {
        this.idTienda=tienda.getIdTienda();
        this.nombre=tienda.getNombre();
        this.imagen=tienda.getImagen();
        this.status=tienda.getStatus();
        this.usuarioByIdUsuario=new UsuarioDTO(tienda.getUsuarioByIdUsuario());
        this.ine=tienda.getIne();
        this.fotoPerfil=tienda.getFotoPerfil();
        this.statusIne=tienda.getStatusIne();
        this.statusFoto=tienda.getStatusFoto();
        this.statusAcuerdoLegal=tienda.getStatusAcuerdoLegal();
        this.activaJornada=tienda.getActivaJornada();
        this.nombreCompleto=tienda.getNombreCompleto();
        this.statusNombreCompleto=tienda.getStatusNombreCompleto();
        this.tipoTienda=tienda.getTipoTienda();

    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UsuarioDTO getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(UsuarioDTO usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Integer getStatusIne() {
        return statusIne;
    }

    public void setStatusIne(Integer statusIne) {
        this.statusIne = statusIne;
    }

    public Integer getStatusFoto() {
        return statusFoto;
    }

    public void setStatusFoto(Integer statusFoto) {
        this.statusFoto = statusFoto;
    }

    public Integer getStatusAcuerdoLegal() {
        return statusAcuerdoLegal;
    }

    public void setStatusAcuerdoLegal(Integer statusAcuerdoLegal) {
        this.statusAcuerdoLegal = statusAcuerdoLegal;
    }

    public Integer getActivaJornada() {
        return activaJornada;
    }

    public void setActivaJornada(Integer activaJornada) {
        this.activaJornada = activaJornada;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getStatusNombreCompleto() {
        return statusNombreCompleto;
    }

    public void setStatusNombreCompleto(Integer statusNombreCompleto) {
        this.statusNombreCompleto = statusNombreCompleto;
    }

    public String getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(String tipoTienda) {
        this.tipoTienda = tipoTienda;
    }
}

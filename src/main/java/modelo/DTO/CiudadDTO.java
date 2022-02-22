package modelo.DTO;

import modelo.db.Ciudad;

/**
 * @created 08/12/2021 - 09:24 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class CiudadDTO {
    private int idCiudad;
    private String nombre;
    private int radioKm;
    private EstadoDTO estadoByIdEstado;

    public CiudadDTO(Ciudad ciudad) {
        this.idCiudad=ciudad.getIdCiudad();
        this.nombre=ciudad.getNombre();
        this.radioKm=ciudad.getRadioKm();
        this.estadoByIdEstado=new EstadoDTO(ciudad.getEstadoByIdEstado());
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRadioKm() {
        return radioKm;
    }

    public void setRadioKm(int radioKm) {
        this.radioKm = radioKm;
    }

    public EstadoDTO getEstadoByIdEstado() {
        return estadoByIdEstado;
    }

    public void setEstadoByIdEstado(EstadoDTO estadoByIdEstado) {
        this.estadoByIdEstado = estadoByIdEstado;
    }


}

package modelo.DTO;

import modelo.db.TipoVariante;

/**
 * @created 08/12/2021 - 09:21 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class TipoVarianteDTO {
    private int idTipoVariante;
    private String nombre;
    private Integer status;

    public TipoVarianteDTO(TipoVariante tipoVariante) {
        this.idTipoVariante=tipoVariante.getIdTipoVariante();
        this.nombre=tipoVariante.getNombre();
        this.status=tipoVariante.getStatus();
    }

    public int getIdTipoVariante() {
        return idTipoVariante;
    }

    public void setIdTipoVariante(int idTipoVariante) {
        this.idTipoVariante = idTipoVariante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

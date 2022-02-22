package modelo.DTO;

import modelo.db.Estado;

/**
 * @created 08/12/2021 - 09:23 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class EstadoDTO {
    private int idEstado;
    private String nombre;

    public EstadoDTO(Estado estado) {
        this.idEstado=estado.getIdEstado();
        this.nombre=estado.getNombre();
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

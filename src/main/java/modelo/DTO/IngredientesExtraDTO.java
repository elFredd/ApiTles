package modelo.DTO;

import modelo.db.IngredientesExtra;
import modelo.db.Tienda;

/**
 * @created 08/12/2021 - 09:29 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class IngredientesExtraDTO {
    private int idIngredietes;
    private String nombre;
    private Double precio;
    private Integer status;
    private TiendaDTO tiendaByIdTienda;

    public IngredientesExtraDTO(IngredientesExtra ingredientesExtra){
        this.idIngredietes=ingredientesExtra.getIdIngredietes();
        this.nombre=ingredientesExtra.getNombre();
        this.precio=ingredientesExtra.getPrecio();
        this.status=ingredientesExtra.getStatus();
        this.tiendaByIdTienda=new TiendaDTO(ingredientesExtra.getTiendaByIdTienda());
    }

    public int getIdIngredietes() {
        return idIngredietes;
    }

    public void setIdIngredietes(int idIngredietes) {
        this.idIngredietes = idIngredietes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TiendaDTO getTiendaByIdTienda() {
        return tiendaByIdTienda;
    }

    public void setTiendaByIdTienda(TiendaDTO tiendaByIdTienda) {
        this.tiendaByIdTienda = tiendaByIdTienda;
    }
}

package modelo.DTO;

import modelo.db.IngredientesExtra;
import modelo.db.VarianteProducto;
import modelo.db.VariantesIngrediente;

/**
 * @created 08/12/2021 - 09:31 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class VariantesIngredienteDTO {
    private int idVarianteIngrediente;
    private String nombre;
    private IngredientesExtraDTO ingredientesExtraByIdIngrediente;
    private Integer status;

    public VariantesIngredienteDTO(VariantesIngrediente variantesIngrediente) {
        this.idVarianteIngrediente = variantesIngrediente.getIdVarianteIngrediente();
        this.nombre = variantesIngrediente.getNombre();
        this.ingredientesExtraByIdIngrediente = new IngredientesExtraDTO(variantesIngrediente.getIngredientesExtraByIdIngrediente());
        this.status = variantesIngrediente.getStatus();
    }

    public int getIdVarianteIngrediente() {
        return idVarianteIngrediente;
    }

    public void setIdVarianteIngrediente(int idVarianteIngrediente) {
        this.idVarianteIngrediente = idVarianteIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public IngredientesExtraDTO getIngredientesExtraByIdIngrediente() {
        return ingredientesExtraByIdIngrediente;
    }

    public void setIngredientesExtraByIdIngrediente(IngredientesExtraDTO ingredientesExtraByIdIngrediente) {
        this.ingredientesExtraByIdIngrediente = ingredientesExtraByIdIngrediente;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

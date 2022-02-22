package modelo.DTO;

import modelo.db.IngredientesExtra;
import modelo.db.ProdIngre;
import modelo.db.Producto;

/**
 * @created 08/12/2021 - 09:32 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class ProdIngreDTO {
    private int idProdIngre;
    private Integer status;
    private Integer incluye;
    private ProductoDTO productoByIdProducto;
    private IngredientesExtraDTO ingredientesExtraByIdIngrediente;

    public ProdIngreDTO(ProdIngre prodIngre) {
        this.idProdIngre=prodIngre.getIdProdIngre();
        this.status=prodIngre.getStatus();
        this.incluye=prodIngre.getIncluye();
        this.productoByIdProducto=new ProductoDTO(prodIngre.getProductoByIdProducto());
        this.ingredientesExtraByIdIngrediente=new IngredientesExtraDTO(prodIngre.getIngredientesExtraByIdIngrediente());
    }

    public int getIdProdIngre() {
        return idProdIngre;
    }

    public void setIdProdIngre(int idProdIngre) {
        this.idProdIngre = idProdIngre;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIncluye() {
        return incluye;
    }

    public void setIncluye(Integer incluye) {
        this.incluye = incluye;
    }

    public ProductoDTO getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(ProductoDTO productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }

    public IngredientesExtraDTO getIngredientesExtraByIdIngrediente() {
        return ingredientesExtraByIdIngrediente;
    }

    public void setIngredientesExtraByIdIngrediente(IngredientesExtraDTO ingredientesExtraByIdIngrediente) {
        this.ingredientesExtraByIdIngrediente = ingredientesExtraByIdIngrediente;
    }
}

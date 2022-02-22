package modelo.db;

import javax.persistence.*;
import java.util.Objects;

/**
 * @created 25/11/2021 - 10:05 p. m.
 * @project ApiTles
 * @autor alfre
 */
@Entity
@Table(name = "prod_ingre", schema = "thethree", catalog = "")
public class ProdIngre {
    private int idProdIngre;
    private Integer status;
    private Integer incluye;
    private Producto productoByIdProducto;
    private IngredientesExtra ingredientesExtraByIdIngrediente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prod_ingre", nullable = false)
    public int getIdProdIngre() {
        return idProdIngre;
    }

    public void setIdProdIngre(int idProdIngre) {
        this.idProdIngre = idProdIngre;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "incluye", nullable = true)
    public Integer getIncluye() {
        return incluye;
    }

    public void setIncluye(Integer incluye) {
        this.incluye = incluye;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdIngre prodIngre = (ProdIngre) o;
        return idProdIngre == prodIngre.idProdIngre && Objects.equals(status, prodIngre.status) && Objects.equals(incluye, prodIngre.incluye);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdIngre, status, incluye);
    }

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    public Producto getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(Producto productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }

    @ManyToOne
    @JoinColumn(name = "id_ingrediente", referencedColumnName = "id_ingredietes")
    public IngredientesExtra getIngredientesExtraByIdIngrediente() {
        return ingredientesExtraByIdIngrediente;
    }

    public void setIngredientesExtraByIdIngrediente(IngredientesExtra ingredientesExtraByIdIngrediente) {
        this.ingredientesExtraByIdIngrediente = ingredientesExtraByIdIngrediente;
    }
}

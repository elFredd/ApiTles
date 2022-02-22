package modelo.db;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * @created 25/11/2021 - 10:05 p. m.
 * @project ApiTles
 * @autor alfre
 */
@Entity
@Table(name = "ingredientes_extra", schema = "thethree", catalog = "")
public class IngredientesExtra {
    private int idIngredietes;
    private String nombre;
    private Double precio;
    private Integer status;
    private Tienda tiendaByIdTienda;
    private Collection<ProdIngre> prodIngresByIdIngredietes;
    private Collection<VariantesIngrediente> variantesIngredientesByIdIngredietes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredietes", nullable = false)
    public int getIdIngredietes() {
        return idIngredietes;
    }

    public void setIdIngredietes(int idIngredietes) {
        this.idIngredietes = idIngredietes;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "precio", nullable = true, precision = 2)
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientesExtra that = (IngredientesExtra) o;
        return idIngredietes == that.idIngredietes && Objects.equals(nombre, that.nombre) && Objects.equals(precio, that.precio) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIngredietes, nombre, precio, status);
    }

    @ManyToOne
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    public Tienda getTiendaByIdTienda() {
        return tiendaByIdTienda;
    }

    public void setTiendaByIdTienda(Tienda tiendaByIdTienda) {
        this.tiendaByIdTienda = tiendaByIdTienda;
    }

    @OneToMany(mappedBy = "ingredientesExtraByIdIngrediente")
    public Collection<ProdIngre> getProdIngresByIdIngredietes() {
        return prodIngresByIdIngredietes;
    }

    public void setProdIngresByIdIngredietes(Collection<ProdIngre> prodIngresByIdIngredietes) {
        this.prodIngresByIdIngredietes = prodIngresByIdIngredietes;
    }

    @OneToMany(mappedBy = "ingredientesExtraByIdIngrediente")
    public Collection<VariantesIngrediente> getVariantesIngredientesByIdIngredietes() {
        return variantesIngredientesByIdIngredietes;
    }

    public void setVariantesIngredientesByIdIngredietes(Collection<VariantesIngrediente> variantesIngredientesByIdIngredietes) {
        this.variantesIngredientesByIdIngredietes = variantesIngredientesByIdIngredietes;
    }
}

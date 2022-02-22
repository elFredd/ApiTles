package modelo.db;

import javax.persistence.*;
import java.util.Objects;

/**
 * @created 26/11/2021 - 10:14 p. m.
 * @project ApiTles
 * @autor alfre
 */
@Entity
@Table(name = "variantes_ingrediente", schema = "thethree", catalog = "")
public class VariantesIngrediente {
    private int idVarianteIngrediente;
    private String nombre;
    private IngredientesExtra ingredientesExtraByIdIngrediente;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variante_ingrediente", nullable = false)
    public int getIdVarianteIngrediente() {
        return idVarianteIngrediente;
    }

    public void setIdVarianteIngrediente(int idVarianteIngrediente) {
        this.idVarianteIngrediente = idVarianteIngrediente;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariantesIngrediente that = (VariantesIngrediente) o;
        return idVarianteIngrediente == that.idVarianteIngrediente && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVarianteIngrediente, nombre);
    }

    @ManyToOne
    @JoinColumn(name = "id_ingrediente", referencedColumnName = "id_ingredietes")
    public IngredientesExtra getIngredientesExtraByIdIngrediente() {
        return ingredientesExtraByIdIngrediente;
    }

    public void setIngredientesExtraByIdIngrediente(IngredientesExtra ingredientesExtraByIdIngrediente) {
        this.ingredientesExtraByIdIngrediente = ingredientesExtraByIdIngrediente;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

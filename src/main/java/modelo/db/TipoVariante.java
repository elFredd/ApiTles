package modelo.db;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * @created 05/12/2021 - 11:23 a. m.
 * @project ApiTles
 * @autor alfre
 */
@Entity
@Table(name = "tipo_variante", schema = "thethree", catalog = "")
public class TipoVariante {
    private int idTipoVariante;
    private String nombre;
    private Integer status;
    private Collection<VarianteProducto> varianteProductosByIdTipoVariante;
    private Collection<CategoriaTipoVariane> categoriaTipoVarianesByIdTipoVariante;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_variante", nullable = false)
    public int getIdTipoVariante() {
        return idTipoVariante;
    }

    public void setIdTipoVariante(int idTipoVariante) {
        this.idTipoVariante = idTipoVariante;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        TipoVariante that = (TipoVariante) o;
        return idTipoVariante == that.idTipoVariante && Objects.equals(nombre, that.nombre) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoVariante, nombre, status);
    }

    @OneToMany(mappedBy = "tipoVarianteByIdTipoVariante")
    public Collection<VarianteProducto> getVarianteProductosByIdTipoVariante() {
        return varianteProductosByIdTipoVariante;
    }

    public void setVarianteProductosByIdTipoVariante(Collection<VarianteProducto> varianteProductosByIdTipoVariante) {
        this.varianteProductosByIdTipoVariante = varianteProductosByIdTipoVariante;
    }

    @OneToMany(mappedBy = "tipoVarianteByIdTipoVariante")
    public Collection<CategoriaTipoVariane> getCategoriaTipoVarianesByIdTipoVariante() {
        return categoriaTipoVarianesByIdTipoVariante;
    }

    public void setCategoriaTipoVarianesByIdTipoVariante(Collection<CategoriaTipoVariane> categoriaTipoVarianesByIdTipoVariante) {
        this.categoriaTipoVarianesByIdTipoVariante = categoriaTipoVarianesByIdTipoVariante;
    }
}

package modelo.db;

import javax.persistence.*;
import java.util.Objects;

/**
 * @created 05/12/2021 - 12:00 p. m.
 * @project ApiTles
 * @autor alfre
 */
@Entity
@Table(name = "categoria_tipo_variane", schema = "thethree", catalog = "")
public class CategoriaTipoVariane {
    private int idCategoriaTipo;
    private Integer status;
    private Categoria categoriaByIdCategoria;
    private TipoVariante tipoVarianteByIdTipoVariante;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_tipo", nullable = false)
    public int getIdCategoriaTipo() {
        return idCategoriaTipo;
    }

    public void setIdCategoriaTipo(int idCategoriaTipo) {
        this.idCategoriaTipo = idCategoriaTipo;
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
        CategoriaTipoVariane that = (CategoriaTipoVariane) o;
        return idCategoriaTipo == that.idCategoriaTipo && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoriaTipo, status);
    }

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    public Categoria getCategoriaByIdCategoria() {
        return categoriaByIdCategoria;
    }

    public void setCategoriaByIdCategoria(Categoria categoriaByIdCategoria) {
        this.categoriaByIdCategoria = categoriaByIdCategoria;
    }

    @ManyToOne
    @JoinColumn(name = "id_tipo_variante", referencedColumnName = "id_tipo_variante")
    public TipoVariante getTipoVarianteByIdTipoVariante() {
        return tipoVarianteByIdTipoVariante;
    }

    public void setTipoVarianteByIdTipoVariante(TipoVariante tipoVarianteByIdTipoVariante) {
        this.tipoVarianteByIdTipoVariante = tipoVarianteByIdTipoVariante;
    }
}

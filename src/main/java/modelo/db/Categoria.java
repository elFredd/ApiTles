package modelo.db;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * @created 22/11/2021 - 08:49 p. m.
 * @project ApiTles
 * @autor alfre
 */
@Entity
public class Categoria {
    private int idCategoria;
    private String nombre;
    private String imagen;
    private String tipoTienda;
    private String url;
    private Collection<Producto> productosByIdCategoria;
    private Collection<CategoriaTipoVariane> categoriaTipoVarianesByIdCategoria;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", nullable = false)
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
    @Column(name = "imagen", nullable = true, length = 150)
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Basic
    @Column(name = "tipo_tienda", nullable = true, length = 50)
    public String getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(String tipoTienda) {
        this.tipoTienda = tipoTienda;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 150)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return idCategoria == categoria.idCategoria && Objects.equals(nombre, categoria.nombre) && Objects.equals(imagen, categoria.imagen) && Objects.equals(tipoTienda, categoria.tipoTienda) && Objects.equals(url, categoria.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, nombre, imagen, tipoTienda, url);
    }

    @OneToMany(mappedBy = "categoriaByIdCategoria")
    public Collection<Producto> getProductosByIdCategoria() {
        return productosByIdCategoria;
    }

    public void setProductosByIdCategoria(Collection<Producto> productosByIdCategoria) {
        this.productosByIdCategoria = productosByIdCategoria;
    }

    @OneToMany(mappedBy = "categoriaByIdCategoria")
    public Collection<CategoriaTipoVariane> getCategoriaTipoVarianesByIdCategoria() {
        return categoriaTipoVarianesByIdCategoria;
    }

    public void setCategoriaTipoVarianesByIdCategoria(Collection<CategoriaTipoVariane> categoriaTipoVarianesByIdCategoria) {
        this.categoriaTipoVarianesByIdCategoria = categoriaTipoVarianesByIdCategoria;
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

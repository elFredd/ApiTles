package modelo.DTO;

import modelo.db.Categoria;
import modelo.db.CategoriaTipoVariane;
import modelo.db.Producto;

import java.util.Collection;

/**
 * @created 08/12/2021 - 09:20 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class CategoriaDTO {
    private int idCategoria;
    private String nombre;
    private String imagen;
    private String tipoTienda;
    private String url;
    private Integer status;

    public CategoriaDTO(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.nombre = categoria.getNombre();
        this.imagen = categoria.getImagen();
        this.tipoTienda = categoria.getTipoTienda();
        this.url = categoria.getUrl();
        this.status = categoria.getStatus();
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(String tipoTienda) {
        this.tipoTienda = tipoTienda;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

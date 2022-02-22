package modelo.DTO;

import modelo.db.Categoria;
import modelo.db.Producto;
import modelo.db.Tienda;

/**
 * @created 08/12/2021 - 09:28 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class ProductoDTO {
    private int idProducto;
    private String nombre;
    private double precio;
    private int duracion;
    private int cantidad;
    private int status;
    private String imagen;
    private TiendaDTO tiendaByIdTienda;
    private String descripcion;
    private CategoriaDTO categoriaByIdCategoria;

    public ProductoDTO(Producto producto) {
        this.idProducto=producto.getIdProducto();
        this.nombre=producto.getNombre();
        this.precio=producto.getPrecio();
        this.duracion=producto.getDuracion();
        this.cantidad=producto.getCantidad();
        this.status=producto.getStatus();
        this.imagen=producto.getImagen();
        this.tiendaByIdTienda=new TiendaDTO(producto.getTiendaByIdTienda());
        this.descripcion=producto.getDescripcion();
        this.categoriaByIdCategoria=new CategoriaDTO(producto.getCategoriaByIdCategoria());
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public TiendaDTO getTiendaByIdTienda() {
        return tiendaByIdTienda;
    }

    public void setTiendaByIdTienda(TiendaDTO tiendaByIdTienda) {
        this.tiendaByIdTienda = tiendaByIdTienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaDTO getCategoriaByIdCategoria() {
        return categoriaByIdCategoria;
    }

    public void setCategoriaByIdCategoria(CategoriaDTO categoriaByIdCategoria) {
        this.categoriaByIdCategoria = categoriaByIdCategoria;
    }
}

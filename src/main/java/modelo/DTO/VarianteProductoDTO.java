package modelo.DTO;

import modelo.db.Producto;
import modelo.db.TipoVariante;
import modelo.db.VarianteProducto;

/**
 * @created 08/12/2021 - 09:31 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class VarianteProductoDTO {
    private int idVariante;
    private String valor;
    private Integer status;
    private Double precio;
    private Integer cantidad;
    private String imagen;
    private ProductoDTO productoByIdProducto;
    private TipoVarianteDTO tipoVarianteByIdTipoVariante;

    public VarianteProductoDTO(VarianteProducto varianteProducto) {
        this.idVariante = varianteProducto.getIdVariante();
        this.valor = varianteProducto.getValor();
        this.status = varianteProducto.getStatus();
        this.precio = varianteProducto.getPrecio();
        this.cantidad = varianteProducto.getCantidad();
        this.imagen = varianteProducto.getImagen();
        this.productoByIdProducto = new ProductoDTO(varianteProducto.getProductoByIdProducto());
        this.tipoVarianteByIdTipoVariante = new TipoVarianteDTO(varianteProducto.getTipoVarianteByIdTipoVariante());
    }

    public int getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(int idVariante) {
        this.idVariante = idVariante;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ProductoDTO getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(ProductoDTO productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }

    public TipoVarianteDTO getTipoVarianteByIdTipoVariante() {
        return tipoVarianteByIdTipoVariante;
    }

    public void setTipoVarianteByIdTipoVariante(TipoVarianteDTO tipoVarianteByIdTipoVariante) {
        this.tipoVarianteByIdTipoVariante = tipoVarianteByIdTipoVariante;
    }
}

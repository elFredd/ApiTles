package modelo.db;

import javax.persistence.*;
import java.util.Objects;

/**
 * @created 05/12/2021 - 11:23 a. m.
 * @project ApiTles
 * @autor alfre
 */
@Entity
@Table(name = "variante_producto", schema = "thethree", catalog = "")
public class VarianteProducto {
    private int idVariante;
    private String valor;
    private Integer status;
    private Double precio;
    private Integer cantidad;
    private String imagen;
    private Producto productoByIdProducto;
    private TipoVariante tipoVarianteByIdTipoVariante;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variante", nullable = false)
    public int getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(int idVariante) {
        this.idVariante = idVariante;
    }

    @Basic
    @Column(name = "valor", nullable = true, length = 100)
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
    @Column(name = "precio", nullable = true, precision = 2)
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "cantidad", nullable = true)
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "imagen", nullable = true, length = 300)
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VarianteProducto that = (VarianteProducto) o;
        return idVariante == that.idVariante && Objects.equals(valor, that.valor) && Objects.equals(status, that.status) && Objects.equals(precio, that.precio) && Objects.equals(cantidad, that.cantidad) && Objects.equals(imagen, that.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVariante, valor, status, precio, cantidad, imagen);
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
    @JoinColumn(name = "id_tipo_variante", referencedColumnName = "id_tipo_variante")
    public TipoVariante getTipoVarianteByIdTipoVariante() {
        return tipoVarianteByIdTipoVariante;
    }

    public void setTipoVarianteByIdTipoVariante(TipoVariante tipoVarianteByIdTipoVariante) {
        this.tipoVarianteByIdTipoVariante = tipoVarianteByIdTipoVariante;
    }
}

package modelo.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    private int idProducto;
    private String nombre;
    private double precio;
    private int duracion;
    private int cantidad;
    private int status;
    private String imagen;
    private String tipoProducto;
    private Tienda tiendaByIdTienda;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 40)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "precio", nullable = false, precision = 0)
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "duracion", nullable = false)
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Basic
    @Column(name = "cantidad", nullable = false)
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "imagen", nullable = false, length = 100)
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Basic
    @Column(name = "tipo_producto", nullable = false, length = 50)
    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return idProducto == producto.idProducto && Double.compare(producto.precio, precio) == 0 && duracion == producto.duracion && cantidad == producto.cantidad && status == producto.status && Objects.equals(nombre, producto.nombre) && Objects.equals(imagen, producto.imagen) && Objects.equals(tipoProducto, producto.tipoProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nombre, precio, duracion, cantidad, status, imagen, tipoProducto);
    }

    @ManyToOne
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda", nullable = false)
    public Tienda getTiendaByIdTienda() {
        return tiendaByIdTienda;
    }

    public void setTiendaByIdTienda(Tienda tiendaByIdTienda) {
        this.tiendaByIdTienda = tiendaByIdTienda;
    }
}

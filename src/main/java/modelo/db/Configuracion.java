package modelo.db;

import javax.persistence.*;
import java.util.Objects;

/**
 * @created 18/11/2021 - 10:09 p. m.
 * @project ApiTles
 * @autor alfre
 */
@Entity
public class Configuracion {
    private int idConfiguracion;
    private Integer comisionVentaStore;
    private Integer comisionRepartirDriver;
    private Integer status;
    private Double precioMinimoTienda;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_configuracion", nullable = false)
    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    @Basic
    @Column(name = "comision_venta_store", nullable = true)
    public Integer getComisionVentaStore() {
        return comisionVentaStore;
    }

    public void setComisionVentaStore(Integer comisionVentaStore) {
        this.comisionVentaStore = comisionVentaStore;
    }

    @Basic
    @Column(name = "comision_repartir_driver", nullable = true)
    public Integer getComisionRepartirDriver() {
        return comisionRepartirDriver;
    }

    public void setComisionRepartirDriver(Integer comisionRepartirDriver) {
        this.comisionRepartirDriver = comisionRepartirDriver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuracion that = (Configuracion) o;
        return idConfiguracion == that.idConfiguracion && Objects.equals(comisionVentaStore, that.comisionVentaStore) && Objects.equals(comisionRepartirDriver, that.comisionRepartirDriver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConfiguracion, comisionVentaStore, comisionRepartirDriver);
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
    @Column(name = "precio_minimo_tienda", nullable = true, precision = 2)
    public Double getPrecioMinimoTienda() {
        return precioMinimoTienda;
    }

    public void setPrecioMinimoTienda(Double precioMinimoTienda) {
        this.precioMinimoTienda = precioMinimoTienda;
    }
}

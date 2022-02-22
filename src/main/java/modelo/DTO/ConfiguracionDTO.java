package modelo.DTO;

import modelo.db.Configuracion;

/**
 * @created 08/12/2021 - 09:25 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class ConfiguracionDTO {
    private int idConfiguracion;
    private Integer comisionVentaStore;
    private Integer comisionRepartirDriver;
    private Integer status;
    private Double precioMinimoTienda;

    public ConfiguracionDTO(Configuracion configuracion){
        this.idConfiguracion=configuracion.getIdConfiguracion();
        this.comisionVentaStore=configuracion.getComisionVentaStore();
        this.comisionRepartirDriver=configuracion.getComisionRepartirDriver();
        this.status=configuracion.getStatus();
        this.precioMinimoTienda=configuracion.getPrecioMinimoTienda();
    }

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public Integer getComisionVentaStore() {
        return comisionVentaStore;
    }

    public void setComisionVentaStore(Integer comisionVentaStore) {
        this.comisionVentaStore = comisionVentaStore;
    }

    public Integer getComisionRepartirDriver() {
        return comisionRepartirDriver;
    }

    public void setComisionRepartirDriver(Integer comisionRepartirDriver) {
        this.comisionRepartirDriver = comisionRepartirDriver;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrecioMinimoTienda() {
        return precioMinimoTienda;
    }

    public void setPrecioMinimoTienda(Double precioMinimoTienda) {
        this.precioMinimoTienda = precioMinimoTienda;
    }
}

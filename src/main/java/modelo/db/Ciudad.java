package modelo.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ciudad")
public class Ciudad implements Serializable {
    private int idCiudad;
    private String nombre;
    private int radioKm;
    private Estado estadoByIdEstado;
    private Collection<Repartidor> repartidorsByIdCiudad;
    private Collection<Direccion> direccionsByIdCiudad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad", nullable = false)
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "radio_km", nullable = false)
    public int getRadioKm() {
        return radioKm;
    }

    public void setRadioKm(int radioKm) {
        this.radioKm = radioKm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return idCiudad == ciudad.idCiudad && radioKm == ciudad.radioKm && Objects.equals(nombre, ciudad.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCiudad, nombre, radioKm);
    }

    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    public Estado getEstadoByIdEstado() {
        return estadoByIdEstado;
    }

    public void setEstadoByIdEstado(Estado estadoByIdEstado) {
        this.estadoByIdEstado = estadoByIdEstado;
    }

    @OneToMany(mappedBy = "ciudadByIdCiudad")
    public Collection<Repartidor> getRepartidorsByIdCiudad() {
        return repartidorsByIdCiudad;
    }

    public void setRepartidorsByIdCiudad(Collection<Repartidor> repartidorsByIdCiudad) {
        this.repartidorsByIdCiudad = repartidorsByIdCiudad;
    }

    @OneToMany(mappedBy = "ciudadByIdUsuario")
    public Collection<Direccion> getDireccionsByIdCiudad() {
        return direccionsByIdCiudad;
    }

    public void setDireccionsByIdCiudad(Collection<Direccion> direccionsByIdCiudad) {
        this.direccionsByIdCiudad = direccionsByIdCiudad;
    }
}

package modelo.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {
    private int idEstado;
    private String nombre;
    private Collection<Ciudad> ciudadsByIdEstado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado", nullable = false)
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return idEstado == estado.idEstado && Objects.equals(nombre, estado.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado, nombre);
    }

    @OneToMany(mappedBy = "estadoByIdEstado")
    public Collection<Ciudad> getCiudadsByIdEstado() {
        return ciudadsByIdEstado;
    }

    public void setCiudadsByIdEstado(Collection<Ciudad> ciudadsByIdEstado) {
        this.ciudadsByIdEstado = ciudadsByIdEstado;
    }
}

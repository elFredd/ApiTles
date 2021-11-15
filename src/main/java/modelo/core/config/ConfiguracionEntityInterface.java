package modelo.core.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface ConfiguracionEntityInterface {
    EntityManagerFactory ENTITY_FACTORY= Persistence.createEntityManagerFactory("Persistencia_THETHREE_TLES");

}

package modelo.dao;

import modelo.core.config.ConfiguracionEntityInterface;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class DAO implements ConfiguracionEntityInterface {
    private EntityManager em;
    public DAO(){
        em = ENTITY_FACTORY.createEntityManager();
    }

    public void insertar(Object objeto){
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
    }

    public Object ConsultaHQLRetonaValorUnico(String cadenaConsulta) {
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            List results = em.createQuery(cadenaConsulta).getResultList();
            if ((!results.isEmpty()))
                return results.get(0);
            else return null;
        } catch (Exception e) {
            return  null;
        }
    }

    public List listar(String tablaListar){
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            return em.createQuery("SELECT tabla FROM " + tablaListar +" tabla" ).getResultList();
        } catch (Exception e) {
            return  null;
        }

    }

    public Object buscar(Integer IDBuscar,Class clase){
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            return em.find(clase,IDBuscar);
        } catch (Exception e) {
            return  null;
        }
    }

    public int maxId(String tablabuscar){
        EntityManager em =ENTITY_FACTORY.createEntityManager();
        return em.createQuery("SELECT MAX(0) FROM " + tablabuscar).getFirstResult();
    }

    public void actualizar(Object objectoEditar){
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(objectoEditar);
            em.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
    }

    public void eliminar(Object objectoEliminar)
    {
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(objectoEliminar));
            em.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
    }

    public List consultaHQLRetonarLista(String cadenaConsulta) {
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            return em.createQuery(cadenaConsulta).getResultList();
        } catch (Exception e) {
            return  null;
        }
    }

    public List consultaHQLRetonarListaCantidadEspecifica(String cadenaConsulta,int cantidad) {
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            return em.createQuery(cadenaConsulta).setMaxResults(cantidad).getResultList();
        } catch (Exception e) {
            return  null;
        }
    }

    public List<Object> consultaHQLRetonarListaParametros(String cadenaConsulta, String[] parametros)
    {
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            Query query=em.createQuery(cadenaConsulta);
            for (int i = 0; i < parametros.length; i++)
                query.setParameter(i+1, parametros[i]);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object consultaHQLRetonaValorUnicoParametros(String cadenaConsulta,Object[] parametros) {
        if(!ENTITY_FACTORY.createEntityManager().isOpen())
            em = ENTITY_FACTORY.createEntityManager();
        try {
            Query query = em.createQuery(cadenaConsulta);
            for (int i = 0; i < parametros.length; i++)
                query.setParameter(i + 1, parametros[i]);
            List results = query.getResultList();
            if ((!results.isEmpty()))
                return results.get(0);
            else return null;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void CerrarConexion(){
        if(ENTITY_FACTORY.createEntityManager().isOpen())
            em.close();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidad.Rol;
import entidad.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ALEJANDRO
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserJPAPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public UsuarioJpaController() {
    }

    public void create(Usuario usuario) {
        if (usuario.getRolCollection() == null) {
            usuario.setRolCollection(new ArrayList<Rol>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Rol> attachedRolCollection = new ArrayList<Rol>();
            for (Rol rolCollectionRolToAttach : usuario.getRolCollection()) {
                rolCollectionRolToAttach = em.getReference(rolCollectionRolToAttach.getClass(), rolCollectionRolToAttach.getKIdRol());
                attachedRolCollection.add(rolCollectionRolToAttach);
            }
            usuario.setRolCollection(attachedRolCollection);
            em.persist(usuario);
            for (Rol rolCollectionRol : usuario.getRolCollection()) {
                rolCollectionRol.getUsuarioCollection().add(usuario);
                rolCollectionRol = em.merge(rolCollectionRol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getKIdUsuario());
            Collection<Rol> rolCollectionOld = persistentUsuario.getRolCollection();
            Collection<Rol> rolCollectionNew = usuario.getRolCollection();
            Collection<Rol> attachedRolCollectionNew = new ArrayList<Rol>();
            for (Rol rolCollectionNewRolToAttach : rolCollectionNew) {
                rolCollectionNewRolToAttach = em.getReference(rolCollectionNewRolToAttach.getClass(), rolCollectionNewRolToAttach.getKIdRol());
                attachedRolCollectionNew.add(rolCollectionNewRolToAttach);
            }
            rolCollectionNew = attachedRolCollectionNew;
            usuario.setRolCollection(rolCollectionNew);
            usuario = em.merge(usuario);
            for (Rol rolCollectionOldRol : rolCollectionOld) {
                if (!rolCollectionNew.contains(rolCollectionOldRol)) {
                    rolCollectionOldRol.getUsuarioCollection().remove(usuario);
                    rolCollectionOldRol = em.merge(rolCollectionOldRol);
                }
            }
            for (Rol rolCollectionNewRol : rolCollectionNew) {
                if (!rolCollectionOld.contains(rolCollectionNewRol)) {
                    rolCollectionNewRol.getUsuarioCollection().add(usuario);
                    rolCollectionNewRol = em.merge(rolCollectionNewRol);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getKIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getKIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Collection<Rol> rolCollection = usuario.getRolCollection();
            for (Rol rolCollectionRol : rolCollection) {
                rolCollectionRol.getUsuarioCollection().remove(usuario);
                rolCollectionRol = em.merge(rolCollectionRol);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

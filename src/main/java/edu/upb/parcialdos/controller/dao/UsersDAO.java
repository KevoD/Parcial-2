/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.parcialdos.controller.dao;

import edu.upb.parcialdos.model.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */
@Stateless
public class UsersDAO {

    @PersistenceContext(unitName = "parcial_dos_PU")
    private EntityManager em;
    private Class<Users> entityClass;

    public UsersDAO() {
    }

    public UsersDAO(Class<Users> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public Users loginAuth(Users user) {

        Query query = getEntityManager().createNamedQuery("Usuarios.findLoginAuth", Users.class);
        query.setParameter("correo", user.getUsername());
        query.setParameter("clave", user.getUserpassword());

        try {
            return (Users) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public void create(Users entity) {
        getEntityManager().persist(entity);
    }

    public void edit(Users entity) {
        getEntityManager().merge(entity);
    }

    public void remove(Users entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public Users find(Users username) {
        return getEntityManager().find(entityClass, username);
    }

    public List<Users> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

}

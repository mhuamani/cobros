/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import onpe.gob.pe.entidades.Usuario;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MHuamani
 */
@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Usuario accederSistema(String usuario, String clave) {
        String sql = "select u from Usuario u where u.usuario = :usuario and u.clave = :clave";
        TypedQuery<Usuario> hql = entityManager.createQuery(sql,Usuario.class);
        return hql.setParameter("usuario", usuario).setParameter("clave", clave).getSingleResult();        
    }
    
}

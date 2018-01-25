/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.dao;

import onpe.gob.pe.entidades.Usuario;

/**
 *
 * @author MHuamani
 */
public interface UsuarioDAO {
    Usuario accederSistema(String usuario,String clave);
}

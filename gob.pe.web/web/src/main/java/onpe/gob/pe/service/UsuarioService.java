/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.service;

import onpe.gob.pe.dao.UsuarioDAO;
import onpe.gob.pe.entidades.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import onpe.gob.pe.iservice.IUsuarioService;
import static onpe.gob.pe.transversal.Constantes.MSG_LOG_INFO_LLAMAR_METODO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MHuamani
 */
@Service("usuarioService")
public class UsuarioService implements IUsuarioService{
    final static Logger logger = LoggerFactory.getLogger(UsuarioService.class);
   
    @Autowired
    UsuarioDAO usuarioDAO;
        
    @Override
    public Usuario accederSistema(String usuario, String clave) {
        logger.info(String.format(MSG_LOG_INFO_LLAMAR_METODO, UsuarioService.class.getName(),"accederSistema"));   
        return usuarioDAO.accederSistema(usuario, clave);
    }
    
}

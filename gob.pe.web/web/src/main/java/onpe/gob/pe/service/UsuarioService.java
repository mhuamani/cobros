/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.service;

import java.util.logging.Level;
import onpe.gob.pe.dao.UsuarioDAO;
import onpe.gob.pe.entidades.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import onpe.gob.pe.iservice.IUsuarioService;
import static onpe.gob.pe.transversal.Constantes.MSG_LOG_INFO_LLAMAR_METODO;
import onpe.gob.pe.transversal.CustomException;
import static onpe.gob.pe.transversal.ReglasNegocio.RN0001_CAMPO_CLAVE_VACIO_LOGIN;
import static onpe.gob.pe.transversal.ReglasNegocio.RN0001_CAMPO_USUARIO_CLAVE_VACIO_LOGIN;
import static onpe.gob.pe.transversal.ReglasNegocio.RN0001_CAMPO_USUARIO_VACIO_LOGIN;
import static onpe.gob.pe.transversal.ReglasNegocio.RN0001_USUARIO_NO_LOGIN;
import static onpe.gob.pe.transversal.ReglasNegocio.RN0001_USUARIO_NULL_LOGIN;
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
    public Usuario accederSistema(Usuario usuario) {
        logger.info(String.format(MSG_LOG_INFO_LLAMAR_METODO, UsuarioService.class.getName(),"accederSistema"));   
        Usuario usu = null;
        
        if (usuario==null) {
            throw new CustomException(RN0001_USUARIO_NULL_LOGIN);    
        }
        if ((usuario.getUsuario()==null || usuario.getUsuario().isEmpty())&&(usuario.getClave()== null|| usuario.getClave().isEmpty())) {
            throw new CustomException(RN0001_CAMPO_USUARIO_CLAVE_VACIO_LOGIN);    
        }
        if (usuario.getUsuario()==null || usuario.getUsuario().isEmpty()) {
            throw new CustomException(RN0001_CAMPO_USUARIO_VACIO_LOGIN);    
        }
        if (usuario.getClave()== null|| usuario.getClave().isEmpty()) {
            throw new CustomException(RN0001_CAMPO_CLAVE_VACIO_LOGIN);    
        }
        usu = usuarioDAO.accederSistema(usuario.getUsuario(), usuario.getClave());
        if (usu==null) {                
            throw new CustomException(RN0001_USUARIO_NO_LOGIN);    
        }                               
        return usu;
    }
    
}

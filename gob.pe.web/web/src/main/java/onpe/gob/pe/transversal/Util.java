/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.transversal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import onpe.gob.pe.entidades.Usuario;

/**
 *
 * @author MHuamani
 */
public class Util {
    public static void crearSessionUsuario(Usuario usuario,HttpServletRequest request){
        HttpSession session = request.getSession(true);
        String str = "";
        try {
            session.setAttribute("UsuarioSession", usuario);
            session.setAttribute("id", 1);
        } catch (Exception e) {
            str = e.getMessage();
        }
        //Obtain the session object, create a new session if doesn't exist
        
        //set a string session attribute
        
    }

    
}

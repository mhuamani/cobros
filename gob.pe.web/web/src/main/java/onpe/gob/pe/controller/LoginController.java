/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.controller;


import com.google.gson.Gson;
import java.util.HashMap;
import onpe.gob.pe.entidades.Usuario;

import static onpe.gob.pe.transversal.Constantes.MSG_LOG_INFO_CARGA;
import static onpe.gob.pe.transversal.Constantes.MSG_LOG_INFO_EJECUCION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import onpe.gob.pe.iservice.IUsuarioService;


/**
 *
 * @author MHuamani
 */

@Controller
@RequestMapping("/")
public class LoginController {
    final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired       
    private IUsuarioService usuarioService;
    
    @GetMapping("login")
    public String index(Model model){                     
        logger.info(String.format(MSG_LOG_INFO_CARGA, "Login"));
        model.addAttribute("name", "Hola Mundo cruel");
        
        return "login";
    }
    
    @PostMapping("ingresarSistema")
    @ResponseBody     
    public String accederSistema(@RequestBody Usuario usuario){        
        logger.info(String.format(MSG_LOG_INFO_EJECUCION, "accederSistema"));  
        boolean success = true;
        String mensaje = "correcto";
        HashMap map = new HashMap();
        
        try {
            usuario = usuarioService.accederSistema(usuario.getUsuario(),usuario.getClave());            
        } catch (Exception e) {
            mensaje = e.getMessage();
            success = false;
        }
                
        map.put("usuario", usuario);
        map.put("success", success);
        map.put("message", mensaje);
        return new Gson().toJson(map);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.controller;


import com.google.gson.Gson;
import java.util.HashMap;
import static onpe.gob.pe.controller.PrincipalController.logger;

import onpe.gob.pe.model.UsuarioModel;
import static onpe.gob.pe.transversal.Constantes.MSG_LOG_INFO_CARGA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MHuamani
 */

@Controller
@RequestMapping("/")
public class LoginController {
    final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("")
    public String index(Model model){                     
        logger.info(String.format(MSG_LOG_INFO_CARGA, "Login"));
        model.addAttribute("name", "Hola Mundo cruel");
        
        return "login";
    }
    @PostMapping("ingresarSistema")
    @ResponseBody 
    public String accederSistema(@RequestBody UsuarioModel usuario){
         logger.info("Acceso al sistema");
         logger.warn("Cuidado");
        boolean success = true;
        String mensaje = "correcto";
        HashMap map = new HashMap();        
        map.put("usuario", usuario);
        map.put("success", success);
        map.put("message", mensaje);
        return new Gson().toJson(map);
    }
}

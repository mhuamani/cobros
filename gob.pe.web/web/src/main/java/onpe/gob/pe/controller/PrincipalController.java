/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.controller;


import static onpe.gob.pe.transversal.Constantes.MSG_LOG_INFO_CARGA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MHuamani
 */
@Controller
@RequestMapping("/principal")
public class PrincipalController {
    final static Logger logger = LoggerFactory.getLogger(PrincipalController.class);
    @GetMapping("/")
    public String index(){        
        logger.info(String.format(MSG_LOG_INFO_CARGA, "Principal"));
        return "principal";
    }
}

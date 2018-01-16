/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MHuamani
 */

@Controller
@RequestMapping("/")
public class loginController {
    @GetMapping("login")
    public String login(Model model){        
        model.addAttribute("name", "Hola Mundo cruel");
        return "login";
    }
}

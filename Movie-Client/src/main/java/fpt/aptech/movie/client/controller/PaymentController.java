/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package fpt.aptech.movie.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NTT
 */
@Controller
public class PaymentController {
    
    @RequestMapping("/payment/{id}")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "payment";
    }
    
}

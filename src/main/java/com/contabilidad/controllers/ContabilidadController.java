/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.controllers;

import com.contabilidad.dao.AsientoDAO;
import com.contabilidad.models.Asientos;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class ContabilidadController {

    private AsientoDAO asientosContables = new AsientoDAO();
    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "contabilidad.htm")
    public ModelAndView listaAsientosContables() {
        List<Asientos> asientoses = asientosContables.getAsientosContables();
        modelAndView.addObject("asientos", asientoses);
        modelAndView.setViewName("contabilidad");
        return modelAndView;
    }
}

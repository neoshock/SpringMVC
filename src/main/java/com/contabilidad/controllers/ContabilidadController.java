package com.contabilidad.controllers;

import com.contabilidad.dao.AsientoDAO;
import com.contabilidad.models.Asientos;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContabilidadController {

    private AsientoDAO asientosContables = new AsientoDAO();
    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("contabilidad.htm")
    public ModelAndView listaAsientosContables() {
        List<Asientos> asientos = asientosContables.getAsientosContables();
        modelAndView.addObject("asientos", asientos);
        modelAndView.setViewName("contabilidad");
        return modelAndView;
    }
}

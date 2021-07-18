package com.contabilidad.controllers;

import com.contabilidad.dao.AsientoDAO;
import com.contabilidad.models.Asiento;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContabilidadController {

    private AsientoDAO asientosContables = new AsientoDAO();
    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("contabilidad.htm")
    public ModelAndView listaAsientosContables() {
        List<Asiento> asientos = asientosContables.getAsientosContables();
        modelAndView.addObject("asientos", asientos);
        modelAndView.setViewName("contabilidad");
        return modelAndView;
    }
    
    @RequestMapping(value = "agregarAsiento.htm", method = RequestMethod.GET)
    public ModelAndView addAsientoContable(){
        modelAndView.addObject(new Asiento());
        modelAndView.setViewName("agregarAsiento");
        return modelAndView;
    }
    
    @RequestMapping(value = "agregarAsiento.htm", method = RequestMethod.POST)
    public ModelAndView addAsientoContable(@Valid @ModelAttribute Asiento asiento){
        System.out.println(asiento.getFecha());
        asientosContables.addAsientoContable(asiento);
        return new ModelAndView("redirect:/contabilidad.htm");
    }
}

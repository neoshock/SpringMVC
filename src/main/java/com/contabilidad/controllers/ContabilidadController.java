package com.contabilidad.controllers;

import com.contabilidad.dao.AsientoDAO;
import com.contabilidad.models.Asiento;
import com.contabilidad.models.Movimientos;
import com.contabilidad.models.SubCuenta;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ModelAndView addAsientoContable() {
        modelAndView.addObject(new Asiento());
        List<SubCuenta> subCuentas = asientosContables.getCuentasContables();
        modelAndView.addObject("cuentas", subCuentas);
        modelAndView.setViewName("agregarAsiento");
        return modelAndView;
    }

    @RequestMapping(value = "agregarAsiento.htm", method = RequestMethod.POST)
    public ModelAndView addAsientoContable(@Valid @ModelAttribute Asiento asiento) {
        asientosContables.addAsientoContable(asiento);
        return new ModelAndView("redirect:/contabilidad.htm");
    }

    @RequestMapping(value = "editarAsiento.htm", method = RequestMethod.GET)
    public ModelAndView editAsientoContable(HttpServletRequest request) {
        modelAndView = new ModelAndView();
        List<SubCuenta> subCuentas = asientosContables.getCuentasContables();
        modelAndView.addObject("cuentas", subCuentas);
        int id = Integer.parseInt(request.getParameter("id"));
        Asiento asiento = asientosContables.getAsientoById(id);
        modelAndView.addObject("asiento", asiento);
        modelAndView.setViewName("editarAsiento");
        return modelAndView;
    }

    @RequestMapping(value = "editarAsiento.htm", method = RequestMethod.POST)
    public ModelAndView editAsientoContable(@Valid @ModelAttribute Asiento asiento,HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean estado = asientosContables.editAsientoContable(asiento,id);
        if (estado) {
            return new ModelAndView("redirect:/contabilidad.htm");
        }else{
            modelAndView.setViewName("editarAsiento");
            return modelAndView;
        }
    }
}

package com.cuentaxcobrar.controllers;

import com.cuentaxcobrar.dao.ClienteDAO;
import com.cuentaxcobrar.models.Cliente;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    ClienteDAO clientedao = new ClienteDAO();
    ModelAndView mav = new ModelAndView();
    int id;

    @RequestMapping("mantenimientoclientes.htm")
    public ModelAndView lista() {
        List<Cliente> clientes = clientedao.obtenerCliente();
        mav.addObject("clientes", clientes);
        mav.setViewName("mantenimientoclientes");
        return mav;
    }

    @RequestMapping(value = "agregarCliente.htm", method = RequestMethod.GET)
    public ModelAndView agregarCliente() {
        mav = new ModelAndView();
        mav.addObject(new Cliente());
        mav.setViewName("agregarCliente");
        return mav;
    }

    @RequestMapping(value = "agregarCliente.htm", method = RequestMethod.POST)
    public ModelAndView agregarCliente(Cliente cliente) {
        clientedao.insertarCliente(cliente);
        return new ModelAndView("redirect:/mantenimientoclientes.htm");
    }

    @RequestMapping(value = "editarCliente.htm", method = RequestMethod.GET)
    public ModelAndView editarCliente(HttpServletRequest request) {
        mav = new ModelAndView();
        id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = clientedao.getIdCliente(id);
        mav.addObject("cliente", cliente);
        mav.setViewName("editarCliente");
        return mav;
    }

    @RequestMapping(value = "editarCliente.htm", method = RequestMethod.POST)
    public ModelAndView editarCliente(Cliente cliente, HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        boolean state = clientedao.modificarCliente(cliente, id);
        if (state) {
            return new ModelAndView("redirect:/mantenimientoclientes.htm");
        } else {
            mav.setViewName("editarCliente");
            return mav;
        }
    }
    
    @RequestMapping(value = "anularCliente.htm")
    public ModelAndView anularCliente(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        boolean state = clientedao.anularCliente(id);
        if (state) {
            return new ModelAndView("redirect:/mantenimientoclientes.htm");
        } else {
            return new ModelAndView("redirect:/mantenimientoclientes.htm");
        }
    }
    
    @RequestMapping(value = "desanularCliente.htm")
    public ModelAndView desanularCliente(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        boolean state = clientedao.desanularCliente(id);
        if (state) {
            return new ModelAndView("redirect:/mantenimientoclientes.htm");
        } else {
            return new ModelAndView("redirect:/mantenimientoclientes.htm");
        }
    }
}

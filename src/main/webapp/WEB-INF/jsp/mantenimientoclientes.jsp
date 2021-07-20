
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <title>Mantenimiento a Clientes</title>
    </head>
    <body>
        <div class="header">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="index.htm">ERP CONTABLE</a>
                    <button class="navbar-toggler" type="button" 
                            data-bs-toggle="collapse" 
                            data-bs-target="#navbarSupportedContent" 
                            aria-controls="navbarSupportedContent" 
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" href="index.htm">Inicio</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" 
                                   id="navbarDropdown" role="button" 
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    Contabilidad
                                </a>
                                <ul class="dropdown-menu" 
                                    aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" 
                                           href="contabilidad.htm">
                                            Asientos Contables
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" 
                                   href="#" id="navbarDropdown" 
                                   role="button" data-bs-toggle="dropdown" 
                                   aria-expanded="false">
                                    Cuentas por cobrar
                                </a>
                                <ul class="dropdown-menu" 
                                    aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" 
                                           href="mantenimientoclientes.htm">
                                            Mantenimiento Clientes
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div>
            <div class="row w-100" style="margin: 0px;">
                <div class="col-md-12">
                    <h3>Mantenimiento a Clientes</h3>
                </div>
                <div class="bg-light text-white">
                    <a class="btn btn-primary" 
                       href="agregarCliente.htm">
                        Nuevo Cliente
                    </a>
                </div>
                <div class="col-md-12">
                    <table class="table table-hover">
                        <thead style="text-align: center;">
                            <tr>
                                <th>Identificación</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Dirección</th>
                                <th>Teléfono</th>
                                <th>Email</th>
                                <th>Habilitado</th>
                            </tr>
                        </thead>
                        <tbody style="text-align: center;">
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td>${cliente.identificacion}</td>
                                    <td>${cliente.nombres}</td>
                                    <td>${cliente.apellidos}</td>
                                    <td>${cliente.direccion}</td>
                                    <td>${cliente.telefono}</td>
                                    <td>${cliente.email}</td>

                                    <td <c:if test="${cliente.habilitado == true}">
                                            style="background-color: #72FF2D"
                                        </c:if>
                                        <c:if test="${cliente.habilitado == false}">
                                            style="background-color: #FD4747"
                                        </c:if>>
                                        ${cliente.habilitado}
                                    </td>
                                    <td>
                                        <a class="btn btn-info p-1" 
                                           href="editarCliente.htm?id=${cliente.id}">
                                            <i class="bi bi-pencil-square"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-info p-1"
                                           href="anularCliente.htm?id=${cliente.id}">
                                            <i class="bi bi-person-x-fill"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-info p-1"  
                                           href="desanularCliente.htm?id=${cliente.id}">
                                            <i class="bi bi-person-check-fill"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

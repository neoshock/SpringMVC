
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                   id="navbarDropdown" 
                                   role="button" data-bs-toggle="dropdown" 
                                   aria-expanded="false">
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
                                <a class="nav-link dropdown-toggle" href="#" 
                                   id="navbarDropdown" 
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
        <div class="container mb-4">
            <div class="row w-100">
                <div class="col-md-12 mt-3 mb-4">
                    <h3>Nuevo Cliente</h3>
                </div>
                <div class="col-md-12">
                    <form class="needs-validation" method="POST">
                        <div class="card">
                            <div class="card-body">
                                <div class="row justify-content-around p-1">
                                    <div class="col-md-5">
                                        <label for="identificacion" 
                                               class="form-label">
                                            Identificación*
                                        </label>
                                        <input name="identificacion" type="text"
                                               maxlength="10"
                                               class="form-control mb-2" 
                                               id="identificacion" required>
                                        
                                        <div class="invalid-feedback">
                                            Ingrese su Identificación
                                        </div>

                                        <label for="nombre" class="form-label">
                                            Nombres*
                                        </label>
                                        <input name="nombres" type="text" 
                                               class="form-control mb-2" 
                                               id="nombre" required>
                                        
                                        <div class="invalid-feedback">
                                            Ingrese sus Nombres
                                        </div>

                                        <label for="apellido" class="form-label">
                                            Apellidos*
                                        </label>
                                        <input name="apellidos" type="text"
                                               class="form-control mb-2" 
                                               id="apellido" required>
                                        
                                        <div class="invalid-feedback">
                                            Ingrese sus Apellidos
                                        </div>

                                        <label for="direccion" class="form-label">
                                            Dirección*
                                        </label>
                                        <input name="direccion" type="text" 
                                               class="form-control mb-2" 
                                               id="direccion" required>
                                        
                                        <div class="invalid-feedback">
                                            Ingrese su Dirección
                                        </div>
                                        
                                        <label for="telefono" class="form-label">
                                            Teléfono*
                                        </label>
                                        <input name="telefono" type="text" 
                                               maxlength="10"
                                               class="form-control mb-2" 
                                               id="telefono" required>
                                        
                                        <div class="invalid-feedback">
                                            Ingrese su Teléfono
                                        </div>
                                        
                                        <label for="email" class="form-label">
                                            Email*
                                        </label>
                                        <input name="email" type="text" 
                                               class="form-control mb-2" 
                                               id="email" required>
                                        
                                        <div class="invalid-feedback">
                                            Ingrese su Email
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mt-3">
                            <a class="btn btn-secondary" 
                               href="mantenimientoclientes.htm">
                                Regresar
                            </a>
                            <input type="submit" class="btn btn-primary" 
                                   value="Agregar Cliente">
                        </div>  
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

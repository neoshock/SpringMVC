<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
        crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="resources/css/asientos.css"> 
        <title>Welcome to Spring Web MVC project</title>
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
    <section class="reviews">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="titulos">Descripcion del proyecto</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 cliente">
                    <div class="foto">
                        <img src="resources/img/User_Circle.png" alt="">
                    </div>
                    <div class="review">
                        <p class="texto">
                            Módulo de contabilidad, asientos contables, 
                            operaciones básicas de ingreso y edición, 
                            realizar ajuste basico del balance.
                        </p>
                        <p class="nombre">-Josue Alcivar</p>
                    </div>
                </div>
                <div class="col-md-12 cliente derecha">
                    <div class="foto">
                        <img src="resources/img/User_Circle.png" alt="">
                    </div>
                    <div class="review">
                        <p class="texto">
                            Módulo de Cuentas por Cobrar, 
                            mantenimiento a clientes,
                            operaciones básicas de registrar, editar y 
                            anular un cliente.
                        </p>
                        <p class="nombre">-Alexander Vega</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<footer>
    <div class="direccion">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h4 class="titulo">Contenido en GitHub</h4>
                    <a class="calle text-light" 
                       href="https://github.com/neoshock/SpringMVC">
                        Enlace al proyecto en GitHub
                    </a>
                </div>
                <div class="col-md-4 logo">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/800px-Spring_Framework_Logo_2018.svg.png" alt="">
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>

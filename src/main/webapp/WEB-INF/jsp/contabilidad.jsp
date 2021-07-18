<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="index.htm">ERP CONTABLE</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="#">Inicio</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
                                   role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Contabilidad
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="contabilidad.htm">Asientos Contables</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="asientos-container">
            <div class="row w-100" style="margin: 0px;">
                <div class="col-md-12 asientos-header">
                    <h3>Asientos Contables</h3>
                </div>
                <div class="col-md-12 asientos-header">
                    <a class="btn btn-primary" href="agregarAsiento.htm">Nuevo Asiento</a>
                </div>
                <div class="col-md-12">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Numero</th>
                                <th scope="col">Fecha</th>
                                <th scope="col">Referencia</th>
                                <th scope="col">Diario</th>
                                <th scope="col">Total</th>
                                <th scope="col">Estado</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="asiento" items="${asientos}">
                                <tr>
                                    <th scope="row">${asiento.numero}</th>
                                    <td>${asiento.fecha}</td>
                                    <td>${asiento.referencia}</td>
                                    <td>${asiento.idDiario}</td>
                                    <td>${asiento.total}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${asiento.estado == 'pendiente'}">
                                                <span class="rounded p-1 text-light bg-secondary">
                                                    ${asiento.estado}
                                                </span>
                                            </c:when>
                                            <c:when test="${asiento.estado == 'publicado'}">
                                                <span class="rounded p-1 text-light bg-success">
                                                    ${asiento.estado}
                                                </span>
                                            </c:when>
                                            <c:when test="${asiento.estado == 'cerrado'}">
                                                <span class="rounded p-1 text-light bg-warning">
                                                    ${asiento.estado}
                                                </span>
                                            </c:when>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <button class="btn btn-info p-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

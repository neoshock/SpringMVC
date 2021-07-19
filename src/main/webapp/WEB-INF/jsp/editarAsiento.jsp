<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="resources/js/contabilidad.js"></script>
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
        <div class="container mb-4">
            <div class="row w-100">
                <div class="col-md-9 mt-3 mb-4">
                    <h3>Detalles de Asiento Contable</h3>
                </div>
                <div class="col-md-3 mt-4 mb-3">
                    <c:if test="${asiento.estado == 'pendiente'}">
                        <span class="bg-secondary rounded p-2 fs-5 text-light">
                            ${asiento.estado}
                        </span>
                    </c:if>
                    <c:if test="${asiento.estado == 'publicado'}">
                        <span class="bg-success rounded p-2 fs-5 text-light">
                            ${asiento.estado}
                        </span>
                    </c:if>
                    <c:if test="${asiento.estado == 'cerrado'}">
                        <span class="bg-danger rounded p-2 fs-5 text-light">
                            ${asiento.estado}
                        </span>
                    </c:if>
                </div>
                <div class="col-md-12">
                    <form class="needs-validation" method="POST">
                        <div class="card">
                            <div class="card-body">
                                <div class="row justify-content-around p-1">
                                    <div class="col-md-5">
                                        <label for="numero" class="form-label">Numero de asiento*</label>
                                        <input type="text" name="numero" class="form-control mb-2" id="numero" value="${asiento.numero}" required readonly="true">
                                        <div class="invalid-feedback">
                                            El valor ingresado no coincide
                                        </div>
                                        <label for="referencia" class="form-label">Documento Referencia*</label>
                                        <input type="text" name="referencia" class="form-control mb-2" id="referencia" value="${asiento.referencia}" required <c:if test="${asiento.estado == 'cerrado'}">disabled</c:if>>
                                        <div class="invalid-feedback">
                                            No existe el documento establecido
                                        </div>
                                        <label for="observaciones" class="form-label">Observaciones</label>
                                        <textarea name="observaciones" class="form-control mb-2"  rows="3" maxlength="60" 
                                                  style="resize: none;" placeholder="Maximo 60 caracteres" <c:if test="${asiento.estado == 'cerrado'}">disabled</c:if>>${asiento.observaciones}</textarea>
                                    </div>
                                    <div class="col-md-5">
                                        <label for="fecha" class="form-label">Fecha*</label>
                                        <input name="fecha" type="date" class="form-control mb-2" id="fecha" value="${asiento.fecha}" required <c:if test="${asiento.estado == 'cerrado'}">disabled</c:if>>
                                        <div class="invalid-feedback">
                                            Seleccione una fecha
                                        </div>

                                        <label for="fechaCierre" class="form-label">Fecha de cierre*</label>
                                        <input name="fechaCierre" type="date" class="form-control mb-2" id="fechaCierre" value="${asiento.fechaCierre}" required <c:if test="${asiento.estado == 'cerrado'}">disabled</c:if>>
                                        <div class="invalid-feedback">
                                            Seleccione la fecha de cierre
                                        </div>

                                        <label for="diario" class="form-label">Diario</label>
                                        <select name="diario" class="form-select mb-4" id="diario" aria-label="Default select example" <c:if test="${asiento.estado == 'cerrado'}">disabled</c:if>>
                                            <option value="${asiento.idDiario}">DIA-CPP-001</option>
                                        </select>

                                        <label for="estado" class="form-label">Opciones de Asiento</label>
                                        <select class="form-select mb-4" name="estado" id="estado" aria-label="Default select example" <c:if test="${asiento.estado == 'cerrado'}">disabled</c:if>>
                                            <c:if test="${asiento.estado == 'cerrado'}">
                                                <option value="cerrado">Cerrar Asiento Contable</option>
                                            </c:if>
                                            <option value="pendiente">Pendiente por publicar</option>
                                            <option value="publicado">Publicar Asiento</option>
                                            <option value="cerrado">Cerrar Asiento Contable</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 mb-3">
                                        <button id="addAsiento" type="button" class="btn btn-success" disabled>Agregar Linea</button>
                                    </div>
                                    <div class="col-md-12 border rounded p-1">
                                        <table class="table table-light table-hover" id="movimientosDt">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Cuenta Contable</th>
                                                    <th scope="col">Detalle</th>
                                                    <th scope="col">Debe</th>
                                                    <th scope="col">Haber</th>
                                                    <th scope="col"></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="movimiento" items="${movimientos}">
                                                    <tr>
                                                        <th scope="row">
                                                            <select class="form-select" name="${movimiento.idSubcuenta}" disabled>
                                                                <c:forEach var="cuenta" items="${cuentas}">
                                                                    <option value="${cuenta.idSubcuenta}">${cuenta.codigo} ${cuenta.nombre}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </th>
                                                        <td>
                                                            <input disabled value="${movimiento.tipoMovimiento}" name="tipoMovimiento" type="text" class="form-control" placeholder="Descripcion" maxlength="21">
                                                        </td>
                                                        <td>
                                                            <input disabled name="debe" type="number" value="${movimiento.debe}" class="number form-control">
                                                        </td>
                                                        <td>
                                                            <input disabled name="haber" type="number" value="${movimiento.haber}" class="number form-control">
                                                        </td>
                                                        <td class="trash">
                                                            <button type="button" class="btn btn-danger" disabled><i class="bi bi-trash"></i></button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <td>
                                                    </td>
                                                    <td>
                                                    </td>
                                                    <td>
                                                        <input class="form-control" name="totalD" type="number" value="${asiento.total}" disabled>
                                                    </td>
                                                    <td>
                                                        <input class="form-control" name="totalH" type="number" value="${asiento.total}" disabled>
                                                    </td>
                                                    <td>
                                                    </td>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mt-3">
                            <a class="btn btn-secondary" href="contabilidad.htm">Regresar</a>
                            <input type="submit" class="btn btn-primary" value="Guardar Cambios" <c:if test="${asiento.estado == 'cerrado'}">disabled</c:if>>
                        </div>  
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

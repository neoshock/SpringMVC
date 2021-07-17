<%-- 
    Document   : contabilidad
    Created on : 17/07/2021, 11:43:31
    Author     : pideu
--%>

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
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Nuevo Asiento</button>
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl modal-dialog-centered modal-dialog-scrollable">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Registrar Asiento Contable</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <form class="needs-validation" novalidate style="overflow-y: scroll;">
                                    <div class="modal-body">
                                        <div class="row justify-content-around p-1">
                                            <div class="col-md-5">
                                                <label for="asientoNumero" class="form-label">Numero de asiento</label>
                                                <input type="text" class="form-control mb-2" id="asientoNumero" value="" required>
                                                <div class="invalid-feedback">
                                                    El valor ingresado no coincide
                                                </div>
                                                <label for="documentoNumero" class="form-label">Documento Referencia</label>
                                                <input type="text" class="form-control mb-2" id="documentoNumero" value="" required>
                                                <div class="invalid-feedback">
                                                    No existe el documento establecido
                                                </div>
                                                <label for="observacionAsiento" class="form-label">Observaciones</label>
                                                <textarea class="form-control mb-2" rows="3" maxlength="60" 
                                                          style="resize: none;" placeholder="Maximo 60 caracteres"></textarea>
                                            </div>
                                            <div class="col-md-5">
                                                <label for="fechaAsiento" class="form-label">Fecha</label>
                                                <input type="datetime-local" class="form-control mb-2" id="fechaAsiento" value="" required>
                                                <div class="invalid-feedback">
                                                    Ingrese una fecha
                                                </div>

                                                <label for="diarioAsiento" class="form-label">Diario</label>
                                                <select class="form-select mb-4" id="diarioAsiento" aria-label="Default select example">
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                </select>

                                                <div class="form-check mb-3">
                                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="asientoPulbicar">
                                                    <label class="form-check-label" for="asientoPulbicar">
                                                        Publicar Asiento
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="asientoRevisar" checked>
                                                    <label class="form-check-label" for="asientoRevisar">
                                                        Por Revisar
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 mb-3">
                                                <button type="button" class="btn btn-success">Agregar Linea</button>
                                            </div>
                                            <div class="col-md-12 border rounded p-1">
                                                <table class="table table-light table-hover">
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
                                                        <tr>
                                                            <th scope="row">
                                                                <select class="form-select">
                                                                    <option value="1">One</option>
                                                                    <option value="2">Two</option>
                                                                    <option value="3">Three</option>
                                                                </select>
                                                            </th>
                                                            <td>
                                                                <input type="text" class="form-control" placeholder="Descripcion" maxlength="30">
                                                            </td>
                                                            <td>
                                                                <input type="number" class="form-control">
                                                            </td>
                                                            <td>
                                                                <input type="number" class="form-control">
                                                            </td>
                                                            <td>
                                                                <button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                    <tfoot>
                                                        <tr>
                                                            <td>
                                                            </td>
                                                            <td>
                                                            </td>
                                                            <td>
                                                                <p>$0.00</p>
                                                            </td>
                                                            <td>
                                                                <p>$0.00</p>
                                                            </td>
                                                            <td>
                                                            </td>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                        <input type="submit" class="btn btn-primary" value="Agregar Asiento">
                                    </div>  
                                </form>
                            </div>
                        </div>
                    </div>
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
                            <tr>
                                <th scope="row">ASC-0012</th>
                                <td>18/06/2021</td>
                                <td>DOC-0001</td>
                                <td>DIA-INV-0111</td>
                                <td>$536.00</td>
                                <td>
                                    <span class="bg-secondary rounded p-1 text-light">
                                        Por revisar
                                    </span>
                                </td>
                                <td>
                                    <button class="btn btn-info p-1">
                                        <i class="bi bi-pencil-square"></i>
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script>
            // Example starter JavaScript for disabling form submissions if there are invalid fields
            (function () {
                'use strict'

                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.querySelectorAll('.needs-validation')

                // Loop over them and prevent submission
                Array.prototype.slice.call(forms)
                        .forEach(function (form) {
                            form.addEventListener('submit', function (event) {
                                if (!form.checkValidity()) {
                                    event.preventDefault()
                                    event.stopPropagation()
                                }
                                form.classList.add('was-validated')
                            }, false)
                        })
            })()
        </script>
    </body>
</html>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Models.Trabajador"%>
<%@page import="ModelsDAO.TrabajadorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 

<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Java - CRUD</title>
  </head>
  <body>
       <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Navbar</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="index.jsp">Inicio</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="TrabajadorController?accion=index">Trabajadores</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="DepartamentoController?accion=index">Departamentos</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link active" href="CargoController?accion=index">Cargos</a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
      <div class="container">
          <div class='row mx-auto my-auto'>
              <div class="col-3">
                    <h1>
                        Trabajadores
                    </h1>       
              </div>
              <div class="col text-end p-0 pt-2">
                  <a class="btn btn-primary" href="TrabajadorController?accion=crear">Crear Trabajador</a>
              </div>
              
          </div>
             
        

          <table class="table table-hover">
    <thead>
        <tr>
            <th>id</th>
            <th>Cedula</th>
            <th>Nombres</th>
            <th>Edad</th>
            <th>Cargo</th>
            <th>Departamento</th>
            <th>Acciones</th>
        </tr>
    </thead>
    
            <%
                TrabajadorDAO dao = new TrabajadorDAO();
                List<Trabajador>list = dao.index();
                Iterator<Trabajador>iter = list.iterator();
                Trabajador trabajador = null;
                
                while(iter.hasNext()){
                    trabajador = iter.next();
                
            %>
                <tr>
                    <td><%= trabajador.getId() %></td>
                    <td><%= trabajador.getCedula()%></td>
                    <td><%= trabajador.getNombres() %></td>
                    <td><%= trabajador.getEdad()%></td>
                    <td><%= trabajador.getCargo()%></td>
                    <td><%= trabajador.getDepartamento()%></td>
                    <td>
                        <a class="btn btn-primary" href="TrabajadorController?accion=editar&id=<%= trabajador.getId() %>">Editar</a>
                        <a class="btn btn-primary" href="TrabajadorController?accion=eliminar&id=<%= trabajador.getId() %>">Eliminar</a>
                    </td>
                </tr>
                <% } %>
    
</table>
          

      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
  </body>
  
  
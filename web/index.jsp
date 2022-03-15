
<%@page import="ModelsDAO.CargoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModelsDAO.TrabajadorDAO"%>
<%@page import="ModelsDAO.DepartamentoDAO"%>
<%@page import="Models.Trabajador"%>
<%@page import="Models.Departamento"%>
<%@page import="Models.Cargo"%>
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
                    <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="TrabajadorController?accion=index">Trabajadores</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="DepartamentoController?accion=index">Departamentos</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="CargoController?accion=index">Cargos</a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
      <div class="container">
         
        <h1>
          Inicio
        </h1>

          <table class="table table-hover">
              <thead>
                  <tr>
                      <td colspan="2">
                          Cantidad de Trabajadores con el mismo Nombre
                      </td>
                  </tr>
                  <tr>
                      <th>
                          Nombre
                      </th>
                      <th>
                          Cantidad de Personas
                      </th>
                  </tr>
              </thead>
              <tbody>
                  <%
                   TrabajadorDAO dao = new TrabajadorDAO();
                List<Trabajador>list = dao.getCountAllNames();
                Iterator<Trabajador>iter = list.iterator();
                Trabajador trabajador = null;
                
                while(iter.hasNext()){
                    trabajador = iter.next();
                
                  %>
               <tr>
                <td><%= trabajador.getCantidad() %></td>
                <td><%= trabajador.getNombres() %></td>
               </tr>
                  <%
                    }
                  %>
              </tbody>
          </table>
              
          <table class="table table-hover">
              <thead>
                  <tr>
                      <td colspan="2">
                          Cantidad de Trabajadores por Cargo
                      </td>
                  </tr>
                  <tr>
                      <th>
                          Cargo
                      </th>
                      <th>
                          Cantidad de Personas
                      </th>
                  </tr>
              </thead>
              <tbody>
                  <%
                    CargoDAO dao2 = new CargoDAO();
                    List<Cargo>list2 = dao2.getCountAllTrabajadores();
                    Iterator<Cargo>iter2 = list2.iterator();
                    Cargo cargo = null;
                
                while(iter2.hasNext()){
                    cargo = iter2.next();
                
                  %>
               <tr>
                <td><%= cargo.getCantidad() %></td>
                <td><%= cargo.getNombre() %></td>
               </tr>
                  <%
                    }
                  %>
              </tbody>
          </table>
              
          <table class="table table-hover">
              <thead>
                  <tr>
                      <td colspan="2">
                          Cantidad de Trabajadores por Departamento
                      </td>
                  </tr>
                  <tr>
                      <th>
                          Departamento
                      </th>
                      <th>
                          Cantidad de Personas
                      </th>
                  </tr>
              </thead>
              <tbody>
                  <%
                    DepartamentoDAO dao3 = new DepartamentoDAO();
                    List<Departamento>list3 = dao3.getCountAllTrabajadores();
                    Iterator<Departamento>iter3 = list3.iterator();
                    Departamento departamento = null;
                
                while(iter3.hasNext()){
                    departamento = iter3.next();
                
                  %>
               <tr>
                <td><%= departamento.getCantidad() %></td>
                <td><%= departamento.getNombre() %></td>
               </tr>
                  <%
                    }
                  %>
              </tbody>
          </table>
          

      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
  </body>
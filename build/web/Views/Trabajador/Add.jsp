
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModelsDAO.CargoDAO"%>
<%@page import="ModelsDAO.DepartamentoDAO"%>
<%@page import="Models.Cargo"%>
<%@page import="Models.Departamento"%>
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
                    <a class="nav-link active" href="TrabajadorController?accion=index">Trabajadores</a>
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
          <div class='row mx-auto my-auto'>
              <div class="col-3">
                    <h1>
                        Crear Trabajador
                    </h1>       
              </div>
              <div class="col text-end p-0 pt-2">
                  <a class="btn btn-primary" href="TrabajadorController?accion=index">Regresar</a>
              </div>
              
          </div>
             
          <div class="row">
              <form class="row row-cols-lg-auto g-3 align-items-center" action='TrabajadorController'>
                  
                  
                  <div class="col-12">
                    <div class="input-group">
                        <div class="input-group-text">Cedula</div>
                        <input type="text" class="form-control" name="cedula">
                      </div>
                    </div>
                  <div class="col-12">
                    <div class="input-group">
                        <div class="input-group-text">Nombres</div>
                      <input type="text" class="form-control" name="nombres">
                    </div>
                  </div>
          
                  <div class="col-12">
                    <div class="input-group">
                        <div class="input-group-text">Edad</div>
                      <input type="number" min="18" class="form-control" name="edad">
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="input-group">
                        <div class="input-group-text">Cargo</div>
                    <select class="form-select" name="id_cargo">
                       <option selected>Seleccione...</option>
                      <%   
                        CargoDAO dao = new CargoDAO();
                        List<Cargo>list = dao.index();
                        Iterator<Cargo>iter = list.iterator();
                        Cargo cargo = null;
                        
                        while(iter.hasNext()){
                            cargo = iter.next();
                      %>
                      <option value="<%= cargo.getId()%>"><%= cargo.getNombre() %></option>
                      <%
                          }
                      %>
                    </select>
                    </div>
                  </div>
                    
                    <div class="col-12">
                    <div class="input-group">
                        <div class="input-group-text">Departamento</div>
                    <select class="form-select" name="id_departamento">
                       <option selected>Seleccione...</option>
                      <%   
                        DepartamentoDAO dao2 = new DepartamentoDAO();
                        List<Departamento>list2 = dao2.index();
                        Iterator<Departamento>iter2 = list2.iterator();
                        Departamento departamento = null;
                        
                        while(iter2.hasNext()){
                            departamento = iter2.next();
                      %>
                      <option value="<%= departamento.getId()%>"><%= departamento.getNombre() %></option>
                      <%
                          }
                      %>
                    </select>
                    </div>
                  </div>
                 
                  
                  <div class="col mt-2">
                      <input type='submit' value="Guardar" name='accion' class="btn btn-primary">
                  </div>
                  
                   
              </form>
          </div>
 
          

      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
  </body>
  
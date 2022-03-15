/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Trabajador;
import ModelsDAO.TrabajadorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zippypc
 */
@WebServlet(name = "TrabajadorController", urlPatterns = {"/TrabajadorController"})
public class TrabajadorController extends HttpServlet {

    String index = "Views/Trabajador/Index.jsp";
    String add = "Views/Trabajador/Add.jsp";
    String edit = "Views/Trabajador/Edit.jsp";
    
    Trabajador trabajador = new Trabajador();
    TrabajadorDAO dao = new TrabajadorDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrabajadorController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrabajadorController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String acceso = "";
        String action = request.getParameter("accion");
        
        if(action.equalsIgnoreCase("index")){
            acceso = index;
        }else if( action.equalsIgnoreCase("crear")){
              acceso = add;
        }else if( action.equalsIgnoreCase("Guardar")){
            String nombre   = request.getParameter("nombres");
            String cedula   = request.getParameter("cedula");
            int edad     = Integer.parseInt(request.getParameter("edad"));
            int id_departamento     = Integer.parseInt(request.getParameter("id_departamento"));
            int id_cargo     = Integer.parseInt(request.getParameter("id_cargo"));
            
            trabajador.setNombres(nombre);
            trabajador.setCedula(cedula);
            trabajador.setEdad(edad);
            trabajador.setId_cargo(id_cargo);
            trabajador.setId_departamento(id_departamento);
            dao.store(trabajador);
            
            acceso = index;
        }
        else if( action.equalsIgnoreCase("editar")){
            request.setAttribute("id", request.getParameter("id"));
            acceso = edit;
            
        }
        else if( action.equalsIgnoreCase("Actualizar")){
            int id           = Integer.parseInt(request.getParameter("id"));
            String nombre   = request.getParameter("nombres");
            String cedula   = request.getParameter("cedula");
            int edad     = Integer.parseInt(request.getParameter("edad"));
            int id_departamento     = Integer.parseInt(request.getParameter("id_departamento"));
            int id_cargo     = Integer.parseInt(request.getParameter("id_cargo"));
            
            trabajador.setNombres(nombre);
            trabajador.setId(id);
            trabajador.setCedula(cedula);
            trabajador.setEdad(edad);
            trabajador.setId_cargo(id_cargo);
            trabajador.setId_departamento(id_departamento);
            
            trabajador.setNombres(nombre);
            trabajador.setId(id);
            dao.update(trabajador);
            
            acceso = index;
        }
        else if( action.equalsIgnoreCase("eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            trabajador.setId(id);
            dao.delete(id);
            
            acceso = index;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

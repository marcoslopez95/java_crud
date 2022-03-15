/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Departamento;
import ModelsDAO.DepartamentoDAO;
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
@WebServlet(name = "DepartamentoController", urlPatterns = {"/DepartamentoController"})
public class DepartamentoController extends HttpServlet {

    String index = "Views/Departamento/Index.jsp";
    String add = "Views/Departamento/Add.jsp";
    String edit = "Views/Departamento/Edit.jsp";
    
    Departamento departamento = new Departamento();
    DepartamentoDAO dao = new DepartamentoDAO();
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
            out.println("<title>Servlet DepartamentoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DepartamentoController at " + request.getContextPath() + "</h1>");
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
            String nombre   = request.getParameter("nombre");
            departamento.setNombre(nombre);
            
            dao.store(departamento);
            
            acceso = index;
        }
        else if( action.equalsIgnoreCase("editar")){
            request.setAttribute("id", request.getParameter("id"));
            acceso = edit;
            
        }
        else if( action.equalsIgnoreCase("Actualizar")){
            int id           = Integer.parseInt(request.getParameter("id"));
            String nombre   = request.getParameter("nombre");
            
            departamento.setNombre(nombre);
            departamento.setId(id);
            dao.update(departamento);
            
            acceso = index;
        }
        else if( action.equalsIgnoreCase("eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            departamento.setId(id);
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

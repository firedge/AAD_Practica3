package com.firedge.controlador;

import com.firedge.hibernate.Inmueble;
import com.firedge.modelo.ModeloInmueble;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/control"})
public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destino = "index.html";
        boolean forward = false;
        String target, op, action, view;
        target = request.getParameter("target");
        op = request.getParameter("op");
        action = request.getParameter("action");

        //Ver todos los datos de la tabla
        if (target.equals("inmueble")
                && op.equals("select")
                && action.equals("view")) {
            forward = true;
            destino = "WEB-INF/index.jsp";
            request.setAttribute("datos", ModeloInmueble.get());
            
        //Eliminar un inmueble
        } else if(target.equals("inmueble")
                && op.equals("delete")
                && action.equals("op")){
            forward = false;
            ModeloInmueble.delete(request.getParameter("id"));
            destino = "control?target=inmueble&op=select&action=view";
            
        //Insertar un nuevo inmueble
        } else if(target.equals("inmueble")
                && op.equals("insert")
                && action.equals("view")){
            forward = true;
            destino = "WEB-INF/insert.jsp";
        } else if(target.equals("inmueble")
                && op.equals("insert")
                && action.equals("op")){
            forward = false;
            destino = "control?target=inmueble&op=select&action=view";
            Inmueble inmueble = new Inmueble();
            inmueble.setLocalidad(request.getParameter("localidad"));
            inmueble.setDireccion(request.getParameter("direccion"));
            inmueble.setTipo(request.getParameter("tipo"));
            try{
                inmueble.setPrecio(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precio"))));
            } catch (Exception e){
                inmueble.setPrecio(BigDecimal.valueOf(0));
            }
            inmueble.setUsuario(request.getParameter("usuario"));
            System.out.println(inmueble.toString());
            ModeloInmueble.insert(inmueble);
        } else if(target.equals("inmueble")
                && op.equals("insert")
                && action.equals("opm")){
            forward = true;
            Inmueble inmueble = new Inmueble();
            inmueble.setLocalidad(request.getParameter("localidad"));
            inmueble.setDireccion(request.getParameter("direccion"));
            inmueble.setTipo(request.getParameter("tipo"));
            try{
                inmueble.setPrecio(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precio"))));
            } catch (Exception e){
                inmueble.setPrecio(BigDecimal.valueOf(0));
            }
            inmueble.setUsuario(request.getParameter("usuario"));
            System.out.println(inmueble.toString());
            ModeloInmueble.insert(inmueble);
            List<Inmueble> lista = ModeloInmueble.get();
            int id = lista.get(lista.size()-1).getId();
            request.setAttribute("id", id);
            destino = "WEB-INF/id.jsp";
            
        //Editar un inmueble
        } else if(target.equals("inmueble")
                && op.equals("edit")
                && action.equals("view")){
            forward = true;
            //request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("inmueble", ModeloInmueble.get(request.getParameter("id")));
            destino = "WEB-INF/edit.jsp";
        } else if(target.equals("inmueble")
                && op.equals("edit")
                && action.equals("op")){
            forward = false;
            destino = "control?target=inmueble&op=select&action=view";
            Inmueble inmueble = new Inmueble();
            inmueble.setLocalidad(request.getParameter("localidad"));
            inmueble.setDireccion(request.getParameter("direccion"));
            inmueble.setTipo(request.getParameter("tipo"));
            inmueble.setPrecio(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precio"))));
            inmueble.setUsuario(request.getParameter("usuario"));
            inmueble.setId(Integer.parseInt(request.getParameter("id")));
            ModeloInmueble.edit(inmueble);
        }

        if (forward) {
            request.getRequestDispatcher(destino).forward(request, response);
        } else {
            response.sendRedirect(destino);
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
        processRequest(request, response);
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

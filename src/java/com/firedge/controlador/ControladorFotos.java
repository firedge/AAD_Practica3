/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firedge.controlador;

import com.firedge.hibernate.Fotos;
import com.firedge.hibernate.Inmueble;
import com.firedge.modelo.ModeloFotos;
import com.firedge.modelo.ModeloInmueble;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Firedge
 */
@WebServlet(name = "ControladorFotos", urlPatterns = {"/controlfotos"})
@MultipartConfig
public class ControladorFotos extends HttpServlet {

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
        String destino = "index.html";
        boolean forward = false;
        String target, op, action, view;
        target = request.getParameter("target");
        op = request.getParameter("op");
        action = request.getParameter("action");
            //Eliminar una foto
            if(target.equals("fotos")
                && op.equals("delete")
                && action.equals("op")){
            forward = false;
            String id = request.getParameter("id");
            Fotos foto = ModeloFotos.get(id);
            ModeloFotos.delete(id);
            destino = "controlfotos?target=fotos&op=insert&action=view&id="+foto.getInmueble().getId();
            
            
        //Insertar y ver fotos de un inmueble
        } else if(target.equals("fotos")
                && op.equals("insert")
                && action.equals("view")){
            forward = true;
            //request.setAttribute("id", request.getParameter("id"));
            Inmueble inmueble = ModeloInmueble.get(request.getParameter("id"));
            request.setAttribute("datos", ModeloFotos.get(inmueble));
            request.setAttribute("inmueble", inmueble);
            destino = "WEB-INF/fotos.jsp";
        } else if(target.equals("fotos")
                && op.equals("insert")
                && action.equals("op")){
            forward = false;
            String id = request.getParameter("id");
            destino = "controlfotos?target=fotos&op=insert&action=view&id="+id;

            Part filePart = request.getPart("foto"); // Retrieves <input type="file" name="file">
            //String fileName = filePart.getSubmittedFileName();
            InputStream fileContent = filePart.getInputStream();
            // ... (do your job here)
            String date = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            String ruta ="Resources/fotos/"+id+"_image_"+date+".jpg";
            //response.setContentType("text/html;charset=UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            boolean error = false;
            try {
                FileOutputStream fos = new FileOutputStream( getServletContext().getRealPath("/") + ruta);
                byte[] array = new byte[1000]; // buffer temporal de lectura.
                int leido = fileContent.read(array);
                while (leido > 0) {
                    fos.write(array, 0, leido);
                    leido = fileContent.read(array);
                }
                // cierre de conexion y fichero.
                fileContent.close();
                fos.close();
                Fotos o = new Fotos();
                o.setInmueble(ModeloInmueble.get(id));
                o.setRuta(ruta);
                ModeloFotos.insert(o);
            } catch (Exception e) {
                error = true;
            }

            /*try(PrintWriter out = response.getWriter()){
                //out.println("<img src='subido/"+description+".jpg'/>");
                if(error)
                    out.print("(\"r\":0)");
                else
                    out.print("(\"r\":1)");
            }*/
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

<%-- 
    Document   : index
    Created on : Jan 23, 2015, 8:58:18 AM
    Author     : Firedge
--%>
<%@page import="com.firedge.hibernate.Fotos"%>
<%@page import="java.util.List"%>
<%@page import="com.firedge.hibernate.Inmueble"%>
<%
    //String id = request.getParameter("id");
    Inmueble inmueble = (Inmueble)request.getAttribute("inmueble");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inmobiliaria</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resources/style.css" media="screen" />
    </head>
    <body>
        <div class="container">
            <div>
                <h1>Inmobiliaria</h1>
                <h3>Subir nuevas fotos</h3>
                <form action="controlfotos" method="post" enctype="multipart/form-data">
                    <input type="file" name="foto" />
                    <input type="hidden" name="target" value="fotos" />
                    <input type="hidden" name="op" value="insert" />
                    <input type="hidden" name="action" value="op" />
                    <input type="hidden" name="id" value="<%= inmueble.getId()%>" />
                    <input type="submit" />
                </form>
            </div>
                    <br>
            <div class="contenedorfotos">
                <%
                    List<Fotos> lista = (List<Fotos>) request.getAttribute("datos");
                    for (Fotos p : lista) {
                %>
                <div class="fotos">
                    <img src="<%= p.getRuta()%>" width="250" height="250"/>
                    <br>
                    <a href="controlfotos?target=fotos&op=delete&action=op&id=<%= p.getId()%>">borrar</a>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>

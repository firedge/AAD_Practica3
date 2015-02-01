<%@page import="java.util.List"%>
<%@page import="com.firedge.hibernate.Inmueble"%>
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
            <h1>Inmobiliaria</h1>
            <h2>
                <a href="control?target=inmueble&op=insert&action=view">Insertar inmueble</a>
            </h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Localidad</th>
                        <th>Dirección</th>
                        <th>Tipo</th>
                        <th>Precio</th>
                        <th>Usuario</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Inmueble> lista = (List<Inmueble>) request.getAttribute("datos");
                        for (Inmueble p : lista) {
                    %>
                    <tr>
                        <td><%= p.getId()%></td>
                        <td><%= p.getLocalidad()%></td>
                        <td><%= p.getDireccion()%></td>
                        <td><%= p.getTipo()%></td>
                        <td><%= p.getPrecio()%></td>
                        <td><%= p.getUsuario()%></td>
                        <td><a href="control?target=inmueble&op=delete&action=op&id=<%= p.getId()%>">borrar</a></td>
                        <td><a href="control?target=inmueble&op=edit&action=view&id=<%= p.getId()%>">editar</a></td>
                        <td><a href="controlfotos?target=fotos&op=insert&action=view&id=<%= p.getId()%>">fotos</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
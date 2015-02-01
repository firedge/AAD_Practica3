<%@page import="com.firedge.hibernate.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //String id = request.getParameter("id");
    Inmueble inmueble = (Inmueble)request.getAttribute("inmueble");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resources/style.css" media="screen" />
    </head>
    <body>
        <h1>Inmobiliaria</h1>
        <h3>Editar inmueble</h3>
        <form action="control" method="POST">
            <div>
                <label>Localidad: </label><input type="text" name="localidad" value="<%= inmueble.getLocalidad()%>" />
            </div>
            <div>
                <label>Direccion: </label><input type="text" name="direccion" value="<%= inmueble.getDireccion()%>" />
            </div>
            <div>
                <label>Tipo: </label><input type="text" name="tipo" value="<%= inmueble.getTipo()%>" />
            </div>
            <div>
                <label>Precio: </label><input type="text" name="precio" value="<%= inmueble.getPrecio()%>" />
            </div>
            <div>
                <label>Usuario: </label><input type="text" name="usuario" value="<%= inmueble.getUsuario()%>" />
            </div>
            <div>
                <input type="hidden" name="target" value="inmueble" />
                <input type="hidden" name="op" value="edit" />
                <input type="hidden" name="action" value="op" />
                <input type="hidden" name="id" value="<%= inmueble.getId()%>" />
                <input type="submit" value="Modificar" />
            </div>
        </form>
    </body>
</html>
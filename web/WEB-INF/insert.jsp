<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resources/style.css" media="screen" />
    </head>
    <body>
        <h1>Inmobiliaria</h1>
        <h3>Registrar nuevo inmueble</h3>
        <form action="control" method="POST">
            <div>
                <label>Localidad: </label><input type="text" name="localidad" value="" />
            </div>
            <div>
                <label>Direccion: </label><input type="text" name="direccion" value="" />
            </div>
            <div>
                <label>Tipo: </label><input type="text" name="tipo" value="" />
            </div>
            <div>
                <label>Precio: </label><input type="text" name="precio" value="" />
            </div>
            <div>
                <label>Usuario: </label><input type="text" name="usuario" value="" />
            </div>
            <div>
                <input type="hidden" name="target" value="inmueble" />
                <input type="hidden" name="op" value="insert" />
                <input type="hidden" name="action" value="op" />
                <input type="submit" value="Crear" />
            </div>
        </form>
    </body>
</html>
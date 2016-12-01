<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tlds/etiquetas.tld" prefix="e" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/css.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etiquetas personalizadas</title>
    </head>
    <body>
        <div>
            <table border="1">
                <tr style="background-color:green;color:white;"><th>Etiqueta</th><th>Descripcion</th><th>Ejemplo</th><th>Salida</th></tr>
                <tr><td>cesar</td><td>
                        <pre>Pasa cada letra a
codigo ascii
                        </pre></td><td>&lt;e:cesar cadena="Prueba" /&gt;</td><td><e:cesar cadena="Prueba" /></td></tr>
                <tr><td>suma</td><td>
                        <pre>Realiza la suma de dos numeros
                        </pre></td><td>&lt;e:suma numero1="4" numero2="5"/&gt;</td><td><e:suma numero1="4" numero2="5"/></td></tr>
                <tr><td>factorial</td><td>
                        <pre>Realiza el factorial
de un numero
                        </pre></td><td>&lt;e:factorial numero="5"/&gt;</td><td><e:factorial numero="5"/></td></tr>
                <tr><td>estaciones</td><td>
                        <pre>Muestra el color de la estacion
y el mes en el que estamos
                        </pre></td><td><pre>&lt;c:set var="tipo" value="invierno" /&gt;
&lt;c:set var="now" value="&lt;%=new java.util.Date()%&gt;" /&gt;
&lt;e:estaciones mes="&#36{tipo}"&gt;&lt;fmt:formatDate pattern="MMMM" value="&#36{now}" /&gt;
&lt;/e:estaciones&gt;</pre></td>
                    <td><c:set var="tipo" value="invierno" />
                        <c:set var="now" value="<%=new java.util.Date()%>" />
                        <e:estaciones mes="${tipo}"><fmt:formatDate pattern="MMMM" value="${now}" /></e:estaciones>
                    </td></tr>
                <tr><td>edades</td><td>
                        <pre>Muestra las generaciones
por colores
                        </pre></td><td><pre>&lt;c:set var="tipo" value="bebe,adolescente,joven,adulto,anciano" /&gt;
&lt;c:forTokens var="token" items="&#36{tipo}" delims=","&gt;
&lt;e:edades tipo="&#36{token}"&gt;&#36{token}&lt;/e:edades&gt;
&lt;/c:forTokens&gt;</pre></td>
                    <td>
                    <c:set var="tipo" value="bebe,adolescente,joven,adulto,anciano" />
                    <c:forTokens var="token" items="${tipo}" delims=",">
                        <e:edades tipo="${token}">${token}</e:edades>
                    </c:forTokens>

                    </tr>
            </table>
        </div>
    </body>
</html>

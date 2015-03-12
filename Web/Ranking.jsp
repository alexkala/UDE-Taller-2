<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='mensajes' scope='application' class='java.util.ArrayList' />  

<html>
  <head>
    <title> Mensajes recibidos </title>
  </head>

  <body bgcolor="#B7FFB7">
	<table border="5" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Mensajes recibidos hasta el momento </font></b>
			</td>
		</tr>
	</table> <br>

	 <table border="2" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
			<tr>
				<td><b> Autor </b></td>
				<td><b> Mensaje </b></td>
			</tr>
			<c:forEach items="${mensajes}" var="i" >
				<tr>
					<td> ${i.autor} </td>
					<td> ${i.mensaje} </td>
				</tr>
			</c:forEach>					
	</table>

	<p><a href='Mensaje.jsp'>Escribir otro mensaje</a></p>
	<p><a href='Resultados.jsp'>Actualizar resultados</a></p>
	<p><a href='Ingreso.jsp'>Volver al ingreso</a></p>
		
  </body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='Ranking' scope='application' class='java.util.ArrayList' />  

<html>
  <head>
    <title> Ranking </title>
  </head>

  <body bgcolor="#B7FFB7">
	<table border="5" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Ranking </font></b>
			</td>
		</tr>
	</table> <br>

	 <table border="2" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
			<tr>
				<td><b> Nombre </b></td>
				<td><b> Puntaje </b></td>
			
			</tr>
			<c:forEach items="${Ranking}" var="i" >
				<tr>
					<td> ${i.nombre} </td>
					<td> ${i.puntajeJugador} </td>
					
				</tr>
			</c:forEach>					
	</table>

	<p><a href='Ranking.jsp'>Actualizar Ranking</a></p>
	
		
  </body>
</html>
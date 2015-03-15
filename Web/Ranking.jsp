<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='Ranking' scope='application' class='java.util.ArrayList' />  

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
				<td><b> Jugador </b></td>
			
			</tr>
			<c:forEach items="${Ranking}" var="i" >
				<tr>
					<td> ${i.getNombre()} </td>
					
				</tr>
			</c:forEach>					
	</table>	
  </body>
</html>
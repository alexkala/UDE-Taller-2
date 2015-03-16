<jsp:useBean id='msgError' scope='request' class='java.lang.String' />  

<html>
  <head>
    <title>Mensaje de error</title>
  </head>
  <body bgcolor="#FCF8C2">
	<table border="5" width="50%" bordercolor="#FF8A8A" height="50" bgcolor="#FEE3BC">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Error </font></b>
			</td>
		</tr>
	</table>
	<p><b> ${msgError} </b></p>
	<p><a href='Ranking.jsp'>Volver al ranking</a></p>		
  </body>
</html>
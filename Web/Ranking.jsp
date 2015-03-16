<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='ranking' scope='application' class='java.util.ArrayList' />  

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>¡Adivina la película! | Ranking</title>
	    <link rel="stylesheet" href="http://localhost:8080/Web/style-taller.css">
	    <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
	</head>

	<header class="header">
		<div class="titulo">
	        <div class="align-center container">
	            <img src="http://localhost:8080/Web/imagenes/titulo.png" />
	        </div>
		</div>
	    <div class="subtitulo">
	        <div class="container">
	            <h1> Ranking </h1>
	        </div>
		</div>
	</header>

	<body id="body">
	
		<div class="align-center container">
			<table class="tabla">
	        	<tbody>
	                <tr class="tabla-header">
	                    <th>POSICIÓN</th>
	                    <th>NOMBRE</th>
	                    <th>PUNTOS</th>
	                    <th>ACIERTOS</th>
	                    <th>ERRORES</th>
	                </tr>
	                <c:forEach items="${Ranking}" var="jugador" varStatus="loop">
					<tr>
						<td> ${loop.index} </td>
						<td> ${jugador.nombre} </td>
						<td> ${jugador.puntajeJugador} </td>
						<td> ${jugador.cantAciertos} </td>
						<td> ${jugador.cantErrores} </td>				
					</tr>
					</c:forEach>					
				</tbody>
	        </table>
		</div>
		
	</body>
</html>
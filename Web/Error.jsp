<jsp:useBean id='msgError' scope='request' class='java.lang.String' />  

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>¡Adivina la película! | Error</title>
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
	            <h1> Error </h1>
	        </div>
		</div>
	</header>

	<body id="body">
	
		<div class="align-center container">
			<div class="error">
	  			<p> ${msgError} </p>
	        </div>
	        
	        <a class="button" href='Ranking'>Volver al ranking</a>
		</div>
		
		
			
	</body>
</html>
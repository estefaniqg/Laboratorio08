




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href="/CSS/bootstrap.min.css">
<link rel='stylesheet' href="/CSS/cargando.css">
<script type="text/javascript" src="/js/jQuery.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/profesor/eliminar.js"></script>

</head>
<body>
	<header> <nav class="navbar navbar-default ">
	<div class="navbar-header">
		<!-- Id navegacion  debe coincidir con el nombre id de abajo-->
		<button class="navbar-toggle" data-toggle="collapse"
			data-target="#navegacion">
			<!-- Mostrar en dispositivos de lectura que no reconocen los iconens-->
			<span class="sr-only">Mostrar Navegacion</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a href="/" class="navbar-brand">Inicio </a>
	</div>
	<div class="collapse navbar-collapse" id="navegacion">
		<!-- Fijar el atributo role-->
		<ul class="nav navbar-nav">
			<li><a href="/usuario/insertar">INSERTAR</a></li>
			<li class="active"><a href="">REGISTRO DE DATOS</a>
		</ul>
	</div>
	</nav> </header>

	<!--TABLA -->
	<div class="container-fluid">
		<h4>
			<b>Registro de Datos de Usuarios</b>
		</h4>
		<div class="table-responsive  ">
			<table class="table table-hover table-condensed">
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Rol</th>
					<th>Estado</th>

				</tr>
				
				<tr>
					<td>KRISTIAN JUAN</td>
					<td>CCAHUI HUAMAN</td>
					<td>kccahui@unsa.edu.pe</td>
					<td>Admin</td>
					<td>ACTIVO</td>

					<td class='btn btn-group'><a
						href="/usuario/modificar?codigo=5732568548769792"
						class="btn btn-primary btn-sm">Modificar</a> <a
						href="/usuario/eliminar?codigo=5732568548769792"
						class="btn btn-danger btn-sm">Eliminar</a></td>
				</tr>
				
				<tr>
					<td>Bryan</td>
					<td>Apellido</td>
					<td>acheje@unsa.edu.pe</td>
					<td>Admin</td>
					<td>ACTIVO</td>

					<td class='btn btn-group'><a
						href="/usuario/modificar?codigo=5769015641243648"
						class="btn btn-primary btn-sm">Modificar</a> <a
						href="/usuario/eliminar?codigo=5769015641243648"
						class="btn btn-danger btn-sm">Eliminar</a></td>
				</tr>
				

			</table>
			<div class="text-center">
				<a href="/usuario" class="btn btn-success">ACTUALIZAR</a> <br>
			</div>

		</div>

	</div>
</body>
</html>
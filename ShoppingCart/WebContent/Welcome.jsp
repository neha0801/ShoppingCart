<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Store</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
h1 {
	text-align: center;
	color: black;
	font-size: 80px;
	font-family: "Edwardian Script ITC";
}

body {
	font-family: "Edwardian Script ITC";
	color: black;
	background-image: url('tiffany.jpg');
	background-size:cover;
	font-size: 30px;
}

nav {
	font-family: "Edwardian Script ITC";
	color: red;
}
  .panel-transparent {
        background: none;
    }
</style>
</head>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-brand">EvilCorp-Gulp Web Store</div>
	<div>
		<ul class="nav navbar-nav">
			<li><a href="#" style="color: white"><b>Home</b></a></li>
		</ul>
	</div>
</div>
</nav>
<body>
<br>
<br>
	<h1>
		<b>Explore Watches</b>
	</h1>
	<br>
	<br>

	<div class="panel-group col-sm-6 col-sm-offset-3" style=width:50%>
		<div class="panel panel-default">
			<div class="panel-body">
				<form action="ExploreProducts" method=post>
					<label>Email Address:</label> <input type="text"
						name="email"></input><br></br> <input type="submit"
						class="btn pull-left btn-primary btn-lg" value="Explore"></input><br></br>
				</form>
			</div>
		</div>


	</div>

</body>
</html>
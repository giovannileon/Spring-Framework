<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME SPRING MVC</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/app.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>

	<div lass="container-fluid">
		<div class="row-fluid">
			<div class="span4">

				<div class="row-fluid">
					<div class="span10 offset1">
						<h2>Pagina de Login</h2>
					</div>
				</div>
				<form method="POST" action="login">
					<div class="row-fluid">
						<div class="span3 offset1">Usuario</div>
					</div>
					<div class="row-fluid">
						<div class="span3 offset1">
							<input type="text" name="username">
						</div>
					</div>
					<div class="row-fluid">
						<div class="span3 offset1">Password</div>
					</div>
					<div class="row-fluid">
						<div class="span3 offset1">
							<input type="text" name="password">
						</div>
					</div>
					<div class="row-fluid">
						<div class="span3 offset1">
							<input type="submit" value="Enviar">
						</div>
					</div>
				</form>
			</div>
			<div class="span8">
				<div class="row-fluid">
					<div class="span10 offset1">
						<h2>Ejemplo de Parrafos</h2>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span10 offset1">											
					
						<pre> &lt;p&gt;Sample text here...&lt;/p&gt; <br> LOL </pre>
						
						<p>Nullam quis risus eget urna mollis ornare vel eu
							leo. Cum sociis natoque penatibus et magnis dis parturient
							montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies
							elit.</p>

						<p class="lead">Nullam quis risus eget urna mollis ornare vel.</p>

						<p class="">
							<small>Nullam quis risus eget urna mollis ornare vel</small>
						</p>

						<p class="">
							<strong>Nullam quis risus eget urna mollis ornare vel</strong>
						</p>

						<p class="">
							<em>Nullam quis risus eget urna mollis ornare vel</em>
						</p>
					</div>
				</div>

			</div>
		</div>
		<div class="row-fluid">
			<div class="span5">
				<div class="row-fluid">
					<div class="span10 offset1">
						<h3>Textos de Color</h3>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span10 offset1">
						<p class="muted">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
						<p class="text-warning">Etiam porta sem malesuada magna mollis euismod.</p>
						<p class="text-error">Donec ullamcorper nulla non metus auctor fringilla.</p>
						<p class="text-info">Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis.</p>
						<p class="text-success">Duis mollis, est non commodo luctus, nisi erat porttitor ligula.</p>
						An abbreviation of the word attribute is <abbr title="attribute">attr</abbr>
						<br>	
						<abbr title="HyperText Markup Language" class="initialism">HTML</abbr> is the best thing since sliced bread.
						<hr/>
						<address>
						  <strong>Twitter, Inc.</strong><br>
						  795 Folsom Ave, Suite 600<br>
						  San Francisco, CA 94107<br>
						  <abbr title="Phone">P:</abbr> (123) 456-7890
						</address>
						 
						<address>
						  <strong>Full Name</strong><br>
						  <a href="mailto:#">first.last@example.com</a>
						</address>
						
					</div>
				</div>
			</div>
			<div class="span7">
				<div class="row-fluid">
					<div class="span10 offset1">
						<h3>Mas ejemplos de boostrap</h3>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span10 offset1">
						<blockquote>San Francisco, CA 94107</blockquote>
						<blockquote>
						  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
						  <small>Someone famous <cite title="Source Title">Source Title</cite></small>
						</blockquote>
						<blockquote class="pull-right">
						  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
						  <small>Someone famous <cite title="Source Title">Source Title</cite></small>
						</blockquote>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span10 offset1">
						<ul class="inline">
						  <li>LOL</li>
						  <li>LOL</li>						  
						  <li>LOL</li>
						</ul>
						
						<code>
							$(document).ready(function(){})
						</code>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
$(function(){
	//alert("lol");
	
	$('form').submit(function(e){
		
		e.preventDefault();
		// forma = $(this).serialize();
		var datos = {username : "gera", password: "123"};
		$.post("login", datos, function(data){
			alert(data)
			console.log(data)
		})
		
	})
	
})
<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,oggetti.Cliente"%>

<%
	Cliente cliente = (Cliente) session.getAttribute("cliente");
	Integer errore = (Integer) request.getAttribute("errore");
	if (cliente != null) {
		response.sendRedirect("AreaRiservata.jsp");
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script src="script/validation.js" type="text/javascript"></script>
<style type="text/css">
@import url("css/registrazione.css");
</style>

<title>LOGIN SU AMERICAN !</title>


<script type="text/javascript">
	$(document).ready(function() {
		$("li.login").css({
			"background-color" : "rgba(	160,82,45, 0.6)"
		});

	});
</script>

<script>
    $(document).ready(function(){
    	$(".logAd").hide();
    	$(".admin").click(function(){
    		$(".logAd").show();
    		$("#close").click(function(){
    			$(".logAd").hide();
    			})
    		})
    	})
</script>


</head>
<body>
<%@ include file="LogAdmin.jsp"%>
	<%	if (cliente == null) {%>
	<%@ include file="menu.html"%>
	<%	}%>

	<%if (cliente != null) {%>
	<%@ include file="menuLogged.html"%>
	<%}%>





	<div class="body">

		<br>

		<script>
			$("p.erroreusername").css({
				"display" : "none"
			});
			$("p.errorepass").css({
				"display" : "none"
			});
		</script>

		<br>
		<p class="errorepass">PASSWORD ERRATA</p>
		<p class="erroreusername">USERNAME INESISTENTE</p>

		<%
			if (errore != null && errore == 2) {
		%>

		<script>
			$("p.errorepass").css({
				"display" : "inherit"
			});
			$("p.erroreusername").css({
				"display" : "none"
			});
		</script>
		<%
			}
		%>

		<%
			if (errore != null && errore == 1) {
		%>
		<script>
			$("p.erroreusername").css({
				"display" : "inherit"
			});
			$("p.errorepass").css({
				"display" : "none"
			});
		</script>
		<%
			}
		%>



		<br>

		<div class="form">

			<div class="log">
				<p class="nolog">Effettua Il Login !</p>
				<br>
				<form name="reg" id="login" method="post" onsubmit="return validazione2()" action="ClienteLogin">
					<p id="mu">&nbsp;</p>
					
					Username: <input type="text" name="username" onblur="valUsername()">*
					
					<br>
					<br>
					
					<p id="mp">&nbsp;</p>
					Password: <input type="password" name="password" onblur="valPassword()">* 
					
					<br>
					<br> 
					
					<a href="#" class="admin">
					  <img src="css/img/Adm.png" alt="HOME" height="45" width="45">
					</a>
					
					<input class="invia" type="submit" value="invia">
				</form>

			</div>
			
			<div class="reg">
				<p class="nolog">
					Non Sei Ancora Registrato? <br> Cosa Aspetti Registrati
				</p>
				<br>
				<br> <a class="reglink" href="Registrazione.jsp">REGISTRATI</a>
			</div>
		</div>



	</div>
	<%@ include file="footer.html"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css">
</head>
<body>
	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>

						<form name="myForm" method="post" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your username" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="Password" />
							</div>
							<div>
								Please select your Branch Name: <br/>
								<select name="branchName" class="form-select" aria-label=".form-select-lg example" required="required">
								<option value="-1">Select Branch</option>
									<option>Colombo</option>
									<option>Jaffna</option>
									<option>Galle</option>
									<option>Kandy</option>
									<option>Gampaha</option>
									<option>Nugegoda</option>
								</select>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" onClick="return onValidate();" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>
      

	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "success") {
			swal("Congrats", "Account created successfully", "success");
		} else if (status == "error") {
			swal("Oops", "The username has already been taken", "error");
		} else if (status == "failed") {
			swal("Oops", "Registration failed", "error");
		}
	</script>
	<script type="text/javascript">
	function onValidate(){
		var uname = document.myForm.name.value;
		if(uname==""){
			alert("Please enter username");
			document.myForm.name.focus();
			return false;
		}
		
		var email = document.myForm.email.value;
		if(email=""){
			alert("Please enter an email address");
			document.myForm.email.focus();
			return false;
		}
		
		var password = document.myForm.pass.value;
		if(password==""){
			alert("Please enter password");
			document.myForm.pass.focus();
			return false;
		}
		
		var branch = document.myForm.branchName.value;
		if( branch=="-1"){
			alert("Please choose a branch");
			document.myForm.branchName.focus();
			return false;
		}
	}
	</script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
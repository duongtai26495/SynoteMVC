const open_register = () =>{
	var signupPanel = document.getElementById("register-panel");
	var signinPanel = document.getElementById("login-panel");
	
	signupPanel.style.right = "0";
	signinPanel.style.right = "-100%"
}

const open_login = () =>{
    var signupPanel = document.getElementById("register-panel");
	var signinPanel = document.getElementById("login-panel");
	
	signupPanel.style.right = "-100%";
	signinPanel.style.right = "0"
}

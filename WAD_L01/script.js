let form = document.getElementById('form');
console.log(form);

//form.onsubmit(ValidateForm());

var func = function(event) {
	event.preventDefault();
	
	console.log("hello");
	var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	let email = document.getElementById('email');
	console.log(email);
	console.log(validRegex.test(email.value));
	if(!validRegex.test(email.value)) {
		alert("Invalid email address")
		email.focus();
	}
	console.log("hello");
	let pass = document.getElementById('password').value;
	let confirm_pass = document.getElementById('password_repeat').value;
	
	if(pass != confirm_pass){
		alert("Invalid Password");
		document.getElementById('password').value = '';
		document.getElementById('password_repeat').value = '';
	}

	let phone = document.getElementById("phone");
	var phoneRegex = /^\+\d{11}$/;
	if(!phoneRegex.test(phone.value)) {
		alert("invalid phone number")
	}
};

form.addEventListener("submit", func, true);
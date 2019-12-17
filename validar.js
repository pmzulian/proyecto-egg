function validar(){
	var nombre, apellido, email, dni, contraseña, telefono, expresion;
	nombre = document.getElementById("nombre").value;
	apellido = document.getElementById("apellido").value;
	email = document.getElementById("email").value;
	dni = document.getElementById("dni").value;
	contraseña = document.getElementById("contraseña").value;
	telefono = document.getElementById("telefono").value;

	expresion = /\w+@\w+\.*[a-z]/;

if(nombre === "" || apellido === "" || email === "" || dni === "" || contraseña === "" || telefono === ""){
	alert("Todos los campos son obligatorios")
	return false;
}
else if(nombre.length>20) {
alert("El nombre es muy largo");
return false;
}
else if(apellido.length>20) {
alert("El apellido es muy largo");
return false;
}
else if(email.length>40) {
alert("El email es muy largo");
return false;
}
else if(!expresion.test(email)) {
alert("El email no es valido");
return false;
}
else if(dni.length>10) {
alert("El dni no puede tener mas de 10 caracteres");
return false;
}
else if(contraseña.length<6) {
alert("La contraseña no puede tener menos de 6 caracteres");
return false;
}
else if(telefono.length>20) {
alert("El telefono no puede tener mas de 20 numeros");
return false;
}
else if(telefono.length<6) {
alert("El telefono no puede tener menos de 6 numeros");
return false;
}
else if(isNan(telefono)) {
alert("El telefono ingresado no es un numero");
return false;
}

}
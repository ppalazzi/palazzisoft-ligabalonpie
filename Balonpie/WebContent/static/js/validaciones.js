function validarDatos(formulario) {
	if (formulario.name.value == '') {
		alert("Debe completar el campo Nombre de Usuario");
		return false;
	}
	if (formulario.email.value == '') {
		alert("Debe completar el campo contraseña");
		return false;
	}	

	return true;
}
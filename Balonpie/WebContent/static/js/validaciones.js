function validarDatos(formulario) {
	if (formulario.name.value == '') {		
		var divMen = document.getElementById("mensaje");
		divMen.innerHTML = "Complete el campo Usuario";
		return false;
	}
	if (formulario.email.value == '') {
		var divMen = document.getElementById("mensaje");
		divMen.innerHTML = "Complete el campo Contrase�a";
		return false;
	}	

	return true;
}

function validarEntero(valor){
   valor = parseInt(valor);

    //Compruebo si es un valor num�rico
    if (isNaN(valor)) {
          //entonces (no es numero) devuelvo el valor cadena vacia
          return "";
    }else{
          //En caso contrario (Si era un n�mero) devuelvo el valor
          return valor;
    }
} 
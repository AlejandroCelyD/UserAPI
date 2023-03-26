const ventGastos = document.getElementById('contVentRegistrar')

function registrar(){
    swal("Write something here:", {
        content: "input",
      })
      .then((value) => {
        swal(`You typed: ${value}`);
      });
}

function cerrarVentRegistro(){
    ventGastos.style.visibility = 'hidden';
    ventGastos.style.opacity = '0';
    ventGastos.style.transition = 'all 1s';
}

function abrirVentanaRegistro(){
    ventGastos.style.visibility = 'visible';
    ventGastos.style.opacity = '1';
    ventGastos.style.transition = "all 1s";
}

function cambiarNombre(usuario){
    document.getElementById('userName').innerHTML = 'usuario'
}
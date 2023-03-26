const txt = document.getElementById('gastoSeleccionado')
const ventGastos = document.getElementById('edicionGastos')

function seleccionarGasto(){
    let selectorGastos = document.getElementById('selectorGastos')
    let gasto = selectorGastos.value

    document.getElementById('gastoSeleccionado').innerText= `Gasto seleccionado: ${gasto}`
    txt.value = gasto;
}

function actualizarValor(){
    document.getElementById(txt.value).textContent = `${document.getElementById('valorGasto').value}`
}

function cerrarVent(){
    ventGastos.style.visibility = 'hidden';
    ventGastos.style.opacity = '0';
    ventGastos.style.transition = 'all 1s';
}

function abrirVentanaCambio(){
    ventGastos.style.visibility = 'visible';
    ventGastos.style.opacity = '1';
    ventGastos.style.transition = "all 1s";
}
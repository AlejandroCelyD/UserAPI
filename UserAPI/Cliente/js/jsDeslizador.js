const arregloMetas = [
    ["celular","celularSelector","totalMetaCel","progresoCelular"],
    ["portatil","portatilSelector","totalMetaPor","progresoPortatil"],
    ["viaje","viajeSelector","totalMetaVia","progresoViaje"],
    ["moto","motoSelector","totalMetaMoto","progresoMoto"]
]

function modificadorBarra(){
deslizador.oninput = function(){
    valorSeleccionado.innerHTML = `${this.value}`;
    selector.style.left = this.value/(this.max/100) + "%";
    progreso.style.width = this.value/(this.max/100) + "%";
    document.getElementById("barraTotal").style.width = ((tomarTotalAcumulado()*100))/tomarTotalGlobal() + "%";
    cambiarAhorrado();
}
}

function cualquierCosa(indiceMeta){
deslizador = document.getElementById(arregloMetas[indiceMeta][0]);
selector = document.getElementById(arregloMetas[indiceMeta][1]);
valorSeleccionado = document.getElementById(arregloMetas[indiceMeta][2]);
progreso = document.getElementById(arregloMetas[indiceMeta][3]);
modificadorBarra()
}

function tomarTotalAcumulado(){
var totalGastos = 0;

for(var i=0; i<arregloMetas.length; i++){
    totalGastos += parseInt(document.getElementById(arregloMetas[i][2]).textContent)
}

return totalGastos;
}

function tomarTotalGlobal(){
var valorTotal = 0;

for(var i=0; i<arregloMetas.length; i++){
    valorTotal += parseInt(document.getElementById(arregloMetas[i][0]).max)
}

return valorTotal;
}

function cambiarAhorrado(){
document.getElementById("saldoAhorrado").innerHTML = tomarTotalAcumulado();
}
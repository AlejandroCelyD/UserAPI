const cartera = document.getElementById("iconCartera");
const tarCartera = document.getElementById("tarjetaGastos");

const metas = document.getElementById("iconMetas");
const tarMetas = document.getElementById("tarjetaMetas");

const estadisticas = document.getElementById("iconEstadisticas");
const tarEstadistica = document.getElementById("tarEstadisticas");

const confi = document.getElementById("iconConfiguracion");
const tarConfi = document.getElementById("tarjetaConfiguracion");





const coCuPe = document.getElementById("conPerfil");
const tacoCuPe = document.getElementById("contCuentaPerf");

const coCuConf = document.getElementById("conConfi");
const tacoCuConf = document.getElementById("contCuentaConf");

const coCuAy = document.getElementById("conAyuda");
const tacoCuAy = document.getElementById("contCuentaAyuda");

(() => {
    click(cartera, tarCartera);
    click(metas, tarMetas);
    click(estadisticas, tarEstadistica);
    click(confi, tarConfi);


    clickCuenta(coCuPe,tacoCuPe);
    clickCuenta(coCuConf,tacoCuConf);
    clickCuenta(coCuAy,tacoCuAy);
})();

function colapsar(tar){
    tar.style.visibility = 'hidden';
    tar.style.opacity = '0';
}

function aparecer(tarjeta){
    tarjeta.style.visibility = 'visible';
    tarjeta.style.opacity = '1';
    tarjeta.style.transition = "all 1s";
}


function colapsarTarjeta() {
    colapsar(tarCartera);
    colapsar(tarMetas);
    colapsar(tarEstadistica);
    colapsar(tarConfi);
}

function colapsarContCuenta(){
    colapsar(tacoCuPe);
    colapsar(tacoCuConf);
    colapsar(tacoCuAy);
}



function click(icon, tarjeta) {
    icon.addEventListener('click', () => {
        colapsarTarjeta();
        aparecer(tarjeta);
    }, false)
}

function clickCuenta (icon, tarjeta) {
    icon.addEventListener('click', () => {
        colapsarContCuenta();
        aparecer(tarjeta);
    }, false)
}
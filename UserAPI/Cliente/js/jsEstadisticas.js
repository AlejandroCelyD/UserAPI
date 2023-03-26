let miGrafica;
let miGrafica2;

Chart.defaults.font.size = "20%";


/*-------------------------GRAFICA 1-------------------------*/
var arregloHogar = [
    document.getElementById("Servicios").textContent,
    document.getElementById("Internet").textContent,
    document.getElementById("Comida").textContent,
    document.getElementById("Aseo").textContent
]

var arregloPersonal = [
    document.getElementById("Transporte").textContent,
    document.getElementById("Ropa").textContent,
    document.getElementById("Cuidado").textContent
]

var arregloExtras = [
    document.getElementById('Mascota').textContent,
    document.getElementById('Salidas').textContent
]

function actualizarValores(){

    
    arregloHogar = [
        document.getElementById("Servicios").textContent,
        document.getElementById("Internet").textContent,
        document.getElementById("Comida").textContent,
        document.getElementById("Aseo").textContent
    ]
    
    arregloPersonal = [
        document.getElementById("Transporte").textContent,
        document.getElementById("Ropa").textContent,
        document.getElementById("Cuidado").textContent
    ]
    
    arregloExtras = [
        document.getElementById('Mascota').textContent,
        document.getElementById('Salidas').textContent
    ]

    
}

function sumaGastos(arreglo){
    let suma = 0;
    for(let i=0; i<arreglo.length; i++){
        suma += parseInt(arreglo[i])
    }

    return suma;
}

function graficar(){

    var graficaUno = document.getElementById("grafica1").getContext("2d");
    var graficaDos = document.getElementById("grafica2").getContext("2d");

    if(miGrafica){
        miGrafica.clear();
        miGrafica.destroy();
    }
    if(miGrafica2){
        miGrafica2.clear();
        miGrafica2.destroy();
    }

    miGrafica = new Chart(graficaUno, {
        type: 'doughnut',
        
        data: {
            labels: ['Extras', 'Hogar', 'Personal'],
            datasets: [{
                label: '# of Votes',
                data: [sumaGastos(arregloExtras), sumaGastos(arregloHogar), sumaGastos(arregloPersonal)],
                backgroundColor: [
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(127, 245, 235, 0.3)',
                    'rgba(255, 99, 132, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 206, 86, 1)',
                    'rgb(127, 245, 235)',
                    'rgba(255, 99, 132, 1)'
                ],
                borderWidth: 1
            }]
        },
    })

    /*-------------------------GRAFICA 2-------------------------*/

    miGrafica2 = new Chart(graficaDos, {
        type: 'bar',
        
        data: {
            labels: [''],
            datasets: [{
                label: 'Extras',
                data: [sumaGastos(arregloExtras)],
                backgroundColor: [
                    'rgba(255, 206, 86, 0.2)',
                ],
                borderColor: [
                    'rgba(255, 206, 86, 1)',
                ],
                borderWidth: 1
            },
            {
                label: 'Hogar',
                data: [sumaGastos(arregloHogar)],
                backgroundColor: [
                    'rgba(127, 245, 235, 0.3)',
                ],
                borderColor: [
                    'rgb(127, 245, 235)',
                ],
                borderWidth: 1
            },
            {
                label: 'Personal',
                data: [sumaGastos(arregloPersonal)],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                ],
                borderWidth: 1
            }]
            
        },
    })
}
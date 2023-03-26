'use strict'

const divGrande = document.querySelector('.divGrande');
const punto = document.querySelectorAll('.punto');

//Asignar click a los puntos

punto.forEach((cadaPunto, i) => {
    punto[i].addEventListener('click', () => {
        let posicion = i;
        let operacion = posicion * -50;

        divGrande.style.transform = `translateX(${operacion}%)`;

        punto.forEach((cadaPunto, i) => {
            punto[i].classList.remove('activo');
        })
        punto[i].classList.add('activo');
    })
})
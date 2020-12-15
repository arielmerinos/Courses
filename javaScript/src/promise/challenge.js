const fetchData = require('../utils/fetchData');

let API = 'https://rickandmortyapi.com/api/character/';

fetchData(API)
    .then(respuesta => {
        console.log(respuesta.info.count);
        return fetchData(`${API}${respuesta.results[0].id}`)
    })
    .then(nombre => {
        console.log(nombre.name)
        return fetchData(nombre.origin.url)
    })
    .then(cosa => {
        console.log(cosa.name)
    })
    .catch(error => console.error(error));
        
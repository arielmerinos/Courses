let XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;

let API = 'https://rickandmortyapi.com/api/character/';

function fetchData(url, callback){
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', url);
    xhttp.onreadystatechange = function (event){
        if(xhttp.readyState === 4){
            if(xhttp.status === 200){
                callback(null, JSON.parse(xhttp.responseText));
            }else{
                const error = new Error('Error puta ' + url);
                return callback(error, null)
            }
        }
    }
    xhttp.send();
}
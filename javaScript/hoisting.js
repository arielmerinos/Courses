// Cuando las variables 
var juega = function(eleccion, maquina){
    if(eleccion === maquina){
        console.log("Es un empate")
    }

    if(eleccion === "piedra"){
        if( maquina === "papel"){
            console.log("ganaste")
        }
        if(maquina === "tijera"){
            consolel.log("ganaste")
        }
    }
    if(eleccion === "papel"){
        if(maquina== "piedra"){
            console.log("perdiste")
        } 
        if(maquina === "tijera"){
            console.log("perdiste")
        }
    }

    if(eleccion == "tijera"){
        if( maquina === "papel"){
            console.log("ganaste")
        }
        if(maquina== "piedra"){
            console.log("perdiste")
        } 
    }
}

switch(eleccion){
    case: 
}


var auto = function(marca, modelo, annio){
    this.annio = annio;
    this.modelo = modelo;
    this.marca = marca;
}

var autos = []
for(var i = 0; i < 30; i++){
    autos.push(auto("Testa", "Model X", "${2000} + i"))
}

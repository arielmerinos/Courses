
const anotherFunction = () =>{
    for (var i = 0; i < 10; i++){
        setTimeout( () =>{
            console.log(i)
        } ), 3000
    }
};

anotherFunction()
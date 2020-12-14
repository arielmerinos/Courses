const fruits = () => {
    if(true){
        var fruit1 = 'Manzanitaaa'
        let fruit2 = 'Pepino'
        const fruit3 = 'Kiwi'
    }else{

    }

    console.log(fruit1)
    console.log(fruit2)
    console.log(fruit3)
}
fruits()


const x = 1;
{
    const x = 2
    console.log(x)
}
console.log(x)

const anotherFunction = () =>{
    for (var i = 0; i < 10; i++){
        setTimeout( () =>{
            console.log(i)
        } ), 3000
    }
};

anotherFunction()

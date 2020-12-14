const buildCount = i =>{
    let count = i
    const displayCount = ()=>{
        console.log(count++)
    };
    return displayCount;
}

let myContador = buildCount(5);

myContador()
myContador()
myContador()

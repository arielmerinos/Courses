const doSomethingAsync = () =>{
    return new Promise((resolve, reject)=>{
        if(true){
            setTimeout(()=>{
                resolve('Esto sí está siendo lo q uno se espera')
            }, 5000)
        }else{
            reject(new Error('Ola puta '));
        }
    })
}

const doSomething = async ()=>{
    console.log('A ver puta ')
    const something = await doSomethingAsync()
    console.log(something)
    console.log('temblaste puta?? ')
}


console.log('Before ')
doSomething();
console.log('after ')


const anotherFoo = async ()=>{
    try {
        const someTime = await doSomethingAsync();
        console.log(someTime)
    } catch (error) {
        console.error(error)
    }
}

console.log('Before 1 ')
anotherFoo();
console.log('after 1')
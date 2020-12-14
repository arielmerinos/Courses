const helloWordl = () =>{
    var hello = 'Holi mundo'
    console.log(hello)
}

helloWordl()
console.log(hello)

var scope = 'Soy globalita'

const scopeFunction = () => {
    var scope = 'Soy lokalita'
    const fun = () => {
        return scope
    }
    console.log(fun())
}
scopeFunction()

console.log(scope)
const person = () =>{
    var nombre = 'ariel'
    return{
        getName: () =>{
            return nombre
        },
        setName: (name_) =>{
            nombre = name_
        }
    }
}

let personita = person()
console.log(personita.getName())
personita.setName('OMg?')
console.log(personita.getName())
const somethingWillHappen = () =>{
    return new Promise((resolve, reject) =>{
        if(true){
            resolve('We did it!!!');
        }else{
            reject('Chalesito');
        }
    });
};

somethingWillHappen()
    .then(respuesta => console.log(respuesta))
    .catch(errori => console.log(errori))


const maybeHappen = () =>{
    return new Promise((resolve, reject) =>{
        if(true){
            setTimeout(() =>{
                resolve('Ay sí puta')
            }, 2000)
        }else{
            const error = new Error('Ay pendeja')
            reject(error);
        }
    });
};

maybeHappen()
    .then(respuesta => console.log(respuesta))
    .catch(erros => console.log(erros))

Promise.all([somethingWillHappen(), maybeHappen()])
    .then(respuesta => {
        console.log('Arreglo de respuestas', respuesta)
    })
    .catch(error => console.error(error))
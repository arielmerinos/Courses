const fetchData = require('../utils/fetchData');
const API = 'https://rickandmortyapi.com/api/character/';

const anotherFunct = async (url)=>{
    try {
        const generalData = await fetchData(url)
        const character = await fetchData(`${API}${generalData.results[0].id}`)
        const origin = await fetchData(character.origin.url)

        console.log(generalData.info.count)
        console.log(character.name)
        console.log(origin.dimension)
    } catch (error) {
        console.error(error)
    }
}

console.log('Before ')

anotherFunct(API)
console.log('After')
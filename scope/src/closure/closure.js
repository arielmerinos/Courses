
const moneyBox = () =>{
    var saveCoins = 0;
    const countCoins = (coins) =>{
        saveCoins += coins
        console.log(`Dinerita: $${saveCoins}`)
    }
    return countCoins;
}

let myMoneyBox = moneyBox();

myMoneyBox(5)
myMoneyBox(5)
myMoneyBox(5)


// Comibina una función y el ámbito léxico donde fue asignada
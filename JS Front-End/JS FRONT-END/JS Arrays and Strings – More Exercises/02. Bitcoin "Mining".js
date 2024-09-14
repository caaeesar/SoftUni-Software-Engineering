function solve(amountOfGold) {
  const bitcoin = 11949.16;
  const gramGold = 67.51;
  let totalMoney = 0;
  let boughtBitcoins = 0;
  let day = 0;
  let message = "";
  let isFirstBitcoin = false;

  for (let gold of amountOfGold) {
    day++;
    if (day === 3) {
      gold -= gold * 0.3;
    }
    totalMoney += gold * gramGold;

    if (totalMoney >= bitcoin) {
      let count = totalMoney / bitcoin;
      boughtBitcoins += parseInt(count);
      totalMoney -= bitcoin * parseInt(count);
      if (!isFirstBitcoin && boughtBitcoins != 0) {
        let dayOfFirstBitcoin = day;
        isFirstBitcoin = true;
        message = `Day of the first purchased bitcoin: ${dayOfFirstBitcoin}`;
      }
    }
  }
  console.log(`Bought bitcoins: ${parseInt(boughtBitcoins)}`);
  if (message !== "") {
    console.log(message);
  }

  console.log(`Left money: ${totalMoney.toFixed(2)} lv.`);
}

//solve([3124.15, 504.212, 2511.124]);
solve([100, 200, 300]);

function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   let inputTextArea = document.querySelector('#inputs textarea');
   let bestRestaurantEl = document.querySelector('#outputs #bestRestaurant p');
   let workersEl = document.querySelector('#outputs #workers p');

   function onClick () {
     
      let restaurants = JSON.parse(inputTextArea.value).map((data) => {
         let [restaurantName, workersData] = data.split(' - ');

         let workers = workersData.split(', ').map((workerData) => {
            let [name, salary] = workerData.split(' ');
            return {
               name,
               salary: Number(salary)
            }
         })

         return {
            restaurantName,
            workers: workersData
         }
      });
     

      
   }
}

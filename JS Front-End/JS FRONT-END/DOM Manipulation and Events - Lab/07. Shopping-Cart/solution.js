function solve() {
   let resultElement = document.querySelector('textarea[disabled]');
   let checkoutButton = document.querySelector('.checkout');
   const productContainer = document.querySelector('.shopping-cart');

   let cart = new Set();
   let products = [];

   productContainer.addEventListener('click', (e) => {
       if (e.target.tagName !== 'BUTTON' || e.target.textContent.trim() !== 'Add') {
           return;
       }

       let productElement = e.target.closest('.product');
       let name = productElement.querySelector('.product-title').textContent;
       let price = parseFloat(productElement.querySelector('.product-line-price').textContent).toFixed(2);

       resultElement.value += `Added ${name} for ${price} to the cart.\n`;

       cart.add(name);

       products.push(
         { 
            name, 
            price: parseFloat(price) 
         }
      ); 
   });

   checkoutButton.addEventListener('click', () => {
       let totalPrice = products.reduce((sum, product) => sum + product.price, 0).toFixed(2);

       let productList = Array.from(cart).join(', ');

       resultElement.value += `You bought ${productList} for ${totalPrice}.`;

       
       productContainer.querySelectorAll('.add-product').forEach((button) => button.disabled = true);

       
       checkoutButton.disabled = true;
   });
}


export function cartFactory(product) {
    const cartBody = document.querySelector('#modal-root')
    console.log("itt")
    console.table(product)
    let content = createBlock(product);
    cartBody.insertAdjacentHTML('beforeend', content)

    //sumPrice(product.moviePrice)
    //document.querySelector('#quantity').addEventListener("click", () =>
      //  sumPrice(product.moviePrice)
    //)
}

function createBlock({movieName, movieId, moviePrice, quantity, badge}) {
    document.querySelector('#place-holder').innerHTML = "";
    if (quantity === undefined) {
        quantity = 1;
    }
    return `   
          <div data-product-id="${movieId}" class="product-box">
            <img src="static/img/product_${movieId}.jpg" alt="">
            <div class="name-box">
              <p data-name="${movieName}" class="mb-2 name">${movieName}</p>
            </div>
            <input data-quantity="${quantity}" id="quantity" type="number" class="quantity" value="${quantity}">
            <p id="price" data-price="${moviePrice}" class="mb-0" style="font-weight: 500;">${moviePrice} USD</p>
          </div>
          `
}

function sumPrice(price) {
    const total = document.querySelector('#total-price');
    const quantity = document.querySelector('#quantity').value;
    total.textContent = (parseFloat(price) * quantity).toString() + " USD";
}


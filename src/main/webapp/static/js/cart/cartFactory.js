export function cartFactory(product) {
    const cartBody = document.querySelector('#modal-root')
    for (let i = 0; i < window.localStorage.length; i++) {
        let content = createBlock(JSON.parse(window.localStorage.getItem(localStorage.key(i))));
        cartBody.insertAdjacentHTML('beforeend', content)
    }
    sumPrice(product.price)
    document.querySelector('#quantity').addEventListener("click", () =>
        sumPrice(product.price)
    )
}

function createBlock({name, price, id, quantity}) {
    document.querySelector('#place-holder').innerHTML = "";
    if (quantity === undefined) {
        quantity = 1;
    }
    return `   
          <div data-product-id="${id}" class="product-box">
            <img src="static/img/product_${id}.jpg" alt="">
            <div class="name-box">
              <p data-name="${name}" class="mb-2 name">${name}</p>
            </div>
            <input data-quantity="${quantity}" id="quantity" type="number" class="quantity" value="${quantity}">
            <p id="price" data-price="${price}" class="mb-0" style="font-weight: 500;">${price} USD</p>
          </div>
          `
}

function sumPrice(price) {
    const total = document.querySelector('#total-price');
    const quantity = document.querySelector('#quantity').value;
    total.textContent = (parseFloat(price) * quantity).toString() + " USD";
}


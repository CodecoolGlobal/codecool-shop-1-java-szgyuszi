export function cartFactory({name, price, id}) {
    const tbody = document.querySelector('#modal-root')
    let content = createBlock(name, price, id)
    tbody.insertAdjacentHTML('beforeend', content)
    document.querySelector('#quantity').addEventListener("click", () => {
        sumPrice(price)
    })
}

function createBlock(name, price, id) {
    return `   
          <div data-product.id="${id}" class="product-box">
            <img src="static/img/product_${id}.jpg" alt="">
            <div class="name-box">
              <p class="mb-2">${name}</p>
            </div>
            <input id="quantity" type="number" class="quantity" value="1">
            <p id="price" data-price="${price}" class="mb-0" style="font-weight: 500;">${price} USD</p>
          </div>
          `
}

function sumPrice(price) {
    const total = document.querySelector('#total-price');
    const quantity = document.querySelector('#quantity').value;
    total.textContent = (parseFloat(price) * quantity).toString() + " USD";
}


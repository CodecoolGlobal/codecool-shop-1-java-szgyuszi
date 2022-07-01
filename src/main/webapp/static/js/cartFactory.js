export function cartFactory({name, price, id}) {
    const tbody = document.querySelector('#table-root')
    let content = createBlock(name, price, id)
    tbody.insertAdjacentHTML('beforeend', content)
    document.querySelector('#quantity').addEventListener("click", ()=>{
        sumPrice(price)
    })
}

function createBlock(name, price, id) {
    return `<tr>
                <th scope="row">
                  <div class="product-box">
                    <img src="static/img/product_${id}.jpg" class="img-fluid rounded-3"
                      style="width: 120px;" alt="">
                    <div class="name-box">
                      <p class="mb-2">${name}</p>
                    </div>
                    <td class="align-middle">
                      <p class="mb-0" style="font-weight: 500;">${id}</p>
                    </td>
                    <td>
                        <input id="quantity" type="number" class="quantity" value="1">
                    </td>
                    <td class="align-middle">
                      <p id="price" data-price="${price}" class="mb-0" style="font-weight: 500;">${price} USD</p>
                    </td>
                    
                  </div>
               
             </tr>`

}

function sumPrice(price) {
    const total = document.querySelector('#total-price');
    const quantity = document.querySelector('#quantity').value;
    total.textContent = (parseFloat(price) * quantity).toString() + " USD";
}


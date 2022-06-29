export function cartFactory({name, price, id}) {
    const tbody = document.querySelector('#table-root')
    let content = createBlock(name, price, id)
    tbody.insertAdjacentHTML('beforeend', content)

}

function createBlock(name, price, id) {
    return `<tr><th scope="row">
                  <div class="d-flex align-items-center">
                    <img src="static/img/product_${id}.jpg" class="img-fluid rounded-3"
                      style="width: 120px;" alt="Book">
                    <div class="flex-column ms-4">
                      <p class="mb-2">${name}</p>
                    </div>
                  </div>
                </th>
                 <td class="align-middle">
                  <p class="mb-0" style="font-weight: 500;">${id}</p>
                </td>
                <td class="align-middle">
                  <div class="d-flex flex-row">
                    <button class="btn btn-link px-2"
                      onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                      <i class="fas fa-minus"></i>
                    </button>

                    <input id="form1" min="0" name="quantity" value="2" type="number"
                      class="form-control form-control-sm" style="width: 50px;" />

                    <button class="btn btn-link px-2"
                      onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                      <i class="fas fa-plus"></i>
                    </button>
                  </div>
                </td>
                <td class="align-middle">
                  <p class="mb-0" style="font-weight: 500;">${price}</p>
                </td>
             </tr>`

}
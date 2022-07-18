import {cartFactory} from "./cartFactory.js";

initCart();

function initCart() {
    initAddToCart()
    addEventToCart()
}



function initAddToCart(){
    const addButtons = document.querySelectorAll('.add-to-cart')
    for (let button of addButtons){
        let buttonId = button.id
        button.addEventListener("click", ()=> initAddMovie(buttonId))
    }
}


async function initAddMovie(id){
    document.querySelector('#place-holder').innerHTML = "";
    let product = await getProduct(id)
    addEventToClosingModal(product)
    saveProductDetailsToMemory(product)


}

async function getProduct(id){
    const response = await fetch(`/api/movie?id=${id}`)
    return await response.json()
}

function addEventToCart() {
    const cartButton = document.querySelector('#cart');
    cartButton.addEventListener('click', () => {
        const product = JSON.parse(window.localStorage.getItem('product'))
        if (product !== null) {
            cartFactory(product)
        }

    })
}

function saveProductDetailsToMemory({name, price, id}) {

    const product = {
        name: name,
        price: price,
        id: id,
        quantity: 1,
    }
    window.localStorage.setItem('product', JSON.stringify(product))
}

function addEventToClosingModal(product) {
    const closeButton = document.querySelector('#cross');
    const cancelButton = document.querySelector('#close-modal-btn');

    closeButton.addEventListener("click", ()=>
        saveProductDetailsToMemory(product));

    cancelButton.addEventListener("click", () =>
        saveProductDetailsToMemory(product));
}
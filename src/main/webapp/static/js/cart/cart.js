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
        button.addEventListener("click", ()=> {
            initAddMovie(buttonId)
        })
        modifyCartBadge(button)
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

async function saveProductDetailsToMemory({name, price, id, quantity, userId, badge}) {

    const cart = {
        name, price, id, quantity, userId, badge
    }
    const response = await fetch(`/save_cart`, {
        method: "POST",
        body: cart,
    });
    if (response.ok) {
        alert("Cart saved");
    }


}

function addEventToClosingModal(product) {
    const closeButton = document.querySelector('#cross');
    const cancelButton = document.querySelector('#close-modal-btn');

    closeButton.addEventListener("click", ()=>
        saveProductDetailsToMemory(product));

    cancelButton.addEventListener("click", () =>
        saveProductDetailsToMemory(product));
}

function modifyCartBadge(button) {
    button.addEventListener("click", ()=> {
        const badge = document.querySelector('#s-c-badge');
        const badgeContent = parseInt(document.querySelector('#s-c-badge').textContent);
        badge.textContent = `${badgeContent+1}`
    })
}
